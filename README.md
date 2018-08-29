## Lesson4 - Wednesday, August 29, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

### Lesson

User Events
  - Widgets
  - User Events

UI components

- Buttons
- Checkboxes
- Radio buttons
- Campos de textos y labels
- Spinners
- Pickers

Material design for Android https://developer.android.com/guide/topics/ui/look-and-feel/

Eventos

```java
 btnSignUp =(Button)findViewById(R.id.btnSignUp);
 
 ...
 
   btnSignUp.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            //action
        }
  });
```

```java
  rbGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                  switch (checkedId) {
                      case R.id.rbM:
                          genero = 1;
                          break;
                      case R.id.rbF:
                          genero = 2;
                          break;
                  }
              }
  });
```

```java

  spLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                  Log.v("CONSOLE", "spLocation" + adapterView.getAdapter().getItem(i));
                  localidad = adapterView.getAdapter().getItem(i).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> adapterView) {

              }
          });
  }
```

### Samples

- UIEvents

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/ui-events.png" height="360" /> 

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/ui-events2.png" height="360" /> 

- DialogSamples

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/dialogs-1.png" height="360" /> <img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/dialogs-2.png" height="360" /> 

- NavigationSamples

<img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/navigation1.png" height="360" /> <img src="https://github.com/learning-android-pe/training-resources/blob/master/ui/navigation-2.png" height="360" />

### Resources

- Touch & input https://developer.android.com/guide/input/

- User Events https://developer.android.com/guide/topics/ui/ui-events.html

- Controles de entrada https://developer.android.com/guide/topics/ui/controls.html

- Android Design https://developer.android.com/design/

- Material Design for Android https://developer.android.com/guide/topics/ui/look-and-feel/

- Recursos de diseño  https://www.uplabs.com/

- Material design kit https://materialdesignkit.com/templates/

- KeyEvent https://developer.android.com/reference/android/view/KeyEvent
