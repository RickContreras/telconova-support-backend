# TelcoNova SupportSuite - Módulo de Seguimiento de Órdenes

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-green.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15.12-blue.svg)
![GraphQL](https://img.shields.io/badge/GraphQL-1.3.5-purple.svg)


## 📋 Descripción

El módulo de Seguimiento de Órdenes en Proceso es parte del sistema web integral TelcoNova SupportSuite, diseñado para optimizar la gestión de soporte técnico de TelcoNova Colombia. Este módulo específico proporciona herramientas para que los técnicos registren avances, carguen evidencias y mantengan una trazabilidad completa de la atención a órdenes de trabajo.

## 🚀 Características Principales

- **Acceso de técnicos autenticado**: Plataforma segura para que técnicos accedan al sistema
- **Registro de avances de intervención**: Carga de comentarios, fotos y material utilizado
- **Actualización de estados**: Cambio de estados (en curso, pausado, finalizado, etc.)
- **Notificaciones de cambios**: Alertas automáticas al supervisor y cliente
- **Dashboard de seguimiento**: Visualización en tiempo real del estado de órdenes

## 🛠️ Tecnologías Utilizadas


- **Spring Boot**: Framework principal para desarrollo de APIs
- **GraphQL**: Para consultas y mutaciones eficientes
- **PostgreSQL**: Sistema de gestión de base de datos relacional
- **Spring Security**: Autenticación y autorización
- **WebSockets**: Para actualizaciones en tiempo real
- **AWS S3**: Almacenamiento de evidencias fotográficas (Por definir)
- **Azure Blob Storage**: Almacenamiento de evidencias fotográficas (Por definir)

## 🔧 Requisitos Previos

- JDK 21
- Maven 3.8.7
- PostgreSQL 15.12

## ⚙️ Configuración e Instalación


1. Clonar el repositorio:
```bash
git clone https://github.com/RickContreras/telconova-support-backend
cd telconova-support-backend
```

2. Configurar variables de entorno (crear archivo `.env` basado en `.env.example`)

3. Compilar y ejecutar:
```bash
mvn clean install
mvn spring-boot:run
```

## 📊 Arquitectura

> 🚧 En desarrollo

## 🔒 Requisitos No Funcionales

### Seguridad
- Autenticación robusta mediante JWT
- Control de acceso basado en roles (RBAC)
- Cifrado de datos sensibles

### Escalabilidad
- Diseño para soportar crecimiento horizontal
- Caché de datos para mejorar tiempos de respuesta

### Disponibilidad
- SLA de disponibilidad del 99.9%
- Manejo adecuado de excepciones y errores

### Rendimiento
- Tiempo de respuesta < 2 segundos para operaciones estándar
- Optimización de consultas y uso de índices

## 📁 Estructura del Proyecto

> 🚧 En desarrollo

```
src/main/java/com/telconova/supportsuite/  
├── config/              # Configuraciones globales  
│   ├── SecurityConfig.java  
│   ├── WebSocketConfig.java  
│   └── GraphQLConfig.java  
├── model/               # Entidades JPA  
│   ├── Orden.java  
│   ├── HistorialEstado.java  
│   ├── Evidencia.java  
│   └── Usuario.java  
├── repository/          # Repositorios Spring Data JPA  
│   ├── OrdenRepository.java  
│   ├── HistorialEstadoRepository.java  
│   └── EvidenciaRepository.java  
├── service/             # Lógica de negocio  
│   ├── OrdenService.java  
│   ├── SeguimientoService.java  
│   └── EvidenciaService.java  
├── controller/          # Controladores GraphQL  
│   ├── OrdenController.java  
│   └── SeguimientoController.java
├── security/            # Configuración de seguridad  
│   ├── JwtUtil.java  
│   └── CustomUserDetailsService.java    
└── Application.java     # Clase principal  
```

## 🧪 Pruebas

> 🚧 En desarrollo

### Ejemplo de Mutación GraphQL para actualizar estado

```graphql
mutation {
  actualizarEstadoOrden(idOrden: 1, estado: "En curso") {
    idOrden
    estado
    fechaUltimaActualizacion
  }
}
```

## 📦 CI/CD

> 🚧 En desarrollo

## 📄 Documentación API

> 🚧 En desarrollo

## 👥 Equipo de Desarrollo

> 🚧 En desarrollo