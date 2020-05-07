# Tetris

This repository contains a Tetris project for the course "Ohjelmistotekniikka" (Software Development Methods). The purpose of this project is to create a replica of the classig video game Tetris with a menu and (at the time of writing) options to change the background image and the music that is playing. More information can be found in the requirement specification document.

## Documentation
[Specifications](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md)

[Description of the program's architecture](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[User manual](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/User%20manual.md)

[Work time log](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/Tuntikirjanpito.md)


## Releases
[Week 5](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/viikko5)

[Week 6](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/viikko6)

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
