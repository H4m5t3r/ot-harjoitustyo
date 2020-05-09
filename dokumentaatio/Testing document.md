# Testing document

The program's logic has been tested using JUnit tests and the UI has been tested manually. The JUnit tests can be found in the "Test packages" section in NetBeans or the project folder:
```
TetrisBetter/src/test/java/tests
```

All classes in the domain package have been tested except the Controller class. This is because it can be seen as part of the UI since its only purpose is to take keyPressed inputs from the UI and call methods in the Logic class.

The package includes both tests on a smaller level that test the Stage and Tetramino class as well as tests that focus on the program's functionality as a whole in the Logic class. The Music class has also been tested but it does not cover a very large part of the program.

## Test coverage
Excluding the UI the tests' row coverage is 97% and the branch coverage is 93%. These numbers can vary since the creation of tetraminos include randomness. When a tetramino's shape is selected the program chooses one of the seven shapes available. This may cause the tests to not always go through all the branches.

![Jacoco report](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/jacoco.png)

## UI testing and configuration 
The UI has been tested manually. All features listed in the [project's specifications](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md) work and all visual details are displayed correctly.

## Configuration on other devices
The program works as it should on Linux devices. The program has been tested manually using a virtual Linux environment. When the program is downloaded it is important to place the music and background files in the TetrisBetter folder. If the program does not find the music files or the backgrounds it will print an error message asking the user if the files are located in the project folder.