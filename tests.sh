#!/bin/bash

cd /home/vadim/Labs/game/gomoku


files="./model/*.java ./view/*.java ./ai/*.java ./history/*.java ./tests/*.java ./saves/*.java"

compile="javac $files"

launch="java tests.Test"

$compile
$launch

cd -