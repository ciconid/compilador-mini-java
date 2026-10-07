#!/bin/bash

DIR="${1:-.}"

archivos=(
    "build.gradle.kts"
    "gradle"
    "gradlew"
    "gradlew.bat"
    "resources"
    "settings.gradle.kts"
    "src"
)

for archivo in "${archivos[@]}"; do
    if [[ -e "$DIR/$archivo" ]]; then
        echo "OK: $archivo"
    else
        echo "FALTA: $archivo"
    fi
done

if compgen -G "$DIR/informe-etapa*.pdf" > /dev/null; then
    echo "OK: informe-etapa*.pdf"
else
    echo "FALTA: informe-etapa*.pdf"
fi