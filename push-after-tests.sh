#!/bin/bash

mvn clean test

if [ $? -eq 0 ]; then
    echo "Todos os testes passaram. Realizando o push para o GitHub e GitLab..."

    git add .

    git commit -m "Alterações após execução de testes"

    git push origin --all
else
    echo "Testes falharam. Push não realizado"
fi