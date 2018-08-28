# amoviles-android-java
# Curso de Aplicaciones Android con Java - 48h - Academia Móviles

## Lesson2 - Thursday, August 23, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

### ¿Qué temas vimos en la clase pasada ?

- Fundamentos de Java

- Android Studio

- Ejemplos : GallerySample, JavaSamples

### Interfaz de usuario en Android

 - Estructura de un elemento XML :
  
```
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
        android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin">
    
        <TextView android:text="Hello World!" android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </RelativeLayout>
```

  - ID :
  
```
      android:id="@+id/img"
```

```
      <TextView
            android:id="@+id/txtImg"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Medium Text"
            android:textAppearance="?android:attr/textAppearanceMedium" />
```
    
  - Atributos :
    
```
        android:layout_width="300dp"
```
    
  - En el código podemos invocar a los elementos XML de la siguiente manera :
  
```
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
```
    
```
     private ImageView img;
     private Button btnImg;
     private TextView txtImg;

     img= (ImageView)findViewById(R.id.img);
     btnImg= (Button)findViewById(R.id.butImg);
     txtImg = (TextView)findViewById(R.id.txtImg);
```

### Layouts

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/layoutparams.png?raw=true" height="320" />

- LinearLayout

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/linearlayout.png?raw=true" height="300"/>

Horizontal / Vertical

<img src="https://github.com/learning-android-pe/training-resources/blob/master/samples/ui/layout-linear-horizontal.png?raw=true" height="360"/>  <img src="https://github.com/learning-android-pe/training-resources/blob/master/samples/ui/layout-linear-vertical.png?raw=true" height="360"/>

Pesos

<img src="https://github.com/learning-android-pe/training-resources/blob/master/samples/ui/layout-linear-weight-horizontal.png?raw=true" height="360" />  <img src="https://github.com/learning-android-pe/training-resources/blob/master/samples/ui/layou-linear-weight-vertical.png?raw=true" height="360" />

- RelativeLayout

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/relativelayout.png?raw=true" height="300" />

- ConstraintLayout

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/constraint-fail_2x.png?raw=true" height="300" /> <img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/constraint-fail-fixed_2x.png?raw=true" height="300" />

- ListView & GridView

<img src="https://developer.android.com/images/ui/listview.png?hl=es-419" height="300"/> <img src="https://developer.android.com/images/ui/gridview.png?hl=es-419" height="300"/>

### Layout resources 

- Box Model 

![img](http://porterwebsites.com/wp-content/uploads/2016/10/boxmodel-image.png)

- Margin / Padding

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/box-margin.png?raw=true" height="320" />   <img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/box-padding.png?raw=true" height="320"/>

- Hexadecimal colors

Podemos usar este web para buscar colores en hexadecimal
http://www.color-hex.com/

Android utiliza los colores en formato Hexadecimal , por ejemplo este valor representa el color 'negro'

```java
    #000000
```
Para manejar la transparencia, agregamos uno de estos valores adelante del color. Por ejemplo, si queremos un color 'negro' con 70% de transparencia :

```java
    #B3000000
```

En esta tabla están todos los valores de 0-100 para la transparencia de colores

```java

    100% — FF
    95% — F2
    90% — E6
    85% — D9
    80% — CC
    75% — BF
    70% — B3
    65% — A6
    60% — 99
    55% — 8C
    50% — 80
    45% — 73
    40% — 66
    35% — 59
    30% — 4D
    25% — 40
    20% — 33
    15% — 26
    10% — 1A
    5% — 0D
    0% — 00

```

- Shapes 
Estos componentes te permiten dibujar formas , sin necesidad de usar recursos de diseño (imágenes) , puedes realizar cuadrados, círculos y elementos con bordes redondeados.

Por ejemplo, si requerimos crear un rectángulo con un color sólido de fondo :
```java
    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android" 
    android:shape="rectangle" >

    <solid android:color="#58A023" />
    </shape>
```

Ahora, si necesitamos agregarle bordes redondeandos

```java
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/blueskye"></solid>
    <corners android:radius="10dp"></corners>

</shape>
```
Resultado :

<img src="/images/shape1.png" />

### Activities

- Crear una actividad llamada LogInActivity e implementar el siguiente diseño utilizando : LinearLayout, RelativeLayout y ConstraintLayout . Considerar el uso de colores en hexadecimal y manejar la carpeta *res* para registrar los colores, textos e imagenes.

 <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/logIn_sample.png" height="480">

- Considerar los siguientes recursos

res/values/colors.xml

```
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="gray">#CCCCCC</color>
    <color name="green">#8AB68C</color>
    <color name="lightGray">#EEEEEE</color>
```

res/values/strings.xml

```
    <string name="username">Username</string>
    <string name="password">Password</string>
    <string name="sign_in">Sign in</string>
```
res/drawable/

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/ic_instagram_logo.png" height="240">


## Samples

En el directorio de este proyecto contamos con los proyectos

- LogInSample

- UISamples

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/logIn_sample2.png" height="480"> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/login_sample3.png" height="480">

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/login_sample4.png" height="480"> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/relative_sample.png" height="480">

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson3/images/constraint_layout_sample.png" height="480">

y la carpeta "exercises" , donde encontrarán ejercicios que pueden realizar relacionados a UI y Layouts.

## Homework

- xxx

## Resources

- User Interface & Navigation https://developer.android.com/guide/topics/ui/

- Layouts https://developer.android.com/guide/topics/ui/declaring-layout

- ConstraintLayout https://developer.android.com/reference/android/support/constraint/ConstraintLayout

- ConstraintLayout 1.1 https://medium.com/google-developers/introducing-constraint-layout-1-1-d07fc02406bc

- Understanding the performance benefits of ConstraintLayout  https://android-developers.googleblog.com/2017/08/understanding-performance-benefits-of.html

- CodeLab ConstraintLayout https://codelabs.developers.google.com/codelabs/constraint-layout/

- Layouts https://developer.android.com/guide/topics/ui/declaring-layout.html

- User Interface https://developer.android.com/guide/topics/ui/index.html

- Layout Editor https://developer.android.com/studio/write/layout-editor.html

- LinearLayout https://developer.android.com/guide/topics/ui/layout/linear.html

- RelativeLayout https://developer.android.com/guide/topics/ui/layout/relative.html

- ConstraintLayout https://developer.android.com/training/constraint-layout/index.html

- Recursos de diseño https://www.uplabs.com/

- Iconos https://www.iconfinder.com/

- Android Inspired UI http://android.inspired-ui.com/

- Drawable Resources https://developer.android.com/guide/topics/resources/drawable-resource.html

- Device compatibility https://developer.android.com/guide/practices/compatibility

- Material colors https://www.materialui.co/colors


