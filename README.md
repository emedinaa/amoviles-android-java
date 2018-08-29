## Lesson2 - Thursday, August 23, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

### Review

¿Qué temas vimos en la clase pasada ?

- Fundamentos de Java

- Android Studio

- Ejemplos : GallerySample, JavaSamples

### Lesson

Java for Android Developers

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

Android Studio

Android Studio - User Interface
![](https://developer.android.com/studio/images/intro/main-window_2-2_2x.png)

Proyecto Android

<img src="https://developer.android.com/studio/images/intro/project-android-view_2-1_2x.png" height="480">

Android Studio overview [https://developer.android.com/studio/intro/](https://developer.android.com/studio/intro/)

Activities

- Crear una actividad llamada HomeActivity

- Crear un fragment llamado FragmentActivity

- Crear una clase java llamada User en src/main/package/model/User.java

- Agregar un color en res/values/colors.xml

- Agregar un string en res/values/strings.xml

- Agregar una dimension en res/values/dimens.xml

- Agregar una imagen en res/drawable/ic_android.png

### Samples
- MyFirstApp

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/my-first-app.png" height="480">


- GallerySample

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/gallery-sample.png" height="480">
 
 - JavaSamples

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson2/images/java-samples.png" height="480">

### Homework

### Resources

- Entorno de desarrollo https://developer.android.com/studio/index.html?hl=es-419

- Android Developers - Desarrollo https://developer.android.com/develop/index.html

- Ejemplos de Android  https://developer.android.com/samples/

- Primer proyecto Android https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419

- Codelab - primera android app con Java https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex

- Codelab - primera android app con Kotlin https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index=..%2F..%2Findex

- Android Tool Time https://www.youtube.com/watch?v=0n9sBgds-Hs&list=PLWz5rJ2EKKc_w6fodMGrA1_tsI3pqPbqa

- Canal oficial en Youtube para Android Developers https://www.youtube.com/user/androiddevelopers

- Java Programming Fundamentals https://www.udemy.com/java-programming-fundamentals/

- Java Fundamentals Language https://www.pluralsight.com/courses/java-fundamentals-language

- Java Programming Basics https://www.udacity.com/course/java-programming-basics--ud282

- Java Fundamentals for Android Development https://www.edx.org/es/course/java-fundamentals-android-development-galileox-caad001x-2

- The Java tutorials https://docs.oracle.com/javase/tutorial/java/index.html

- Java Programming https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28

- Intellij IDEA https://www.jetbrains.com/idea/

- Android Studio https://developer.android.com/studio/index.html?hl=es-419

- Online Java IDE https://www.compilejava.net/

- Sublime text https://www.sublimetext.com/

- Google Java Style Guide https://google.github.io/styleguide/javaguide.html

- Books Android Developers http://fragmentedpodcast.com/tag/books/

