ConsistencyOfStatements
=================

This project solves the Consistency of Statements problem that checks wether the given file input with the parameters is either Satisfiable or Not Satisfiable. This is written in Python, and this is my first project working in Python, so I may return to clean up the code and make it more efficient at some point.

The type of file it takes in looks like:
3 3
x1 == x2
x2 == x3
x3 == x1

The first two numbers are the variables and constraints
This specific example  would give "Satisfiable", since it is possible.

This example below would be "Not Satisfiable"
3 3
x1 == x2
x2 == x3
x3 != x1