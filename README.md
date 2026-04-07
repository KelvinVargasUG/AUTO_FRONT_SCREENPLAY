# AUTO_FRONT_SCREENPLAY

## Descripción

Proyecto de automatización de pruebas end-to-end sobre la interfaz web de **FoodTech** utilizando el patrón **Screenplay**. Valida que los flujos principales de la aplicación funcionan correctamente desde la perspectiva del usuario final, interactuando directamente con el navegador.

## Enfoque de prueba

El patrón **Screenplay** modela las pruebas en torno a actores que realizan tareas y hacen preguntas sobre el estado del sistema. Esto permite escribir escenarios expresivos y mantenibles, separando claramente las acciones del usuario de las verificaciones.

## Escenarios cubiertos

| Feature | Escenarios | Tipo |
|---|---|---|
| **Registro de usuarios** | Registro exitoso de nuevo usuario; Registro fallido con correo duplicado | Positivo / Negativo |
| **Facturación de pedidos** | Generación exitosa de factura para pedido completado | Positivo |
| **Catálogo de productos (Admin)** | Crear producto; Visualizar catálogo; Editar producto; Desactivar producto; Validación de campos obligatorios al crear y editar; Producto inactivo no visible para el cliente | Positivo / Negativo |
| **Carga masiva de productos** | Pantalla de carga; Carga exitosa CSV; Rechazo por cabeceras incorrectas; Rechazo por tamaño excedido; Descarga de reporte de errores; Productos cargados visibles en catálogo | Positivo / Negativo |

**Total: 16 escenarios**

## Requisitos previos

- Java 17 o superior
- Google Chrome instalado
- FoodTech-Kitchen-Services corriendo en `http://localhost:8080`
- FoodTech-Front corriendo en `http://localhost:5173`
- Ejecutar el script de datos iniciales: [seed_data.sh](scripts/seed_data.sh)

## Comandos disponibles

```bash
./gradlew clean test    # Ejecutar todos los tests
```

## Reportes

Los reportes de Serenity se generan en:

```
app/target/site/serenity/index.html
```

---

Proyecto académico — Sofka Technologies — 2026
