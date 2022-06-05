#!/bin/bash

echo "Hello, Compiler!"

mkdir build/

javac -cp src/ src/*.java -d build/

cd build/

echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Class-Path: ." >> MANIFEST.MF
echo "Main-Class: App" >> MANIFEST.MF

# Thank you
# https://www.tecmint.com/create-and-execute-jar-file-in-linux/
jar cvmf MANIFEST.MF Game.jar App.class