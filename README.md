# 3114tests
Contains test suites for CS 3114 projects (with specifications from McQuain summer 2015)

Tests are located in the their appropriate directories. Refer to the README files within a directory for 
instructions specific to that test suite. 

The tests are _not_ unit tests, rather they are more closely related to the [Curator](http://www.cs.vt.edu/curator/) system. At most, they will run a solution with command line arguments and possibly catch runtime errors. 

## How to use this repo
[![Click here for a .zip](http://imgur.com/aQ990lX.png "Click here for a .zip")](https://github.com/stuharvey/3114tests/archive/master.zip)

1. Clone it: 
2. Follow the instructions for the test you want to run. This will usually be along the lines of:
  1. Copy the complied .class files from your project into the test folder.
  2. `javac *.java` to compile the test files.
  3. `java test`
  4. Check out the results.

## How not to use this repo
**DO NOT** make any pull requests, issues, etc. which contain code, comments, or discussion of solutions to 
projects for this course. Everything about this repository is public; do not put yourself or others at risk of 
an honor violation by misunderstanding the 
[course policies](http://courses.cs.vt.edu/~cs3114/Summer15/3114Administration.pdf) (see p. 15). 
Things that are **not** acceptable:
> • Working with another student to derive a common program unless group work is explicitly allowed on that assignment.

> • Discussing the details required to solve a programming assignment. You may not share solutions.

> • Copying source code (programs) in whole or in part from someone else.

> • Copying files from another student's disk even though they might be unprotected.

Things that are acceptable:

> It _is_ acceptable to discuss with classmates a programming assignment in a general way, i.e., to
> discuss the nature of the assignment. In other words, you may discuss with your classmates what
> your program is required to accomplish but _not how to_ achieve that goal using Java. In no way
> should the individual statements of a program or the steps leading to the solution of the problem be
> discussed with or shown to anyone except those people cited in the following statement.

If you want to contribute, the code you provide should should not include any hints or information relating 
to the solution of any assignment for this course. That includes tests which assess the internal functions of a 
class or object, such as unit tests.

Any such violations or content which could be interpreted as a violation in part or whole will be immediately 
removed and reported to faculty. 

## Help
If you have issues running a test, [create an issue](https://github.com/stuharvey/3114tests/issues/new)
with a detailed description of the problem including any command line output, your OS, and any code 
snippets causing the crash.

## Contributing
When you find a logical error in a test or see a way to make it more robust, don't hesitate to code up the 
improvements yourself and [create a pull request](https://github.com/stuharvey/3114tests/compare). 
Improvements aren't necessarily limited to code, you may also contribute additional input files or (correct 
to specification) output files.

If you aren't familiar with git and aren't comfortable with pull requests you can create an issue then include your 
contribution in it.
