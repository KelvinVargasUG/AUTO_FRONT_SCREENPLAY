# language: es
Característica: Registro de usuarios

  Escenario: Registro exitoso de un nuevo usuario
    Dado que el usuario se encuentra en la pantalla de registro
    Cuando completa el formulario con datos válidos y únicos
    Entonces debería visualizar un mensaje de registro exitoso

  Escenario: Registro fallido con correo ya registrado
    Dado que el usuario se encuentra en la pantalla de registro
    Y existe previamente una cuenta registrada con ese correo
    Cuando completa el formulario con un correo ya registrado
    Entonces debería visualizar un mensaje indicando que el correo ya existe
    Y no debería completarse el registro
