## Lesson 14 - Tuesday, October 8, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

¿Qué temas vimos en la clase pasada ?

## Lesson

Los temas que veremos en la clase son :

- [x] Localización de una App : Manejo de idiomas y recursos acorde a la región donde se use la App.
- [x] Sensores 

**Localización en tu app**

Android se ejecuta en muchos dispositivos en muchas regiones. Para llegar a la mayoría de los usuarios, su aplicación debe manejar texto, archivos de audio, números, moneda y gráficos de manera adecuada a los lugares donde se usa su aplicación.

*Recursos Android (res)*

Estructura de un proyecto Android :

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/localization/android_project_structure.png" height="360" />

Directorio *RES* :

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/localization/android_res.png" height="240" />

Strings values :

```xml
res/values/strings.xml
```
String values por idioma :

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/localization/android_res_language.png" height="240" />


Recursos de imágenes(drawables) por idioma :

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/localization/android_res_drawable.png" height="240" />

Obtener localización del device :
```java
Locale primaryLocale = context.getResources().getConfiguration().getLocales().get(0);
String locale = primaryLocale.getDisplayName();
```
*Otras consideraciones*

Date formats :

<img src="https://github.com/learning-android-pe/training-resources/blob/master/localization/android_date_formats.png" height="520" />

Number formats :

<img src="https://github.com/learning-android-pe/training-resources/blob/master/localization/android_number_formats.png" height="520" />

*Translations Editor*

<img src="https://developer.android.com/studio/images/write/translations-editor-basic_2x.png"/>

**Sensores**

Tipos de sensores
<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_sensor_types.png" height="520" />

Sensores por plataforma
<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_sensor_by_platform.png" height="520" />

Sensores ambientales
<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_environment_sensors%20.png" height="180" />

Virtual sensors

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/emulator_virtual_sensor_1.png" height="240" />

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/emulator_virtual_sensor_2.png" height="240" />

## Samples

- Localization
- Sensors

<img src="https://github.com/emedinaa/amoviles-android-java/blob/Lesson14-SensorsLocalization/screenshot_es.png" height="480" /> <img src="https://github.com/emedinaa/amoviles-android-java/blob/Lesson14-SensorsLocalization/screenshot_en.png" height="480" />
## Exercises

## Homework
- xxxx

## Resources 

- Recurso de una aplicación https://developer.android.com/guide/topics/resources/providing-resources

- Localization [https://developer.android.com/guide/topics/resources/localization](https://developer.android.com/guide/topics/resources/localization)

- Translations Editor https://developer.android.com/studio/write/translations-editor

- Date Formats https://docs.oracle.com/cd/E19455-01/806-0169/overview-7/index.html

- Number Formats https://docs.oracle.com/cd/E19455-01/806-0169/overview-9/index.html




