# amoviles-android-java
Curso de Aplicaciones Android con Java - 48h - Academia Móviles

Lesson2 - Thursday, August 23, 2018

    Review

    Lesson

    Samples

    Homework

    Resources

Review
¿Qué temas vimos en la clase pasada ?

    Android Studio instalación https://developer.android.com/studio/install

    Android Studio https://developer.android.com/studio/intro/

    Template

Template de proyecto Android 

Gradle version : 4.1

Android Plugin Version : 3.0.1

Build.gradle del proyecto

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

Build.gradle de la App

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

Activities

    Crear un nuevo proyecto en Android y realizar los cambios para que tenga la configuración del template(MyFirstApp)

Build your first app https://developer.android.com/training/basics/firstapp/
Lesson


Java for Android Developers

Compilar Java online https://www.compilejava.net/

public class HelloWorld
{

  public static void main(String[] args)
  {

    System.out.print("Hello World!");
  }
}

Comentarios

//This is a single line comment

/*
This is a comment spreading
over two lines or more
*/

Variables

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

Operadores

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

Condicionales

if ( Statement ) {
}

int age=18;

if(age<=18){
}

if(age>18){
}

if ( condition_one ) {

}
else if ( condition_two ) {

}
else {

}

Booleanos

boolean user = true;

if ( user == true) {
System.out.println("it's true");
}
else {
System.out.println("it's false");
} 

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

Bucles

while (condicion) {
    ...
}

do {
    ...
} while (condicion)

for (int i=0; condicion; i++) {
    ...
}

for (iteredor: coleccion) {
    ...
}

Métodos

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

Android Studio

Android Studio - User Interface

Proyecto Android

Android Studio overview https://developer.android.com/studio/intro/

Samples

    JavaAndroidSamples

    GallerySample

    JavaSamples

Homework

    Encuentra un plugin interesante para Android Studio e indica los pasos para instalarlo en el IDE.

    Explica sobre SDK Manager y AVD Manager

    Explica sobre el Android Profiles

Resources

    Entorno de desarrollo https://developer.android.com/studio/index.html?hl=es-419

    Android Developers - Desarrollo https://developer.android.com/develop/index.html

    Ejemplos de Android https://developer.android.com/samples/

    Primer proyecto Android https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419

    Codelab - primera android app con Java https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex

    Codelab - primera android app con Kotlin https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index=..%2F..%2Findex

    Android Tool Time https://www.youtube.com/watch?v=0n9sBgds-Hs&list=PLWz5rJ2EKKc_w6fodMGrA1_tsI3pqPbqa

    Canal oficial en Youtube para Android Developers https://www.youtube.com/user/androiddevelopers

    Java Programming Fundamentals https://www.udemy.com/java-programming-fundamentals/

    Java Fundamentals Language https://www.pluralsight.com/courses/java-fundamentals-language

    Java Programming Basics https://www.udacity.com/course/java-programming-basics--ud282

    Java Fundamentals for Android Development https://www.edx.org/es/course/java-fundamentals-android-development-galileox-caad001x-2

    The Java tutorials https://docs.oracle.com/javase/tutorial/java/index.html

    Java Programming https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28

    Intellij IDEA https://www.jetbrains.com/idea/

    Android Studio https://developer.android.com/studio/index.html?hl=es-419

    Online Java IDE https://www.compilejava.net/

    Sublime text https://www.sublimetext.com/

    Google Java Style Guide https://google.github.io/styleguide/javaguide.html

    Books Android Developers http://fragmentedpodcast.com/tag/books/

