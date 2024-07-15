
```markdown
# Foro API

Foro API es una API REST construida con Java Spring Boot que proporciona funcionalidades para gestionar un foro. La API soporta operaciones CRUD (Create, Read, Update, Delete) para los tópicos del foro y utiliza JWT para autenticación y autorización.

## Requisitos

- Java 17+
- Maven 4+
- MySQL

## Tecnologías Utilizadas

- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Flyway
- Lombok
- MySQL

## Configuración del Proyecto

### Dependencias

Las dependencias del proyecto se gestionan con Maven. Aquí tienes una lista de las dependencias principales:

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-web`
- `spring-boot-devtools`
- `spring-boot-starter-validation`
- `spring-boot-starter-test`
- `spring-security-test`
- `mysql-connector-java`
- `flyway-core`
- `jjwt`
- `lombok`

### Estructura del Proyecto

```
foro-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── foro/
│   │   │           ├── controller/
│   │   │           │   ├── JwtAuthenticationController.java
│   │   │           │   └── TopicController.java
│   │   │           ├── entity/
│   │   │           │   ├── Topic.java
│   │   │           │   ├── Status.java
│   │   │           │   └── UserDTO.java
│   │   │           ├── repository/
│   │   │           │   ├── TopicRepository.java
│   │   │           │   └── UserRepository.java
│   │   │           ├── security/
│   │   │           │   ├── JwtAuthenticationEntryPoint.java
│   │   │           │   ├── JwtRequestFilter.java
│   │   │           │   ├── JwtTokenUtil.java
│   │   │           │   └── SecurityConfig.java
│   │   │           ├── service/
│   │   │           │   ├── JwtUserDetailsService.java
│   │   │           │   └── TopicService.java
│   │   │           ├── model/
│   │   │           │   ├── JwtRequest.java
│   │   │           │   └── JwtResponse.java
│   │   │           └── ForoApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │               └── V1__Create_Topic_Table.sql
│   └── test/
│       └── java/
│           └── com/
│               └── foro/
│                   └── ForoApiApplicationTests.java
└── pom.xml
```

### Configuración de la Base de Datos

La configuración de la base de datos se encuentra en el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
spring.datasource.username='Aqui pones la password de tu bd'
spring.datasource.password='Aqui pones la password de tu bd'
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret='Crear una secret key"
```

### Migraciones de Base de Datos

El proyecto utiliza Flyway para manejar migraciones de base de datos. El archivo de migración inicial se encuentra en `src/main/resources/db/migration/V1__Create_Topic_Table.sql`.

```sql
CREATE TABLE topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL
);
```

## Ejecución del Proyecto

1. Clona el repositorio.
2. Configura tu base de datos MySQL y actualiza las credenciales en `application.properties`.
3. Navega a la carpeta del proyecto y ejecuta el siguiente comando para compilar y ejecutar la aplicación:

```sh
mvn spring-boot:run
```

## Uso de la API

### Autenticación

Para autenticarse y obtener un token JWT, envía una solicitud POST a `/authentiacion` con un cuerpo JSON que contenga el nombre de usuario y la contraseña.

```json
{
    "username": "tu_usuario",
    "password": "tu_contraseña"
}
```

La respuesta será un token JWT que se debe incluir en el encabezado `Authorization` de las solicitudes subsecuentes.

### Endpoints

- `GET /api/topics`: Obtiene todos los tópicos.
- `GET /api/topics/{id}`: Obtiene un tópico por su ID.
- `POST /api/topics`: Crea un nuevo tópico.
- `PUT /api/topics/{id}`: Actualiza un tópico existente.
- `DELETE /api/topics/{id}`: Elimina un tópico.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
```

Espero que esto te sea útil. Si necesitas más ajustes o información adicional, no dudes en decírmelo. Realizado por Juan Ortiz
