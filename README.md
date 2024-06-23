# SPRING BOOT CON GRAPHQL

Aplicacion en `SpringBoot` con `GraphQL` con dos CRUD, Alumnos y cursos

> Los endpoint estan documentados en el archivo `app.http` en la raiz del repo.

### Requerimientos:
* Base de datos MySQL
* Docker
* Editor de codigo

### Importante:

- No se requiere tener instalado el `java-jdk` por que tambien tiene dockerizado el `maven`.
- En `src\main\resources\application.properties` cambia el DNS de conexion a base de datos.
- Descomentar la linea **9** y **10** del `src\main\resources\application.properties`, va a llenar las tablas con datos inciales.

## DOCKER

```sh
docker build -t spring-boot-graphql .
```

```sh
docker run -d -p 8080:8080 --name spring-boot-graphql-app spring-boot-graphql
```
