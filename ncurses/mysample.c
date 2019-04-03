#include <stdlib.h>
#include <curses.h>
#include <signal.h>
#include <panel.h>
#include <menu.h>

static void finish(int sig);

int main(int argc, char *argv[])
{
    WINDOW *window;
	PANEL  *panel;
	int lines, cols, y = 2, x = 4, ch;

    signal(SIGINT, finish);      /* arrange interrupts to terminate */

    initscr();      /* initialize the curses library */
    keypad(stdscr, TRUE);  /* enable keyboard mapping */
    nonl();         /* tell curses not to do NL->CR/NL on output */
    cbreak();       /* take input chars one at a time, no wait for \n */
	getmaxyx(stdscr,lines,cols);	

	/* Initialize all the colors */
	init_pair(1, COLOR_RED, COLOR_BLACK);
	init_pair(2, COLOR_GREEN, COLOR_BLACK);
	init_pair(3, COLOR_BLUE, COLOR_BLACK);
	init_pair(4, COLOR_CYAN, COLOR_BLACK);

	/* Create a window for the panel */
	window = newwin(lines -4, cols -6, y, x);

	/* Create borders around the windows */
	box(window, 0, 0);

	/* Attach a panel to each window */ 	
	panel = new_panel(window);
	/* Update the stacking order */
	update_panels();

	/* Show it on the screen */
	attron(COLOR_PAIR(4));
	mvprintw(LINES - 2, 0, "F10 to Exit");
	attroff(COLOR_PAIR(4));
	doupdate();
	
	while((ch = getch()) != KEY_F(10)){
	}
	finish(0);
}

static void finish(int sig)
{
    endwin();
    exit(0);
}

