#!/bin/bash
echo "Crea un file 'semaforo.txt'"
while [[ -e "semaforo.txt"]]; do sleep 3; #TODO