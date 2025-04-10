# Sistema de Gestión de Inventario Inteligente

## Descripción

Este proyecto es una API RESTful desarrollada con **Spring Boot** para gestionar un sistema de inventarios inteligente. Permite realizar operaciones CRUD sobre productos, categorías y proveedores, registrar movimientos de inventario, gestionar alertas de stock bajo, generar reportes y manejar roles de usuario con autenticación JWT.

## Características Principales

- **Gestión de Productos**: CRUD completo de productos con atributos como nombre, descripción, precio, stock, categoría y proveedor.
- **Gestión de Categorías**: CRUD de categorías para agrupar productos.
- **Gestión de Proveedores**: CRUD de proveedores para asociar productos a sus fuentes.
- **Gestión de Movimientos de Inventario**: Registro de entradas y salidas de productos con detalles de cantidad y fecha.
- **Alertas de Stock Bajo**: Notificación cuando el stock de un producto esté por debajo de un umbral configurable.
- **Reportes de Inventario**: Generación de reportes sobre consumo de productos, reposición de inventario, ingresos por ventas, y más.
- **Autenticación con JWT**: Seguridad mediante autenticación JWT y control de roles (Admin, Empleado).

## Requisitos Funcionales

- **CRUD de Productos**: Crear, leer, actualizar y eliminar productos con atributos: nombre, descripción, precio, stock, categoría y proveedor.
- **CRUD de Categorías**: Crear, leer, actualizar y eliminar categorías.
- **CRUD de Proveedores**: Crear, leer, actualizar y eliminar proveedores.
- **Gestión de Movimientos**: Registrar entradas y salidas de inventario.
- **Alertas de Stock Bajo**: Enviar alertas cuando el stock de un producto esté por debajo de un umbral configurable.
- **Reportes**: Generar reportes sobre el consumo de productos, ingresos por ventas y reposición de inventarios.
- **Autenticación**: Login con JWT y roles de usuario (Admin/Empleado).

## Requisitos No Funcionales

- **Seguridad**: Implementación de autenticación JWT y control de acceso basado en roles.
- **Escalabilidad**: El sistema debe ser capaz de manejar un aumento en los productos, proveedores y movimientos.
- **Rendimiento**: Las consultas de inventario y generación de reportes deben ser rápidas y eficientes.
- **Interfaz**: Aunque este proyecto es solo backend, está diseñado para integrarse con cualquier frontend (por ejemplo, React o Angular).
- **Documentación**: Utilización de **Swagger/OpenAPI** para documentar la API.

## Tecnologías Utilizadas

- **Backend**:
  - Spring Boot
  - Spring Security + JWT
  - Spring Data JPA
  - PostgreSQL
  - Lombok
  - Swagger/OpenAPI
- **Testing**:
  - JUnit 5
  - Mockito
- **Opcionales**:
  - Docker
  - MapStruct
  - Spring Boot DevTools

## Modelo de Datos

### Entidades Principales

- **Producto**:
  - `id` (PK)
  - `nombre`
  - `descripción`
  - `precio`
  - `stock`
  - `categoría` (relación con Categoría)
  - `proveedor` (relación con Proveedor)

- **Categoría**:
  - `id` (PK)
  - `nombre`
  - `descripción`

- **Proveedor**:
  - `id` (PK)
  - `nombre`
  - `contacto`
  - `dirección`

- **Movimiento de Inventario**:
  - `id` (PK)
  - `producto` (relación con Producto)
  - `cantidad`
  - `tipo` (entrada/salida)
  - `fecha`

- **Usuario**:
  - `id` (PK)
  - `username`
  - `password` (encriptada)
  - `roles` (admin/empleado)

## Flujo de Datos y Relaciones

- Un **Producto** puede tener una **Categoría** y un **Proveedor**.
- Los **Movimientos de Inventario** están relacionados con un **Producto** y registran entradas o salidas de productos.
- Un **Usuario** puede ser de tipo **Admin** o **Empleado**, con diferentes permisos para acceder y gestionar los datos.

## Roadmap

### Fase 1: Estructura y CRUD Básico
- Crear el proyecto en **Spring Boot**.
- Configurar la base de datos **PostgreSQL**.
- Crear las entidades principales: **Producto**, **Categoría**, **Proveedor**, **Movimiento**.
- Desarrollar el CRUD básico para cada entidad.
- Probar con **Postman** los endpoints básicos.

### Fase 2: Autenticación y Seguridad
- Implementar la autenticación con **JWT**.
- Definir roles (**Admin**, **Empleado**) y asegurar los endpoints.
- Probar la seguridad con **Postman**.

### Fase 3: Alertas y Reportes
- Implementar la lógica para las alertas de **stock bajo**.
- Desarrollar los reportes de **consumo**, **reposiciones** e **ingresos**.
- Implementar exportación a **PDF** o **Excel** (opcional).

### Fase 4: Documentación y Testing
- Configurar **Swagger/OpenAPI** para la documentación automática.
- Escribir pruebas unitarias con **JUnit** y **Mockito**.
- Opcional: **Docker** para contenerizar el proyecto.

## Instalación

### Requisitos previos

- **Java 17 o superior**.
- **Maven** o **Gradle**.
- **PostgreSQL** configurado en tu entorno local o remoto.

### Pasos de Instalación

1. Clona el repositorio:

   ```bash
   git clone https://https://github.com/geynerson003/gestion-inventario

2. Ingresa al directorio del proyecto
   ```bash
   cd gestion-inventario
3. Configura tu base de datos en application.properties
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/inventario
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
4. Ejecuta el proyecto con Maven
   ```bash
   mvn spring-boot:run
5 [Accede a la API en ](http://localhost:8080)

## Contribuciones 
Si deseas contribuir al proyecto, siéntete libre de realizar un **fork**, crear una nueva rama, hacer tus cambios y enviar un **pull request**.

