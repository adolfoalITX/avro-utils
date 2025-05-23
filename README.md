# avro-utils

Herramienta en Java para la generación y manipulación de archivos Avro (AVSC) a partir de archivos Avro IDL (AVDL).

## Descripción
Este proyecto permite convertir archivos `.avdl` en esquemas Avro `.avsc` y mostrar su contenido en formato JSON legible. Utiliza Apache Avro y otras librerías para el procesamiento y formateo de los datos.

## Requisitos
- Java 11 o superior
- Maven

## Instalación
Clona el repositorio y navega al directorio del proyecto:
```bash
git clone <repo-url>
cd avro-utils
```

Instala las dependencias y compila el proyecto:
```bash
mvn clean package
```

## Uso
Para ejecutar la aplicación y convertir un archivo `.avdl` a JSON:
```bash
java -cp target/AvroUtils-1.0.0.jar com.inditex.AvroUtils.AvroUtilsApplication <ruta/al/archivo.avdl>
```

Ejemplo:
```bash
java -cp target/AvroUtils-1.0.0.jar com.inditex.AvroUtils.AvroUtilsApplication schemas/ejemplo.avdl
```

Esto imprimirá el contenido del esquema Avro en formato JSON por consola.

## Dependencias principales
- [Apache Avro](https://avro.apache.org/) 1.9.2
- [json-path](https://github.com/json-path/JsonPath) 2.4.0
- [Jackson Databind](https://github.com/FasterXML/jackson-databind)

## Estructura del proyecto
- `src/main/java/com/inditex/AvroUtils/AvroUtilsApplication.java`: Clase principal de la aplicación.
- `src/main/resources/`: Recursos y configuración.
- `pom.xml`: Gestión de dependencias y build con Maven.

## Licencia
MIT