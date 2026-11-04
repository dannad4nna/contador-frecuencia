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

# Respuestas a las preguntas de la práctica

## Entrada, procesamiento y salida

| Elemento | Descripción |
|---|---|
| Entrada | Archivo de texto (`datos/texto.txt`) cuyo nombre se recibe como argumento de la línea de comandos. |
| Procesamiento | Leer línea por línea, pasar a minúsculas, eliminar signos de puntuación, separar en palabras y contabilizar las frecuencias en un `Map<String,Integer>`. |
| Salida | Archivo de texto (`salida/frecuencias.txt` o `salida/reporte-documento.txt`) con las palabras ordenadas y sus frecuencias; también se muestra un resumen en consola. |

**¿Flujo de bytes o de caracteres?**
De caracteres. El archivo contiene texto (con acentos y ñ) y lo que interesa son palabras, no bytes individuales. `BufferedReader` y `PrintWriter` son flujos de caracteres: se encargan de decodificar/codificar con un juego de caracteres (UTF-8 por defecto en `Files.newBufferedReader`), permiten leer por líneas con `readLine()` y escribir con `printf`/`println`. Con flujos de bytes tendría que decodificar manualmente los caracteres multibyte (por ejemplo `ó`, `ñ`), lo cual es propenso a errores.

 ## ¿Por qué recibir el nombre del archivo como argumento?

- El programa es reutilizable: sirve para cualquier archivo sin recompilar.
- Separa los datos de la lógica; el código no depende de una ruta fija que puede no existir en otra máquina.
- Facilita las pruebas (distintos archivos, archivos inexistentes) y la automatización desde scripts.

## ¿Qué ocurriría si no normalizamos las palabras?

Se contarían como palabras distintas variantes de la misma palabra: `Java`, `JAVA`, `java` y `java.` serían cuatro claves diferentes en el `Map`. Las frecuencias quedarían fragmentadas, el total de palabras diferentes se inflaría y la "palabra más frecuente" podría ser incorrecta.
