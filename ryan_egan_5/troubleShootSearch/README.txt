Ryan Egan
Assignment 5
CS442 Summer 2019

HOW TO COMPILE
While in the troubleShootSearch/src directory, run "ant all" to compile the program.

HOW TO CLEAN
While in the troubleShootSearch/src directory, run "ant clean" to remove the BUILD
directory, which includes .class files and the jar file.

HOW TO RUN
Before running, ensure that the input files are in the first "troubleShootSearch" directory, the same directory
that src and this README are located.
args:
<User input file> <output file> <synonym file> <debugLevel between 0 and 4>
Using ANT, an example line to run the program would be:
ant -Darg0=userInput.txt -Darg1=output.txt -Darg2=synonym.txt -Darg3=0 run
The files containing the technical sentences MUST be named as follows:
"technicalSentences1.txt"
"technicalSentences2.txt"
"technicalSentences3.txt"
"technicalSentences4.txt"
If they are not, the program will not recognize them; they must also be placed in the folder "ryan_egan_5",
next to the folder "troubleShootSearch".



The products are as follows:
Product 1: External HDD
Product 2: SSD
Product 3: Internal HDD
Product 4: External HDD for Xbox

The user input is matched as follows:
Lines 1-2: product 1 exact match
Lines 3-4: product 1 naive match
Lines 5-6: product 1 semantic match
Line 7: Miss
Lines 8-9: product 2 exact match
Lines 10-11: product 2 naive match
Lines 12-13: product 2 semantic match
Line 14: Miss
Lines 15-16: product 3 exact match
Lines 17-18: product 3 naive match
Lines 19-20: product 3 semantic match
Line 21: Miss
Lines 22-23: product 4 exact match
Lines 24-25: product 4 naive match
Lines 26-27: product 4 semantic match

Debug Levels:
0: Only error messages printed.
1: Only search results printed.
2: Input files opened by the program printed.
3: Successfully constructed objects printed.
4: Successful visits to visit() methods printed.