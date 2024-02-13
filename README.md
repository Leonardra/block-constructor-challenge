# Installation Guide

## Prerequisites
 - Java 21 JDK

## Steps

- Navigate to your terminal and pastee the command below
```shell
git clone https://github.com/Leonardra/block-constructor-challenge.git
```
- Enter into the directory
```shell
 cd block-constructor-challenge
```
- Compile project by pasting the following in your terminal

```shell
javac -d out src/blockConstructorChallenge/*.java  src/*.java
```

- Start the application by running this
```shell
java -cp out Main
```

The above command runs the application and generates a text file ```output.txt```. 
The output file contains the transaction IDs of the eligible transactions based on the
exercise.

Confirm the output file is generated in the main directory.
