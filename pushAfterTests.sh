#!/bin/bash

# Executando os testes
mvn clean test

# Verificando se os testes passaram
if [ $? -eq 0 ]; then
    echo "Testes passaram. Realizando o push para o GitHub..."

    # Adicionando mudanças
    git add .

    # Commitando as mudanças
    git commit -m "Alterações após execução de testes"

    # Realizando o push para o repositório remoto
    git push origin main
else
    echo "Testes falharam. Não será realizado o push."
fi