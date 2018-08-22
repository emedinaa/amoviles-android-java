## Lesson 1 - Tuesday, 21th August, 2018

- Lesson

- Samples

- Homework

- Resources

## Lesson

- Java para mobile developers

- Fundamentos de Android

- Entorno de desarrollo

### Android

Android architecture https://developer.android.com/guide/platform/?hl=es-419

<img src="https://developer.android.com/guide/platform/images/android-stack_2x.png?hl=es-419" height="520"/>

Android versions 

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/android-versions.jpg" height="240"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/android-versions.png" height="480"/>

![versions](https://chart.googleapis.com/chart?chs=500x250&cht=p&chco=c4df9b%2C6fad0c&chf=bg%2Cs%2C00000000&chd=t%3A0.3%2C0.4%2C4.3%2C10.3%2C22.4%2C25.6%2C31.1%2C5.7&chl=Gingerbread%7CIce%20Cream%20Sandwich%7CJelly%20Bean%7CKitKat%7CLollipop%7CMarshmallow%7CNougat%7COreo)

Tamaños

<img src="https://chart.googleapis.com/chart?chs=400x250&cht=p&chco=c4df9b%2C6fad0c&chf=bg%2Cs%2C00000000&chd=t%3A2.9%2C5.5%2C91.1%2C0.5&chl=Xlarge%7CLarge%7CNormal%7CSmall" height="240"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/android-screens.png" height="240"/>

Android dashboard [https://developer.android.com/about/dashboards/](https://developer.android.com/about/dashboards/)

### 2/3. Android Studio

<img src="https://developer.android.com/studio/images/studio-homepage-hero_2x.jpg" height="360"/>

Android Studio [https://developer.android.com/studio/](https://developer.android.com/studio/?hl=es-419)

### 4. App Components

App Components

(en) https://developer.android.com/guide/components/fundamentals

(es) https://developer.android.com/guide/components/fundamentals?hl=es-419

- Activities

- Services

- Broadcast receivers

- Content providers


### 5. Android Emulator

<img src="https://www.genymotion.com/wp-content/uploads/2016/02/features-genymotion-imac.jpg" height="360"/>

Genymotion [https://www.genymotion.com/desktop/](https://www.genymotion.com/desktop/)

### 6. Gradle

Android Plugin for Gradle Release Notes  [https://developer.android.com/studio/releases/gradle-plugin](https://developer.android.com/studio/releases/gradle-plugin)

![gradle](https://www.safaribooksonline.com/library/view/gradle-recipes-for/9781491947272/assets/rega_0108.png)

Building Android Apps [https://guides.gradle.org/building-android-apps/](https://guides.gradle.org/building-android-apps/)

Gradle Tasks

```
./gradlew tasks
```

```
MacBook-Pro-de-Eduardo:JavaForAndroid emedinaa$ ./gradlew tasks
Starting a Gradle Daemon, 1 incompatible and 1 stopped Daemons could not be reused, use --status for details

> Task :tasks

------------------------------------------------------------
All tasks runnable from root project
------------------------------------------------------------

Android tasks
-------------
androidDependencies - Displays the Android dependencies of the project.
signingReport - Displays the signing info for each variant.
sourceSets - Prints out all the source sets defined in this project.

Build tasks
-----------
assemble - Assembles all variants of all applications and secondary packages.
assembleAndroidTest - Assembles all the Test applications.
assembleDebug - Assembles all Debug builds.
assembleRelease - Assembles all Release builds.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
clean - Deletes the build directory.
cleanBuildCache - Deletes the build cache directory.
compileDebugAndroidTestSources
compileDebugSources
compileDebugUnitTestSources
compileReleaseSources
compileReleaseUnitTestSources
mockableAndroidJar - Creates a version of android.jar that's suitable for unit tests.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'JavaForAndroid'.
components - Displays the components produced by root project 'JavaForAndroid'. [incubating]
dependencies - Displays all dependencies declared in root project 'JavaForAndroid'.
dependencyInsight - Displays the insight into a specific dependency in root project 'JavaForAndroid'.
dependentComponents - Displays the dependent components of components in root project 'JavaForAndroid'. [incubating]
help - Displays a help message.
model - Displays the configuration model of root project 'JavaForAndroid'. [incubating]
projects - Displays the sub-projects of root project 'JavaForAndroid'.
properties - Displays the properties of root project 'JavaForAndroid'.
tasks - Displays the tasks runnable from root project 'JavaForAndroid' (some of the displayed tasks may belong to subprojects).

Install tasks
-------------
installDebug - Installs the Debug build.
installDebugAndroidTest - Installs the android (on device) tests for the Debug build.
uninstallAll - Uninstall all applications.
uninstallDebug - Uninstalls the Debug build.
uninstallDebugAndroidTest - Uninstalls the android (on device) tests for the Debug build.
uninstallRelease - Uninstalls the Release build.

Verification tasks
------------------
check - Runs all checks.
connectedAndroidTest - Installs and runs instrumentation tests for all flavors on connected devices.
connectedCheck - Runs all device checks on currently connected devices.
connectedDebugAndroidTest - Installs and runs the tests for debug on connected devices.
deviceAndroidTest - Installs and runs instrumentation tests using all Device Providers.
deviceCheck - Runs all device checks using Device Providers and Test Servers.
lint - Runs lint on all variants.
lintDebug - Runs lint on the Debug build.
lintRelease - Runs lint on the Release build.
lintVitalRelease - Runs lint on just the fatal issues in the release build.
test - Run unit tests for all variants.
testDebugUnitTest - Run unit tests for the debug build.
testReleaseUnitTest - Run unit tests for the release build.

To see all tasks and more detail, run gradlew tasks --all

To see more detail about a task, run gradlew help --task <task>
```
Android Plugin for Android

https://developer.android.com/studio/releases/gradle-plugin

<img src="https://github.com/emedinaa/amoviles-diplomado-2018-2/blob/Lesson1-Fundamentals/files/gradle-compatibilidad.png" height="360"/>

### 7. Crea tu primera aplicación

Build your first App [https://developer.android.com/training/basics/firstapp/](https://developer.android.com/training/basics/firstapp/)

<img src="https://developer.android.com/training/basics/firstapp/images/studio-welcome_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/studio-editor_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/run-avd_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/screenshot-activity2.png" height="240"/>


Gradle version : 4.1

Android Plugin Version : 3.0.1

Build.gradle del proyecto
```
  // Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.2.30'
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 15
    targetSdkVersion = 26
    compileSdkVersion = 26
    buildToolsVersion = '26.1.0'
    constraintLayoutVersion='1.0.2'

    // App dependencies
    supportLibraryVersion = '26.1.0'
    junitVersion = '4.12'
}
```


Build.gradle de la App

```
apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    //compileSdkVersion 26
    compileSdkVersion rootProject.ext.compileSdkVersion
    defaultConfig {
        applicationId "com.emedinaa.myfirstapp"
        //minSdkVersion 18
        //targetSdkVersion 26
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion

        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"

    //implementation 'com.android.support:appcompat-v7:26.1.0'
    //implementation 'com.android.support.constraint:constraint-layout:1.0.2'

    implementation "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:support-v4:$rootProject.supportLibraryVersion"

    implementation "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:design:$rootProject.supportLibraryVersion"
    implementation "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"

    //testImplementation 'junit:junit:4.12'
    implementation 'com.android.support.constraint:constraint-layout:1.1.0'
    testImplementation "junit:junit:$rootProject.ext.junitVersion"

    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
}
```

Gradle version : 4.1

Android Plugin Version : 3.0.1

Build.gradle del proyecto

```
  // Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.2.30'
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 15
    targetSdkVersion = 26
    compileSdkVersion = 26
    buildToolsVersion = '26.1.0'
    constraintLayoutVersion='1.0.2'

    // App dependencies
    supportLibraryVersion = '26.1.0'
    junitVersion = '4.12'
}
```


Build.gradle de la App

```
apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    //compileSdkVersion 26
    compileSdkVersion rootProject.ext.compileSdkVersion
    defaultConfig {
        applicationId "com.emedinaa.myfirstapp"
        //minSdkVersion 18
        //targetSdkVersion 26
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion

        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"

    //implementation 'com.android.support:appcompat-v7:26.1.0'
    //implementation 'com.android.support.constraint:constraint-layout:1.0.2'

    implementation "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:support-v4:$rootProject.supportLibraryVersion"

    implementation "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:design:$rootProject.supportLibraryVersion"
    implementation "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"

    //testImplementation 'junit:junit:4.12'
    implementation 'com.android.support.constraint:constraint-layout:1.1.0'
    testImplementation "junit:junit:$rootProject.ext.junitVersion"

    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
}
```


### 8. Java for Android Developers

Compilar Java online [https://www.compilejava.net/](https://www.compilejava.net/)

```
public class HelloWorld
{

  public static void main(String[] args)
  {

    System.out.print("Hello World!");
  }
}
```

Comentarios

```
//This is a single line comment

/*
This is a comment spreading
over two lines or more
*/

```

Variables

```
int first_number, second_number, answer;
first_number = 10;
second_number = 20;
answer = first_number + second_number;

double first_number, second_number, answer;
first_number = 10.5;
second_number = 20.8;

float first_number, second_number, answer;
first_number = 10.5f;
second_number = 20.8f;

String first_name,family_name;
first_name = "William";
family_name = "Shakespeare";

System.out.println( first_name + " " + family_name );

```

Operadores

```
+ (the plus sign)
- (the minus sign)
* (the multiplication sign is the asterisk sign)
/ (the divide sign is the forward slash)

> Greater Than
< Less Than
>= Greater Than or Equal To
<= Less Than or Equal To

&& AND
|| OR
== HAS A VALUE OF
! NOT

```

Condicionales

```
if ( Statement ) {
}
```
```
int age=18;

if(age<=18){
}

if(age>18){
}

```

```
if ( condition_one ) {

}
else if ( condition_two ) {

}
else {

}
```

Booleanos

```
boolean user = true;

if ( user == true) {
System.out.println("it's true");
}
else {
System.out.println("it's false");
} 

```

```
switch ( variable_to_test ) {
  case value:
    code_here;
    break;
  case value:
    code_here;
    break;
  default:
    values_not_caught_above;
}
```

Bucles

```
while (condicion) {
    ...
}
```

```
do {
    ...
} while (condicion)
```

```
for (int i=0; condicion; i++) {
    ...
}
```

```
for (iteredor: coleccion) {
    ...
}
```

Métodos

```
 private int sumar(int op1, int op2) {
        return op1+op2;
    }
    
  private int restar(int op1, int op2) {
      return op1-op2;
  }
  
  private int multiplicar(int op1, int op2) {
      return op1*op2;
  }
  
  private int dividir(int op1, int op2) {
      //TODO validar si op2!=0
      return op1/op2;
  }
```

### Activities

- Crear un nuevo proyecto en Android y realizar los cambios para que tenga la configuración del template(MyFirstApp)

Build your first app  [https://developer.android.com/training/basics/firstapp/](https://developer.android.com/training/basics/firstapp/)

- Crear una actividad llamada HomeActivity

- Crear un fragment llamado FragmentActivity

- Crear una clase java llamada User en src/main/package/model/User.java

- Agregar un color en res/values/colors.xml

- Agregar un string en res/values/strings.xml

- Agregar una dimension en res/values/dimens.xml

- Agregar una imagen en res/drawable/ic_android.png


## Samples

- MyFirstApp

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/my-first-app.png" height="480">

- GallerySample

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/gallery-sample.png" height="480">
 
## Homework

  ### Gradle
  
  Buscar una librería compatible con Android y agregar la dependencia a un proyecto . Ejemplo , picasso o retrofit.
  
  Escoger un task del plugin de Gradle y ejecutarla desde terminal o desde Android Studio
  
  ### Android Studio
  
  Crear un proyecto en Android Studio , luego realizar los cambios acorde al template entregado en clase (gradle).
  
## Resources

### Git/Github

- Github https://guides.github.com/activities/hello-world/

- Resources to learn Git https://try.github.io/

- Github Desktop https://desktop.github.com/

### Java

- Online Java IDE https://www.compilejava.net/

- Oracle , Learning the Java Language https://docs.oracle.com/javase/tutorial/java/index.html

- Java Programming Fundamentals https://www.udemy.com/java-programming-fundamentals/

- Java Fundamentals Language https://www.pluralsight.com/courses/java-fundamentals-language

- Java Programming Basics https://www.udacity.com/course/java-programming-basics--ud282

- Java Fundamentals for Android Development https://www.edx.org/es/course/java-fundamentals-android-development-galileox-caad001x-2

- The Java tutorials https://docs.oracle.com/javase/tutorial/java/index.html

- Java Programming https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28

- Google Java Style Guide https://google.github.io/styleguide/javaguide.html

### Android 

- Android Developers - Desarrollo https://developer.android.com/develop/index.html

- Entorno de desarrollo https://developer.android.com/studio/index.html?hl=es-419

- Ejemplos de Android  https://developer.android.com/samples/

- Primer proyecto Android https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419

- Codelab - primera android app con Java https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex

- Codelab - primera android app con Kotlin https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index=..%2F..%2Findex

- Android Tool Time https://www.youtube.com/watch?v=0n9sBgds-Hs&list=PLWz5rJ2EKKc_w6fodMGrA1_tsI3pqPbqa

- Canal oficial en Youtube para Android Developers https://www.youtube.com/user/androiddevelopers

### Books

- Books Android Developers http://fragmentedpodcast.com/tag/books/

### Others

- Intellij IDEA https://www.jetbrains.com/idea/

- Android Studio https://developer.android.com/studio/index.html?hl=es-419

- Sublime text https://www.sublimetext.com/

- Gradle https://gradle.org/

- Android Performance Tips https://developer.android.com/training/articles/perf-tips

- Interactions Patterns https://unitid.nl/androidpatterns/

- Comunidades https://www.meetup.com/es-ES/Android-Dev-Peru/


