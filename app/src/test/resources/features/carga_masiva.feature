# language: es
Característica: Carga Masiva de Productos

  Escenario: Visualización de la pantalla de carga masiva
    Dado que el administrador ha iniciado sesión y navega a carga masiva
    Entonces debería visualizar la zona de arrastre de archivos CSV
    Y debería visualizar el enlace para descargar la plantilla CSV

  Escenario: Carga exitosa de productos mediante archivo CSV
    Dado que el administrador ha iniciado sesión y navega a carga masiva
    Cuando sube un archivo CSV válido con productos
    Entonces debería visualizar el resumen de la carga con los productos procesados

  Escenario: Rechazo de archivo CSV con cabeceras incorrectas
    Dado que el administrador ha iniciado sesión y navega a carga masiva
    Cuando sube un archivo CSV con cabeceras incorrectas
    Entonces debería visualizar un mensaje indicando el error en el formato del archivo

  Escenario: Rechazo de archivo que supera el tamaño máximo permitido
    Dado que el administrador ha iniciado sesión y navega a carga masiva
    Cuando intenta subir un archivo que supera el tamaño máximo permitido
    Entonces debería visualizar un mensaje indicando que el archivo supera el tamaño máximo

  Escenario: Reporte de registros inválidos disponible para descarga
    Dado que el administrador ha iniciado sesión y navega a carga masiva
    Cuando sube un archivo CSV con registros inválidos
    Entonces debería visualizar el enlace para descargar el reporte de errores

