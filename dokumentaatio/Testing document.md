# Testing document

The program's logic has been tested using JUnit tests and the UI has been tested manually. The Junit tests can be found in the project folder:
```
TetrisBetter/src/test/java/tests
```

All classes in the domain package have been tested except the Controller class. This is because it can be seen as part of the UI since its only purpose is to take keyPressed inputs from the UI and call methods in the Logic class.

The package includes both tests on a smaller level that test the Stage and Tetramino class as well as tests that focus on the program's functionality as a whole in the Logic class. The Music class has also been tested but it does not cover a very large part of the program.

## Test coverage
Excluding the UI the tests' row coverage is 97% and the branch coverage is 93%. These numbers can vary since the creation of tetraminos include randomness. When a tetramino's shape is selected the program chooses one of the seven shapes available. This may cause the tests to not always go through all the branches.

![Jacoco report](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/jacoco.png)

## 