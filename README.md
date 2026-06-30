# AgroCloud

Aplicación móvil para la gestión operativa de fincas ganaderas, con enfoque en control de animales, producción de leche, organización por lotes y trazabilidad sanitaria.

## Problema

En muchas fincas ganaderas, el registro de información (animales, producción de leche, lotes) se lleva en cuadernos, hojas de cálculo o notas físicas. Esto dificulta consultar datos históricos, detecta tarde errores de registro, y se complica aún más cuando varios trabajadores participan en el proceso sin un sistema centralizado. Además, en zonas rurales la conectividad a internet suele ser inestable, lo que limita el uso de herramientas digitales tradicionales.

## Objetivo

Diseñar una aplicación móvil que permita registrar, organizar, consultar y controlar la información de animales, producción de leche y lotes, con una interfaz simple para usuarios con nivel básico o intermedio de manejo tecnológico, y con soporte de funcionamiento offline.

## Público objetivo

Propietarios, administradores y trabajadores de fincas ganaderas, generalmente entre 30 y 60 años, con nivel básico o intermedio en el uso de dispositivos y herramientas digitales.

## Funcionalidades (v1)

- Autenticación y roles (propietario, administrador, trabajador)
- Gestión de animales (registro, edición, búsqueda)
- Registro de producción de leche (ordeños), por animal y por lote
- Registro de pesaje
- Gestión de lotes
- Registro de nacimientos (genealogía)
- Registro de vacunas y tratamientos sanitarios
- Reportes (consultas agregadas sobre los módulos anteriores)
- Perfil de usuario (notificaciones, modo offline, cierre de sesión)

## Arquitectura

```
App móvil (Flutter)
  - Base de datos local (SQLite) para uso offline
  - Sincronización con el backend cuando hay conexión
        |
        v  API REST
Backend (Spring Boot / Java)
        |
        v
Base de datos (PostgreSQL en AWS)
```

## Tecnologías

| Capa | Tecnología |
|---|---|
| Backend | Java + Spring Boot |
| Base de datos | PostgreSQL |
| Frontend móvil | Flutter |
| Almacenamiento local / offline | SQLite |
| Control de versiones | Git / GitHub |
| Despliegue | AWS |

## Estructura del repositorio

```
agrocloud/
├── backend/        # API REST en Spring Boot
├── database/        # Scripts SQL y modelo de datos
├── docs/             # Documentación del proyecto (definición, ER, decisiones)
└── README.md
```

## Estado del proyecto

En desarrollo. Este repositorio documenta el progreso de construcción de AgroCloud como proyecto de portafolio técnico, módulo por módulo, empezando por autenticación y gestión de animales.

## Autora

Juliana Priscilla Mantilla Puente
