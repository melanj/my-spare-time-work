#include <iostream> 
#include <stdio.h>
#include <string>

using namespace std; 

string test(){
	try { 
		cout << "X";
		return "x";
  	} catch (...) { 

  	} finally {
		cout << "Y";
		return "y";
	}
}
 
int main() 
{ 
  cout << test() << "\n";
  return 0; 
}
