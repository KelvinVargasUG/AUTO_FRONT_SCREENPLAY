# language: es
Característica: Catálogo de Productos

  Escenario: Creación exitosa de un producto nuevo
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando completa el formulario con datos válidos del producto
    Entonces debería visualizar el mensaje de producto creado exitosamente

  Escenario: Visualización del catálogo con productos existentes
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando el catálogo tiene productos registrados
    Entonces debería visualizar los productos listados con sus botones de acción

  Escenario: Edición exitosa de un producto existente
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando hace clic en editar el primer producto y modifica el nombre
    Entonces debería visualizar el producto actualizado en el catálogo

  Escenario: Desactivación de un producto existente
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando hace clic en desactivar el primer producto
    Entonces el producto debería seguir listado como inactivo en el catálogo

  Escenario: Validación de campos obligatorios al crear producto
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando intenta crear un producto sin completar el nombre
    Entonces debería visualizar un mensaje de validación indicando el campo requerido

  Escenario: Validación de campos obligatorios al editar producto
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando intenta guardar la edición borrando el nombre del producto
    Entonces debería visualizar un mensaje de validación indicando el campo requerido

  Escenario: Producto inactivo no aparece en el catálogo del cliente
    Dado que el administrador ha iniciado sesión y navega al catálogo
    Cuando hace clic en desactivar el primer producto
    Entonces el producto desactivado no debería aparecer en el catálogo del cliente
