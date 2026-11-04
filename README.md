# Contador de frecuencia de palabras usando flujos de E/S en Java

## Problema
Se dispone de un archivo de texto que contiene un documento de longitud variable. Se requiere desarrollar una aplicación en Java
que permita al usuario proporcionar el nombre del archivo y determine cuántas veces aparece cada palabra.

## Objetivo de aprendizaje
Al finalizar la práctica, el estudiante será capaz de utilizar flujos de entrada y salida de caracteres en Java para leer y procesar un archivo de texto 
y generar un archivo de resultados, aplicando BufferedReader, PrintWriter, Path, Files, manejo de excepciones y estructuras de datos.

- Resultados de aprendizaje
- Representar archivos mediante Path.
- Verificar la existencia de un archivo mediante Files.
- Leer archivos de texto mediante BufferedReader.
- Procesar un archivo línea por línea.
- Normalizar y separar texto en palabras.
- Utilizar un Map para contabilizar frecuencias.
- Escribir resultados mediante PrintWriter.
- Utilizar try-with-resources para administrar recursos de E/S.
- Manejar errores mediante excepciones.
- Diferenciar las etapas de entrada, procesamiento y salida.

  ## Crear el proyecto
contador-palabras/

├── src/

│   └── ContadorPalabras.java

├── datos/

│   └── texto.txt

└── salida/



## Requerimientos obligatorios

Recibir el archivo mediante argumento.

Utilizar Path.

Comprobar el archivo mediante Files.exists().

Utilizar BufferedReader.

Procesar el documento línea por línea.

Ignorar diferencias entre mayúsculas y minúsculas.

Eliminar signos de puntuación.

Utilizar un Map<String,Integer>.

Determinar el total de líneas.

Determinar el total de palabras.

Determinar el número de palabras diferentes.

Identificar la palabra con mayor frecuencia.

Ordenar alfabéticamente las palabras.

Crear automáticamente el directorio de salida.

Utilizar PrintWriter.

Generar reporte-documento.txt. 

Utilizar try-with-resources.

Manejar adecuadamente IOException.
