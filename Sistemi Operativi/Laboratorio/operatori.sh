#!/bin/bash
echo "Inserisci un carattere e premi INVIO"
read char
case $char in 
    y|Y) echo "Input: y";; #y OR Y
    n) echo "Input: n";;
    *) echo "Input: ne' y ne' n";;
esac