#include <stdlib.h>
#include <stdio.h>
#include <stddef.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <errno.h>
#include <termios.h>
#include <sys/ioctl.h>
#include <sys/stat.h>

#if defined(__linux__)
# define MODEM "/dev/ttyACM0"
#elif defined(__APPLE__)
# define MODEM "/dev/cu.usbmodem0000001"
#elif defined(__NetBSD__)
# define MODEM "/dev/dtyU0"
#elif defined(__bsdi__) || defined(__DragonFly__)
# define MODEM "/dev/cuaU0"
#endif

static void make_blocking(int fd)
{
    const int old = fcntl(fd, F_GETFL, 0);
    fcntl(fd, F_SETFL, old & ~(int)O_NONBLOCK);
}

static void make_nonblocking(int fd)
{
    const int old = fcntl(fd, F_GETFL, 0);
    fcntl(fd, F_SETFL, old | (int)O_NONBLOCK);
}

/* gcc -Wall -g3 -O1 -std=c99 modem-read.c -o modem-read */
int main(int argc, char* argv[])
{
    int fd = open(MODEM, O_RDWR | O_NOCTTY | O_SYNC);
    if (fd == -1) {
        printf("open failed\n");
        goto finish;
    }

    printf("Setting TIOCEXCL\n");

    /* Mark the fd as exclusive so ModemManager     */
    /* and friends cannot open and muck with state. */
    if (ioctl(fd, TIOCEXCL, NULL) == -1) {
        printf("ioctl failed\n");
        goto finish;
    }

    printf("Getting tty\n");

    struct termios tty;
    if (tcgetattr(fd, &tty) != 0) {
        printf("tcgetattr failed\n");
        goto finish;
    }

    printf("Setting tty options\n");

    cfmakeraw(&tty);
    tty.c_cflag |= (CLOCAL | CRTSCTS);
    // tty.c_cflag &= ~CSTOPB;  /* 1 stop bit */
    // tty.c_cflag |=  CSTOPB;  /* 2 stop bit */

    cfsetospeed(&tty, B57600);
    cfsetispeed(&tty, B57600);

    printf("Flushing tty\n");

    if (tcflush(fd, TCIOFLUSH) != 0) {
        printf("tcflush failed\n");
        goto finish;
    }

    printf("Setting tty\n");

    if (tcsetattr(fd, TCSANOW, &tty) != 0) {
        printf("tcsetattr failed\n");
        goto finish;
    }

    /*********** Write ***********/

    printf("Writing ATZ\n");

    ssize_t res = write(fd, "ATZ\r", 4);
    if (res == -1) {
        printf("write failed\n");
        goto finish;
    }

    printf("Waiting for write\n");

    res = tcdrain(fd);
    if (res == -1) {
        printf("tcdrain failed\n");
        goto finish;
    }

    printf("Wrote: ATZ\n");

    /*********** Read ***********/

    printf("Reading response\n");

    make_blocking(fd);

    for ( ; ; )
    {
        unsigned char buf[512];
        res = read(fd, buf, sizeof(buf));
        if (res == -1 && errno == EWOULDBLOCK) {
            break;
        }
        else if (res == -1) {
            printf("read failed\n");
            goto finish;
        }

        make_nonblocking(fd);

        buf[res] = '\0';
        printf("Read: %s\n", buf);
    }

finish:

    if (fd != -1)
        close(fd);

    return 0;
}
