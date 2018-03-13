#!/bin/bash

function fibonacci(){
	arg=$1
	if [[ $arg -le 0 ]]; then
		echo 0
	elif [[ $arg -le 1 ]]; then
		echo 1
	else
		first=$(($arg - 2))
		second=$(($arg - 1))
		a=$(fibonacci $first)
		b=$(fibonacci $second)
		r=$(( $a + $b ))
		echo $r
	fi
}

while [[ $# -gt 0 ]]; do
	arg=$1
	case $arg in
		-h|--help)
		echo "usage: ./fibonacci.sh [-h|--help]"
		echo "usage: ./fibonacci.sh [-f|--fibonacci <NUM>]"
		echo "usage: ./fibonacci.sh [-f|--fibonacci <NUM> -o|--output <FILENAME>]"						
		exit 1
		;;
		-f|--fibonacci)
			shift
			num=$1
		;;
		-o|--output)
			shift
			filename=$1
	esac
	shift
done

if [[ -e $filename ]]; then
	fibonacci $num > $filename
else
	fibonacci $num
fi