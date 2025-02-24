#!/bin/bash

mvn clean test

if [ $? -eq 0 ]; then
    echo "Testes passaram. Realizando o push para o GitHub..."

    git add .

    git commit -m "Alterações após execução de testes"

    git push origin --all
else
    echo "Testes falharam. Não será realizado o push."
fi