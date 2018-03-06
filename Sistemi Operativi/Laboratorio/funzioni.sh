#!/bin/bash

ARG=$1

func(){
    echo "dentro la funzione"
    echo $ARG
    echo $# #number of arguments
    echo $@ #all arguments
    shift #shifts args to the left
    echo $1
}
func a b c d e f g h i j