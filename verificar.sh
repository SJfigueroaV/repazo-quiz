#!/usr/bin/env bash
# Corrector de ejercicios del curso.
#
#   ./verificar.sh            corrige todos los ejercicios publicados
#   ./verificar.sh 1          corrige toda la Parte 1
#   ./verificar.sh 1.3        corrige solo el ejercicio 1.3
#   ./verificar.sh 1.3 -s     corrige la solución modelo del 1.3 (para comparar)

set -uo pipefail
cd "$(dirname "$0")"

if [[ -n "${NO_COLOR:-}" ]]; then
  AZUL=""; GRIS=""; NEGRITA=""; FIN=""
else
  AZUL=$(printf '\033[34m'); GRIS=$(printf '\033[90m')
  NEGRITA=$(printf '\033[1m'); FIN=$(printf '\033[0m')
fi

USAR_SOLUCION=0
OBJETIVO="${1:-}"
if [[ "${2:-}" == "-s" || "${2:-}" == "--solucion" ]]; then
  USAR_SOLUCION=1
fi

if ! command -v javac >/dev/null; then
  echo "No encontré javac. Instala un JDK (en Arch: sudo pacman -S jdk-openjdk)." >&2
  exit 1
fi

correr_uno() {
  local dir="$1"                                   # ejercicios/parte1/03-casillas-ocupadas
  local parte nombre ejercicio codigo_dir build titulo estado
  parte=$(basename "$(dirname "$dir")")            # parte1
  nombre=$(basename "$dir")                        # 03-casillas-ocupadas
  ejercicio="${parte#parte}.$((10#${nombre%%-*}))" # 1.3

  codigo_dir="$dir"
  if [[ $USAR_SOLUCION -eq 1 ]]; then
    codigo_dir="soluciones/$parte/$nombre"
    if [[ ! -d "$codigo_dir" ]]; then
      echo "No hay solución modelo para el ejercicio $ejercicio." >&2
      return 1
    fi
  fi

  titulo="${nombre#*-}"
  titulo="${titulo//-/ }"
  if [[ $USAR_SOLUCION -eq 1 ]]; then
    echo "${NEGRITA}Ejercicio $ejercicio: ${titulo}${FIN}${GRIS}  (solución modelo)${FIN}"
  else
    echo "${NEGRITA}Ejercicio $ejercicio: ${titulo}${FIN}"
  fi

  build="build/$parte/$nombre"
  rm -rf "$build"; mkdir -p "$build"

  if ! javac -encoding UTF-8 -nowarn -d "$build" \
        herramientas/Prueba.java "$codigo_dir"/*.java "$dir"/pruebas/*.java 2> "$build/errores.txt"; then
    echo "  ${GRIS}No compila:${FIN}"
    sed 's/^/      /' "$build/errores.txt" | head -20
    echo
    return 1
  fi

  java -Dfile.encoding=UTF-8 -cp "$build" Pruebas
  estado=$?
  echo
  return $estado
}

listar() {
  if [[ -z "$OBJETIVO" ]]; then
    find ejercicios -mindepth 2 -maxdepth 2 -type d | sort
  elif [[ "$OBJETIVO" =~ ^[0-9]+$ ]]; then
    find "ejercicios/parte$OBJETIVO" -mindepth 1 -maxdepth 1 -type d 2>/dev/null | sort
  elif [[ "$OBJETIVO" =~ ^([0-9]+)\.([0-9]+)$ ]]; then
    local p="${BASH_REMATCH[1]}" n="${BASH_REMATCH[2]}"
    find "ejercicios/parte$p" -mindepth 1 -maxdepth 1 -type d -name "$(printf '%02d' "$n")-*" 2>/dev/null
  else
    echo "Uso: ./verificar.sh [parte | parte.ejercicio] [-s]" >&2
    exit 1
  fi
}

mapfile -t DIRS < <(listar)
if [[ ${#DIRS[@]} -eq 0 ]]; then
  echo "No encontré ejercicios para '$OBJETIVO'." >&2
  exit 1
fi

echo
resueltos=0
for dir in "${DIRS[@]}"; do
  if correr_uno "$dir"; then
    resueltos=$((resueltos + 1))
  fi
done

if [[ ${#DIRS[@]} -gt 1 ]]; then
  echo "${AZUL}${NEGRITA}Resumen: $resueltos de ${#DIRS[@]} ejercicios resueltos.${FIN}"
  echo
fi

[[ $resueltos -eq ${#DIRS[@]} ]]
