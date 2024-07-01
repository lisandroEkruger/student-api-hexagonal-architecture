# Proyecto de Gestión de Estudiantes con Arquitectura Hexagonal

Este proyecto es una aplicación de gestión de estudiantes implementada utilizando la arquitectura hexagonal. Proporciona una estructura modular y limpia para separar las preocupaciones del dominio, la aplicación y la infraestructura.

# Características

Arquitectura Hexagonal: La aplicación sigue los principios de la arquitectura hexagonal, con una clara separación entre el dominio, los adaptadores y los puertos.

Persistencia de Datos: Utiliza una base de datos PostgreSQL para almacenar la información de los estudiantes.

Manejo de Excepciones: Implementa manejo de excepciones personalizado para errores específicos, como estudiante no encontrado o parámetros inválidos.

Carga de Datos de Prueba: Al iniciar la aplicación, se cargan datos de prueba para facilitar las pruebas y el desarrollo.

# Instrucciones de Uso
- Clona el repositorio.
- Configura la conexión a la base de datos en application.yml.

# Ejecuta la aplicación.

Utiliza las rutas definidas en el controlador REST para interactuar con los estudiantes (por ejemplo, obtener todos los estudiantes, crear, actualizar o eliminar un estudiante).

# Tecnologías Utilizadas
- Spring Boot
- PostgreSQL
- Maven

# Contribuciones
¡Las contribuciones son bienvenidas! Si encuentras errores o tienes ideas para mejorar la aplicación, no dudes en abrir un pull request.
