#!/bin/bash
trap "exit" INT TERM
{
while IFS= read -r line
  do
    if [[ $line == *"statistics"* ]]; then
      echo "It's there!" 
	  kill -- -$BASHPID # kill all child process as we already have we what look for
	  exit 0
    fi
  done 
}< <(echo "8.8.8.8 8.8.8.4" | tr ' ' '\n' | xargs -L1 -I param -P 2 ping -c4 param)




