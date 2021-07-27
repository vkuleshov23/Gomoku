#!/bin/bash

cd /home/vadim/Labs/game/gomoku

files="./model/*.java ./view/*.java ./history/*.java ./saves/*.java"

compile="javac $files"

launch="java view.MainMenu"

$compile
$launch > ./logs/output.log

cd -