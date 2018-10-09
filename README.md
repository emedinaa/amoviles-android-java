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
- [x] Gestures & Touch

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

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_sensor_types.png" height="720" />

Sensores por plataforma

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_sensor_by_platform.png" height="520" />

Sensores ambientales

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/android_environment_sensors%20.png" height="180" />

Virtual sensors

<img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/emulator_virtual_sensor_1.png" height="480" /> <img src="https://github.com/learning-android-pe/training-resources/blob/master/sensors/emulator_virtual_sensor_2.png" height="480" />

**Gestures & Touch**

Capturar eventos de tacto en una activity o un view

```java
public class MainActivity extends Activity {
...
// This example shows an Activity, but you would use the same approach if
// you were subclassing a View.
@Override
public boolean onTouchEvent(MotionEvent event){

    int action = MotionEventCompat.getActionMasked(event);

    switch(action) {
        case (MotionEvent.ACTION_DOWN) :
            Log.d(DEBUG_TAG,"Action was DOWN");
            return true;
        case (MotionEvent.ACTION_MOVE) :
            Log.d(DEBUG_TAG,"Action was MOVE");
            return true;
        case (MotionEvent.ACTION_UP) :
            Log.d(DEBUG_TAG,"Action was UP");
            return true;
        case (MotionEvent.ACTION_CANCEL) :
            Log.d(DEBUG_TAG,"Action was CANCEL");
            return true;
        case (MotionEvent.ACTION_OUTSIDE) :
            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                    "of current screen element");
            return true;
        default :
            return super.onTouchEvent(event);
    }
}
```

Capturar eventos de tacto a un View

```java
View myView = findViewById(R.id.my_view);
myView.setOnTouchListener(new OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        // ... Respond to touch events
        return true;
    }
});
```

Detectar todos los gestos soportados

```java
public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
            float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
}
```

Crea tu propio listener para capturar gestos

```java
public class MainActivity extends Activity {

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            return true;
        }
    }
}
```

## Samples

- Localization
- Sensors

<img src="https://github.com/emedinaa/amoviles-android-java/blob/Lesson14-SensorsLocalization/images/screenshot_es.png" height="480" /> <img src="https://github.com/emedinaa/amoviles-android-java/blob/Lesson14-SensorsLocalization/images/screenshot_en.png" height="480" />

## Exercises

## Homework
- xxxx

## Resources 

- Recurso de una aplicación https://developer.android.com/guide/topics/resources/providing-resources

- Localization [https://developer.android.com/guide/topics/resources/localization](https://developer.android.com/guide/topics/resources/localization)

- Translations Editor https://developer.android.com/studio/write/translations-editor

- Date Formats https://docs.oracle.com/cd/E19455-01/806-0169/overview-7/index.html

- Number Formats https://docs.oracle.com/cd/E19455-01/806-0169/overview-9/index.html

- Touch & input https://developer.android.com/guide/input/

- Sensors https://developer.android.com/guide/topics/sensors/sensors_overview

- Android Sensors https://developer.android.com/guide/topics/sensors/

- Sensor types https://source.android.com/devices/sensors/sensor-types




