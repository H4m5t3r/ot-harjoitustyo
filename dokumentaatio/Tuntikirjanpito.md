# Work time log

**Total amount of hours spent: 106**
| day | time | what I did  |
| :----:|:-----| :-----|
| 19.3 | 1    | I read through the instructions and checked how the project directory should be structured |
||1| I looked up tutorials for making a Tetris game that I could have use of during the project |
|20.3|2| I planned the structure of the program and wrote down the requirement specifications |
|28.3|2| I created a Maven project in NetBeans and added it to the repository. I also made sure everything was working, added everything needed for tests, etc in the pom-file and tested the project on VMWare to check that the project could be run on the university's systems. |
||2| I worked on the game part of the project. |
|29.3|2| I completed a working (but buggy) version of Tetris |
||3| I did some debugging, created a test and started updating the project's documentation |
|30.3|1| I finished this week's documentation |
|4.4|3| I created a menu for the game. This took more time than it should have because I tried to get JavaFX Scene Builder to work with NetBeans but there were no instructions on how to do this in the course material and I could not get it to work on my own so in the end I had to make the menu from basic JavaFX code. |
||4| I worked on making the program play music and started integrating the menu with the game. |
|6.4|6| I added Checkstyle to the project and made separate packages for the game logic, the user interface and the main class. I fixed Checkstyle errors and worked on getting the game screen to work outside of the Tetris class. |
|7.4|2| I spent some tie fixing the bugs in the game logic. These included the polygons not getting different colors and being rotated wierdly. The game part works as it should now. |
||4| I tried to make the game work when the user interface is separated from the Tetris class. Right now it does not work properly and causes errors for some reason. |
||1| I tried to create more tests but ran into trouble since the variables in the Tetris class have been moved. When the tests start they fail to initialize the class since it includes variables that at the moment refer values in TetrisUI. |
||1| Updated the documentation. |
|16.4|5| I decided to redesign the structure of the game to correct the Checkstyle errors and hopefully fix some bugs at the same time. |
|17.4|6| I started rebuilding the game in a new folder called "TetrisRethought". |
|18.4|4| I got some tips on how I could improve the game logic and stopped working on TetrisRethought. The project is now located in the folder called "TetrisBetter" |
|19.4|6| I spent the day processing the idea of the new structure and worked on implementing JavaFX |
|20.4|7| I completed more methods in the game logic, created the Music class and worked on tests. |
|21.4|5| I created more tests to cover more of the game's logic, updated the documentation and everything else that needed to be done before this week's deadline. |
|22.4|4| I implemented a Java Timer to make the game logic run in a cycle. The game logic works now. |
|24.4|5| I worked on the UI. I spent the day trying to make the methods that update the game pane work without any success. |
|25.4|4| I finally managed to make the game screen update itself. |
|26.4|5| Added JavaDoc descriptions and more tests. |
|28.4|4| Added a user manual and updated the architecture description as well as the rest of the documentation. |
|6.5|4| Added a live score counter to the game and updated the look of the menu. |
|7.5|5| I added sequence diagrams to the architecture description and updated some sections of the documentation. Minor updates to the JUnit tests |
|8.5|4| I wrote the testing document, made a new release, updated the documentation and added error messages to the Music class and the UI. |
|9.5|3| I read throught the documentation and did some testing to make sure everything was in order. |