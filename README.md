# ms-recursos-digitales

Microservicio de Recursos Digitales — Biblioteca Digital EDUCA+
Asignatura: Java: Diseño y Construcción de Soluciones Nativas en Nube

## Propósito general
Gestionar la visualización y descarga de recursos digitales como ebooks, artículos y revistas.

## Funciones clave
- Listar los recursos digitales disponibles
- permitir su visualización en línea 
- descargar los archivos.

## Interacciones con otros microservicios
Consulta a ms-usuarios para verificar los permisos de acceso según el tipo de usuario.

## Justificación del aislamiento
Tiene una lógica diferente a los préstamos físicos y puede requerir almacenamiento especializado, por lo que separarlo facilita la mantenibilidad y el uso de tecnologías adecuadas.

## Tecnología
- Java 17 + Spring Boot (Spring Web)
- Maven
- Almacenamiento: Object Storage (ej. AWS S3 / Azure Blob Storage) —
  para archivos de ebooks/PDFs, en vez de base de datos relacional
- Base de datos: NoSQL o SQL liviano para metadatos del recurso (título,
  autor, tipo, tamaño)
- Comunicación: REST API (vía API Gateway)
