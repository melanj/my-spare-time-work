#include <stdio.h>
#include <setjmp.h>
 
static jmp_buf exception_buf;
#define try if(setjmp(exception_buf) == 0)
#define catch else
#define throw() longjmp(exception_buf, 1)
 
int main(void)
{
  try
  {
    puts("I am in a try block.");
    //throw();
    puts("I will not be seen.");
  }
  catch
  {
    puts("Exception caught.");
  }
 
  return 0;
}
