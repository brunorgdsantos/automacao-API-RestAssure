#!/bin/bash

mvn clean test

if [ $? -eq 0 ]; then
    echo "Todos os testes passaram! Realizando push para o GitHub e GitLab Simultaneamente."

    mvn allure:serve

    git add .

    git commit -m "Alterações após execução de testes"

    git push origin --all
else
    echo "Testes falharam. Push não realizado"
fi