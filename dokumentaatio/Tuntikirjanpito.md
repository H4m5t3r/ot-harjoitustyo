# Work time log

**Total time spent: 34,5**
| day | time | what I did  |
| :----:|:-----| :-----|
| 19.3 | 1    | I read through the instructions and checked how the project directory should be structured |
||1| I looked up tutorials for making a Tetris game that I could have use of during the project |
|20.3|2| I planned the structure of the program and wrote down the requirement specifications |
|28.3|2| I created a Maven project in NetBeans and added it to the repository. I also made sure everything was working, added everything needed for tests, etc in the pom-file and tested the project on VMWare to check that the project could be run on the university's systems. |
||2| I worked on the game part of the project. |
|29.3|2| I completed a working (but buggy) version of Tetris |
||2,5| I did some debugging, created a test and started updating the project's documentation |
|30.3|1| I finished this week's documentation |
|4.4|3| I created a menu for the game. This took more time than it should have because I tried to get JavaFX Scene Builder to work with NetBeans but there were no instructions on how to do this in the course material and I could not get it to work on my own so in the end I had to make the menu from basic JavaFX code. |
||4| I worked on making the program play music and started integrating the menu with the game. |
|6.4|6| I added Checkstyle to the project and made separate packages for the game logic, the user interface and the main class. I fixed Checkstyle errors and worked on getting the game screen to work outside of the Tetris class. |
|7.4|2| I spent some tie fixing the bugs in the game logic. These included the polygons not getting different colors and being rotated wierdly. The game part works as it should now. |
||4| I tried to make the game work when the user interface is separated from the Tetris class. Right now it does not work properly and causes errors for some reason. |
||1| I tried to create more tests but ran into trouble since the variables in the Tetris class have been moved. When the tests start they fail to initialize the class since it includes variables that at the moment refer values in TetrisUI. |
||1| Updated the documentation. |