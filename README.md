# Tetris

This repository contains a Tetris project for the course "Ohjelmistotekniikka" (Software Development Methods). The purpose of this project is to create a replica of the classig video game Tetris with a menu and (at the time of writing) options to change the background image and the music that is playing. More information can be found in the requirement specification document.

## Documentation
[Requirement specification](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md)

[Package diagram](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Work time log](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/Tuntikirjanpito.md)

## Useful commands
**Use these commands in the folder named "Tetris".**

Run the program:
```
mvn compile exec:java -Dexec.mainClass=tetris.mainclass.Main
```

Run the tests:

```
mvn test
```

Run the tests and generate a JaCoCo report:

```
mvn test jacoco:report
```

Run the Checkstyle tests
```
mvn jxr:jxr checkstyle:checkstyle
```