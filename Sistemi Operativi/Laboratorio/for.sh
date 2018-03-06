#!/bin/bash
for ((i = 1, j = 1; i<= 10; i += 1, j*=2)); do
    echo "(i="$i, "j="$j")"
done