# language: es
Característica: Facturación de pedidos

  Escenario: Generación exitosa de factura para un pedido completado
    Dado que el usuario inicia sesión correctamente en la plataforma
    Y accede a la sección de pedidos completados
    Cuando factura uno de los pedidos disponibles
    Entonces debería visualizar un mensaje de factura generada exitosamente
