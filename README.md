# Arreglos de Objetos y Arreglos Dinámicos — curso

Curso corto de Java sobre arreglos de objetos y `ArrayList`, con la estructura del
[curso de programación de la Universidad de Helsinki](https://java-programming.mooc.fi/):
secciones cortas, ejercicios intercalados y corrección automática.

Abre `index.html` en el navegador para empezar.

## Contenido

| Parte | Tema | Ejercicios |
|---|---|---|
| 1 | Arreglos de objetos | 10 |
| 2 | Listas dinámicas (`ArrayList`) | 10 |
| 3 | Diseño con colecciones + sala de urgencias | 10 |
| 4 | Colecciones en el mundo real: Stack/Heap, `Iterator`, polimorfismo con interfaces, `List.of`/`List.copyOf`, `String.format` | 10 |

26 secciones, 40 ejercicios y 325 pruebas automáticas.

## Requisitos

Un JDK (Java 11 o superior). Nada más: el corrector es Java puro, sin Maven ni librerías externas.

```bash
java -version && javac -version
```

## Corregir ejercicios

```bash
./verificar.sh          # todos los ejercicios publicados
./verificar.sh 2        # toda la Parte 2
./verificar.sh 1.3      # solo el ejercicio 1.3
./verificar.sh 1.3 -s   # corre las pruebas contra la solución modelo
```

## Estructura

```
├── index.html, parteN.html      material del curso
├── styles.css, nav.js           presentación, progreso y quizzes
├── ejercicios/parteN/NN-nombre/ plantillas con TODO + pruebas
├── soluciones/parteN/NN-nombre/ soluciones modelo
├── herramientas/Prueba.java     librería de pruebas
└── verificar.sh                 corrector
```

El progreso de los ejercicios se guarda en el navegador (`localStorage`), así que las casillas que
marcas siguen marcadas la próxima vez que abras el curso.
