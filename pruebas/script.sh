#!/bin/bash
clear

echo -e 'Analizador léxico:\n\n'

cd Analizador/alex/
java -cp jlex.jar JLex.Main AnalizadorLexico.l
mv AnalizadorLexico.l.java AnalizadorLexico.java
cd ../..

echo -e '\n\nAnalizador sintáctico:\n\n'

java -cp cup.jar java_cup.Main -parser AnalizadorSintactico -symbols ClaseLexica -nopositions Analizador/asint/Lenguaje.cup
mv AnalizadorSintactico.java Analizador/asint/AnalizadorSintactico.java
mv ClaseLexica.java Analizador/asint/ClaseLexica.java

echo -e '\n\n'

cd Analizador/
javac -cp "../cup.jar" alex/*.java asint/*.java errors/*.java ast/*.java
java -cp ".:../cup.jar" asint.Main ../input.txt

cd ..

echo -e '\n\n'
