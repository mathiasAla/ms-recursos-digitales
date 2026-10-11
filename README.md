# ms-recursos-digitales

Microservicio de Recursos Digitales - Biblioteca Digital EDUCA+
Asignatura: Java: Diseño y Construcción de Soluciones Nativas en Nube

## Propósito
Gestionar el catálogo de recursos digitales (ebooks, artículos y revistas):
consulta, búsqueda, administración y registro de descargas.

## Tecnologías
- Java 21
- Spring Boot 3.3.0 (Web, Data JPA, Validation)
- MySQL 8
- Maven

## Estructura
```
src/main/java/com/educa/msrecursosdigitales/
├── controller/   Endpoints REST
├── service/      Lógica de negocio
├── repository/   Acceso a datos (Spring Data JPA)
├── model/        Entidad RecursoDigital y enum TipoRecurso
└── exception/    Manejo global de errores
```

## Requisitos previos
- JDK 21
- Maven 3.9 o superior
- MySQL 8 en ejecución
- Git

Este microservicio es independiente: no necesita que otros estén en ejecución.

## Cómo ejecutarlo

1. Clonar el repositorio:
```bash
git clone https://github.com/mathiasAla/ms-recursos-digitales.git
cd ms-recursos-digitales
```

2. Crear la base de datos en MySQL:
```sql
CREATE DATABASE db_recursos;
```

3. Editar `src/main/resources/application.properties` y colocar el usuario y
la contraseña de MySQL:
```properties
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

4. Compilar y empaquetar (genera `target/ms-recursos-digitales-1.0.0.jar`):
```bash
mvn clean package
```

5. Ejecutar:
```bash
java -jar target/ms-recursos-digitales-1.0.0.jar
```
También se puede usar `mvn spring-boot:run`. El servicio queda en
`http://localhost:8084`. Las tablas se crean automáticamente al iniciar.

6. (Opcional) Cargar datos de ejemplo, con la aplicación ya iniciada una vez:
```bash
mysql -u root -p < docs/datos_iniciales.sql
```

7. Probar: importar `docs/ms-recursos-digitales.postman_collection.json` en Postman.

## Endpoints

| Método | Ruta | Descripción | Código |
|---|---|---|---|
| GET | `/api/recursos` | Listar recursos | 200 |
| GET | `/api/recursos/{id}` | Obtener un recurso | 200 / 404 |
| GET | `/api/recursos/buscar?texto=` | Buscar por título o autor | 200 |
| GET | `/api/recursos/tipo/{tipo}` | Filtrar por tipo | 200 / 400 |
| POST | `/api/recursos` | Crear recurso | 201 / 400 |
| PUT | `/api/recursos/{id}` | Actualizar recurso | 200 / 400 / 404 |
| DELETE | `/api/recursos/{id}` | Eliminar recurso | 204 / 404 |
| POST | `/api/recursos/{id}/descargar` | Registrar una descarga | 200 / 404 |

Tipos válidos: `EBOOK`, `ARTICULO`, `REVISTA`.

### Ejemplo: crear un recurso
```json
POST /api/recursos
{
  "titulo": "Frankenstein",
  "autor": "Mary Shelley",
  "tipo": "EBOOK",
  "formato": "EPUB",
  "urlArchivo": "/recursos/frankenstein.epub"
}
```

## Alcance
El servicio gestiona los metadatos de cada recurso y el contador de descargas.
El almacenamiento físico de los archivos (por ejemplo, un servicio de object
storage) queda fuera del alcance de esta versión: `urlArchivo` es una referencia.

## Control de versiones
Ramas: `main` (versión estable), `develop` (integración) y `feature/*`
(cada funcionalidad), integradas mediante Pull Request.