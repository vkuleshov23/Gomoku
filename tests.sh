#!/bin/bash

cd /home/vadim/Labs/game/gomoku


files="./model/*.java ./history/*.java ./tests/*.java"

compile="javac $files"

launch="java tests.GomokuTests"

$compile
$launch

cd -