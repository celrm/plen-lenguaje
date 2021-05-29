#!/bin/bash
clear

file=$1 

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
java -cp ".:../cup.jar" asint.Main "../$file.txt"

echo -e '\n\n'


for f in ../$file.txt; do
    if [ -f $f ]; then
    echo -e "Programa $f\n\n"
    fi
    cd ..
    
    echo -e '\n\nEjecución del código:\n\n'
    
    aux="${f%.*}"
    base="$(basename "$aux")"
    notxt=${aux:3}
    wabt/bin/wat2wasm "$notxt.wat"
    mv "$base.wasm" "$notxt.wasm"
    node "main.js" $notxt
    
    cd Analizador/
    
done
cd ..
