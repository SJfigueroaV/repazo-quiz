# Arreglos de Objetos y Arreglos Dinámicos — curso

Curso corto de Java sobre arreglos de objetos y `ArrayList`, con la estructura del
[curso de programación de la Universidad de Helsinki](https://java-programming.mooc.fi/):
secciones cortas, ejercicios intercalados y corrección automática.

Abre `index.html` en el navegador para empezar.

## Contenido

| Parte | Tema | Estado |
|---|---|---|
| 1 | Arreglos de objetos | **publicada** (10 ejercicios) |
| 2 | Listas dinámicas (`ArrayList`) | en camino |
| 3 | Diseño con colecciones + proyecto final | en camino |

## Requisitos

Un JDK (Java 8 o superior). Nada más: el corrector es Java puro, sin Maven ni librerías externas.

```bash
java -version && javac -version
```

## Corregir ejercicios

```bash
./verificar.sh          # todos los ejercicios publicados
./verificar.sh 1        # toda la Parte 1
./verificar.sh 1.3      # solo el ejercicio 1.3
./verificar.sh 1.3 -s   # corre las pruebas contra la solución modelo
```

## Estructura

```
├── index.html, parte1.html      material del curso
├── styles.css, nav.js           presentación, progreso y quizzes
├── ejercicios/parte1/NN-nombre/ plantillas con TODO + pruebas
├── soluciones/parte1/NN-nombre/ soluciones modelo
├── herramientas/Prueba.java     librería de pruebas
└── verificar.sh                 corrector
```

El progreso de los ejercicios se guarda en el navegador (`localStorage`), así que las casillas que
marcas siguen marcadas la próxima vez que abras el curso.
