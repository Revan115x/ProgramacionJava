#!/bin/bash

cd /home/inf1/Desktop/Programacion/ProgramacionJava || exit 1

git add .

git commit -m"Actualización automática" || true

git push origin main