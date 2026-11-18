# Calculadora de Operaciones Android

Aplicación móvil desarrollada para la evidencia **GA8-220501096-AA2-EV02: APK - Desarrollar módulos móviles según requerimientos del proyecto**.

## Descripción

La aplicación permite ingresar dos números y realizar suma, resta, multiplicación y división. También valida los datos ingresados y evita la división entre cero.

## Tecnologías

- Android Studio.
- Kotlin.
- Jetpack Compose.
- Android SDK.
- Gradle.

## Ejecución

1. Abrir el proyecto en Android Studio.
2. Esperar la sincronización de Gradle.
3. Seleccionar un emulador Android o conectar un dispositivo.
4. Presionar el botón **Run**.

## Pruebas

Se realizaron pruebas funcionales en el emulador para las cuatro operaciones, campos vacíos y división entre cero. También se agregaron pruebas unitarias para los métodos de la clase `Calculadora`.

## APK

El APK de depuración se genera normalmente en:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Estructura principal

- `MainActivity.kt`: interfaz y clase `Calculadora`.
- `CalculadoraTest.kt`: pruebas unitarias de las operaciones.
- `app/src/main/res`: recursos de Android.

## Servidores y base de datos

Este módulo funciona localmente y no utiliza servidores, bases de datos ni servicios externos.

## Repositorio

```text
PEGAR_AQUI_EL_ENLACE_DEL_REPOSITORIO
```
