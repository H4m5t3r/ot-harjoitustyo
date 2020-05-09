# Tetris

This repository contains a Tetris project for the course "Ohjelmistotekniikka" (Software Development Methods). The purpose of this project is to create a replica of the classig video game Tetris with a menu and (at the time of writing) options to change the background image and the music that is playing. More information can be found in the [specification document](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md).

The directory where the program is located is called TetrisBetter. The purpose of this name is not to imply that this would be a better version of Tetris, but to tell the difference between the current version and another folder that was used earlier. This folder was called Tetris but was later removed and replaced with TetrisBetter when the structure of the program was remade to make it more effective and easier to maintain. The old Tetris folder is no longer included in the repository.

## Documentation
[Specifications](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md)

[Description of the program's architecture](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[User manual](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/User%20manual.md)

[Testing document](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/Testing%20document.md)

[Work time log](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/Tuntikirjanpito.md)


## Releases
[Week 5](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/viikko5)

[Week 6](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/viikko6)

[Final release](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/FINAL)

## Useful commands
**Use these commands in the folder named "TetrisBetter".**

Run the program:
```
mvn compile exec:java -Dexec.mainClass=tetris.main.Main
```

Run the tests:
```
mvn test
```

Run the tests and generate a JaCoCo report:
```
mvn test jacoco:report
```

Run the Checkstyle tests:
```
mvn jxr:jxr checkstyle:checkstyle
```

Create a jar file:
```
mvn package
```

Generate a JavaDoc:
```
mvn javadoc:javadoc
```
