## Lesson 5 - Monday, August 30, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

¿Qué temas vimos en la clase pasada ?

- Layouts : LinearLayout , RelativeLayout, ConstraintLayout

- Componentes de Interfaz de Usuario : EditTextView, Button, TextView

- Eventos de Usuario : Click, Teclado, Listas

Activities


## Lesson

## RecyclerView & Adapters

  - Adapters
  - Custom Adapters
  - RecyclerView
  - Events
  - Exercises

## Adapters
<img src="https://camo.githubusercontent.com/fc6df9d5fd6d78e48d6802c77ad7264a6a787672/68747470733a2f2f692e696d6775722e636f6d2f6d6b38324a64322e6a7067" />

Los Adapters son los intermediarios entre el origen de datos y el componente visual.
Respecto al origen de datos , contamos con los siguiente componentes :
- List
- ArrayList
- Array

y a los componentes visuales, tenemos :

- ListView
- GridView
- RecyclerView

Los Adapters son los que asocian la colección de datos con las  celdas de nuestras vistas , tambien te permiten realizar cambios sobre ellas. Es decir, agregar, modificar o eliminar un elemento de nuestra lista .

ListView & GridView

<img src="https://developer.android.com/images/ui/listview.png" /> <img src="https://developer.android.com/images/ui/gridview.png" />

Tipos :

Se dispone de los siguientes tipos de adapters
- BaseAdapter , cuando necesitemos manejar alguna lista desde cero , recomiendo utilizarlo . Usualmente solicita implementar varios métodos.

- ArrayAdapter , este es un adapter que nos puede servir de base y solo requiere implementar un método.

- CursorAdapter , este es usado cuando interactuamos con base de datos.

## Custom Adapters

Para nosotros poder construir una lista personalizada requerimos los siguientes pasos :

1. Origen de datos , no importa si esta colección viene de base de datos, de una archivo json o de la respuesta de la llamada a un servicio web . Al final , solo necesitamos este como una colección de Java : ArrayList, List o Array.

2. Entidad , normalmente nuestras celdas estarán relacionadas a entidades, es decir a un clase modelo que represente el contenido que se va a mostrar en una lista . Por ejemplo, si vamos a mostrar un listado de películas :

```java
package com.androidbootcamp.androidtemplate.model;

/**
 * @author Eduardo Medina
 */
public class Movie {

    private int id;
    private String title;
    private String desc;
    private double price;
    private boolean cartelera;

    public Movie(int id, String title, String desc, double price, boolean cartelera) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.cartelera = cartelera;
    }

    public Movie(String title, boolean cartelera) {
        this.title = title;
        this.cartelera = cartelera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCartelera() {
        return cartelera;
    }

    public void setCartelera(boolean cartelera) {
        this.cartelera = cartelera;
    }
}
```
3. La celda ,usualmente las celda que vamos a mostrar de nuestra lista, siempre es personalizada . Es decir, tendremos imágenes, textos , botones . Es deficil ver solo listas con textos, en las aplicaciones siempre vamos a tener listas con diseños personalizados . Para esto , nosotros podemos dibujar nuestras propias celdad usando XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:tools="http://schemas.android.com/tools">

    <TextView
        android:id="@+id/tviName"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:padding="10dp"
        android:text="Doctor Strange"
        android:textSize="10sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.125"
        app:layout_constraintStart_toEndOf="@+id/imageView2"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="80dp"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:layout_centerVertical="true"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:adjustViewBounds="true"
        android:src="@mipmap/ic_movie"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/iviCartelera"
        android:layout_width="50dp"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_marginEnd="4dp"
        android:layout_marginTop="4dp"
        android:adjustViewBounds="true"
        android:src="@mipmap/ic_ticket"
        android:visibility="gone"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:visibility="visible"
        android:layout_marginRight="4dp" />
</android.support.constraint.ConstraintLayout>

```

4. El adapter , vamos a requerir construir un adapter para manipular una lista 

```java

package com.androidbootcamp.androidtemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidbootcamp.androidtemplate.R;


/**
 * Created by emedinaa on 15/10/15.
 */
public class SimpleListAdapter extends BaseAdapter {

    private Context context;
    private String[] data;

    public SimpleListAdapter(Context context, String[] data) {
        this.context=context;
        this.data= data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.row_list,parent,false);
        } else {
            view = convertView;
        }
        TextView  tviTitle=view.findViewById(R.id.tviTitle);
        tviTitle.setText(data[position]);
        return view;
    }
}
```
5. Asociar nuestro adapter con el componente visual

```java
 private String[] mDays = {"Monday", "Tuesday","Wednesday","Thursday","Friday",
"Saturday", "Sunday"};
  ...
  
  listViewSimple= findViewById(R.id.listViewSimple);

  SimpleListAdapter mySimpleListAdapter= new SimpleListAdapter(this,
          mDays);
  lviSimple.setAdapter(mySimpleListAdapter);
```

## RecyclerView

<img src="https://developer.android.com/training/material/images/RecyclerView.png" />

## Events

Si es un ListView o GridView , contamos un evento para saber si seleccionamos un item de la lista

```java
 listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie =(Movie) adapterView.getAdapter().getItem(position);
                String message= movie.getTitle()+ " "+ movie.isCartelera();
                //String.format("title %s cartela %s ",movie.getTitle(),String.valueOf(movie.isCartelera()) );
                showItem(message);
            }
});
```

Si es un recyclerView , no contamos con un listener por defecto , pero agregué unas clases que nos pueden ayudar con esto :

```java
   recyclerViewPokemon.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewPokemon, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(pokemonList!=null){
                    Pokemon pokemon= pokemonList.get(position);
                    goToDetails(pokemon);
                }
            }

            @Override
            public void onLongClick(View view, int position) {}
}));
```
## Samples
<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/images/samples-01.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/images/samples-02.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/images/samples-03.png?raw=true" height="320"/> <img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/images/samples-04.png?raw=true" height="320"/>


## Exercises

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/AdapterBasic-I.png?raw=true" height="320"/> <img src="https://github.com/BrainFriendly/ab-android-fundamentals/blob/L6RecyclerView-Adapters/exercises/AdapterBasic-II.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/AdapterBasic-III.png?raw=true" height="320"/> <img src="https://github.com/BrainFriendly/ab-android-fundamentals/blob/L6RecyclerView-Adapters/exercises/AdapterBasic-IV.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/AdapterBasic-V.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/Adapters-I.png?raw=true" height="320"/> <img src="https://github.com/BrainFriendly/ab-android-fundamentals/blob/L6RecyclerView-Adapters/exercises/Adapters-II.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/Adapters-III.png?raw=true" height="320"/> <img src="https://github.com/BrainFriendly/ab-android-fundamentals/blob/L6RecyclerView-Adapters/exercises/Adapters-IV.png?raw=true" height="320"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson5/exercises/Adapters-V.png?raw=true" height="320"/>

## Homework

- Realizar los ejercicios AdapterBasic3,AdapterBasic-IV y Adapters-III. https://github.com/emedinaa/amoviles-android-java/tree/Lesson5-Adapters

## Resources 

Adapter https://developer.android.com/reference/android/widget/Adapter.html

ListView https://developer.android.com/guide/topics/ui/layout/listview.html

GridView https://developer.android.com/guide/topics/ui/layout/gridview.html

RecyclerView https://developer.android.com/guide/topics/ui/layout/recyclerview.html

Creating List and Cards https://developer.android.com/training/material/lists-cards.html

RecyclerView https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html

Android Developers Fundamentals Course - Create a RecyclerView https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%202/44_p_create_a_recycler_view.html




