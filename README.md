# Million Bank Balance Puzzle
This is the solution for this week's Matt Parker's Maths Puzzle.

## Overview
A bank is running a competition. You can make two deposits (of integer pounds) on two consecutive days and everyday the bank will add your last two balances together to give you a new balance.

For example: You deposit £10 on day 1 and £20 on day 2. Your balance on day 1 would be £10, day 2 £30, day 3 £40, day 4 £70 and so on.....

You can keep the money if your balance eventually equals one million pounds exactly. If more than one person hits a million exactly, the prize goes to the person who took the longest to get there. 

[Matt's Video](https://youtu.be/ILrqPpLpwpE)

## My solution
I brute force my way through every plausible combination of first and second deposits. First deposit goes from $0 to $999,999 and the second deposit can be anywhere from $1 to $1,000,000. 
I did not allow (1,000,000, 0) because it is the same as (0, 1,000,000). **Note** this is not the same thing for all values, just these two and any others that directly add to $1,000,000.

## To run
Open in any java IDE such as eclipse. After you run the Main class, type 'n' or 'numbers' to test just 2 numbers or 'f' or 'full' to run the full brute force suite.
