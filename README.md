## Lesson 16 - Thursday, October 11, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

¿Qué temas vimos en la clase pasada ?

## Lesson

- [x] Configurar proyecto
- [x] Firmar  App
- [x] Google Play Console
- [x] Publicar una app en google play

**Configurar proyecto**

*Configurar tu compilación* https://developer.android.com/studio/build/?hl=es-419

- Remover los Logs 

```java
public class LogUtils {
    public static void debug(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
```
- Parámetros , keys o credenciales pueden ser manejados con Gradle

Flavors

```groovy
android {
    defaultConfig {
        applicationId "com.example.myapp"
    }
    productFlavors {
        free {
            applicationIdSuffix ".free"
        }
        pro {
            applicationIdSuffix ".pro"
        }
    }
}
```

- Application ID

```groovy
android {
    defaultConfig {
        applicationId "com.example.myapp"
        minSdkVersion 15
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
    }
    ...
}
```

- Activar ProGuard

*Reducir tu código y tus recursos* https://developer.android.com/studio/build/shrink-code?hl=es-419

```groovy
android {
    buildTypes {
        release {
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android.txt'),
                    'proguard-rules.pro'
        }
    }
    ...
}
```

- Generar APK de Debug

*Compilar tu proyecto desde línea de comandos* https://developer.android.com/studio/build/building-cmdline?hl=es-419

```java
gradlew assembleDebug
```

- Analizar APK

*Analizar tu compilación con APK Analyzer* https://developer.android.com/studio/build/apk-analyzer

<img src="https://www.google.com.pe/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiPseK84v7dAhXsIjQIHdboAeQQjRx6BAgBEAU&url=https%3A%2F%2Fdeveloper.android.com%2Fstudio%2Fbuild%2Fapk-analyzer&psig=AOvVaw1U33osYG1BInb2rC_URc_f&ust=1539360378308032" />

**Firmar App**

Java code

```java
gradlew assembleDebug
```

Xml code 

```xml

```

Image

<img src="https://developer.android.com/images/fundamentals/diagram_backstack_singletask_multiactivity.png" height="360" />

![Image of Yaktocat](https://octodex.github.com/images/yaktocat.png)

Bold /italic
**bold**
*italic* with Markdown. 
Link 
You can even [link to Google!](http://google.com)
Headers

# This is an <h1> tag
## This is an <h2> tag
###### This is an <h6> tag

Lists

* Item 1
* Item 2
  * Item 2a
  * Item 2b

Extras

- [x] This is a complete item
- [ ] This is an incomplete item

## Samples

## Exercises

## Homework
- xxxx

## Resources 

- Google Play console https://developer.android.com/distribute/console/

- Google Play Developer API https://developer.android.com/google/play/developer-api?hl=es-419

- Android Proguard https://developer.android.com/studio/build/shrink-code?hl=es-419

- Practical ProGuard rules samples https://medium.com/androiddevelopers/practical-proguard-rules-examples-5640a3907dc9

- ProGuard https://www.guardsquare.com/en/products/proguard

- Firmar tu App https://developer.android.com/studio/publish/app-signing?hl=es-419

- Publicar app https://developer.android.com/studio/publish/?hl=es-419


