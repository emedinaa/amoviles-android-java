##Lesson 12 - Tuesday, October 2, 2018 

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

¿Qué temas vimos en la clase pasada ?

## Lesson

- Activity

Una actividad representa una pantalla con interfaz de usuario. Por ejemplo, una aplicación de correo electrónico tiene una actividad que muestra una lista de los correos electrónicos nuevos, otra actividad para redactar el correo electrónico y otra actividad para leer correos electrónicos. Si bien las actividades trabajan juntas para proporcionar una experiencia de usuario consistente en la aplicación de correo electrónico, cada una es independiente de las demás. De esta manera, una aplicación diferente puede inicial cualquiera de estas actividades (si la aplicación de correo electrónico lo permite). Por ejemplo, una aplicación de cámara puede iniciar la actividad en la aplicación de correo electrónico que redacta el nuevo mensaje para que el usuario comparta una imagen.

Una actividad se implementa como una subclase de Activity.

Ciclo de Vida 

 <img src="https://developer.android.com/images/service_lifecycle.png?hl=es-419" height="480"/>
 
- Services 

Un servicio es un componente que se ejecuta en segundo plano para realizar operaciones prolongadas o tareas para procesos remotos. Un servicio no proporciona una interfaz de usuario. Por ejemplo, un servicio podría reproducir música en segundo plano mientras el usuario se encuentra en otra aplicación, o podría capturar datos en la red sin bloquear la interacción del usuario con una actividad. Otro componente, como una actividad, puede iniciar el servicio y permitir que se ejecute o enlazarse a él para interactuar.

Un servicio se implementa como una subclase de Service.

Ciclo de Vida 

 <img src="https://developer.android.com/images/service_lifecycle.png?hl=es-419" height="480"/>
 
- Content providers

Un proveedor de contenido administra un conjunto compartido de datos de la app. Puedes almacenar los datos en el sistema de archivos, en una base de datos SQLite, en la Web o en cualquier otra ubicación de almacenamiento persistente a la que tu aplicación pueda acceder. A través del proveedor de contenido, otras aplicaciones pueden consultar o incluso modificar los datos (si el proveedor de contenido lo permite). Por ejemplo, el sistema Android proporciona un proveedor de contenido que administra la información de contacto del usuario. De esta manera, cualquier app con los permisos correspondientes puede consultar parte del proveedor de contenido (como ContactsContract.Data) para la lectura y escritura de información sobre una persona específica.

Los proveedores de contenido también son útiles para leer y escribir datos privados de tu aplicación y que no se comparten. 

Un proveedor de contenido se implementa como una subclase de ContentProvider y debe implementar un conjunto estándar de API que permitan a otras aplicaciones realizar transacciones.

- Broadcast receivers
Un receptor de mensajes es un componente que responde a los anuncios de mensajes en todo el sistema. Muchos mensajes son originados por el sistema; por ejemplo, un mensaje que anuncie que se apagó la pantalla, que la batería tiene poca carga o que se tomó una foto. Las aplicaciones también pueden iniciar mensajes; por ejemplo, para permitir que otras aplicaciones sepan que se descargaron datos al dispositivo y están disponibles para usarlos. Si bien los receptores de mensajes no exhiben una interfaz de usuario, pueden crear una notificación de la barra de estado para alertar al usuario cuando se produzca un evento de mensaje. Aunque, comúnmente, un receptor de mensajes es simplemente una "puerta de enlace" a otros componentes y está destinado a realizar una cantidad mínima de trabajo. Por ejemplo, podría iniciar un servicio para que realice algunas tareas en función del evento.

Un receptor de mensajes se implementa como una subclase de BroadcastReceiver y cada receptor de mensajes se proporciona como un objeto Intent. 

## Samples

- ContentProviders

- AppFundamentals

- Services

- BroadcastReceivers

## Homework

## Resources

- App components https://developer.android.com/guide/components/fundamentals?hl=es-419

- Activity Lifecycle https://developer.android.com/training/basics/activity-lifecycle/?hl=es-419

- Activity https://developer.android.com/guide/components/activities?hl=es-419

- Introduction to Activities https://developer.android.com/guide/components/activities/intro-activities

- Content providers https://developer.android.com/guide/topics/providers/content-providers?hl=en

- Content provider basic https://developer.android.com/guide/topics/providers/content-provider-basics?hl=en

- Broadcast overview https://developer.android.com/guide/components/broadcasts

- Broadcast Receivers https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-concepts/content/en/Unit%203/73_c_broadcast_receivers.html

- Services overview https://developer.android.com/guide/components/services

- Create a background service (Intent service) https://developer.android.com/training/run-background-service/create-service

- Jobscheduler https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129

- Background tasks https://developer.android.com/training/best-background

- Background execution limits https://developer.android.com/about/versions/oreo/background

- Migrating to Android 8.0 (sdk 26) https://developer.android.com/about/versions/oreo/android-8.0-migration?hl=es-419

- Broadcast receiver sample https://developer.android.com/training/monitoring-device-state/battery-monitoring?hl=es-419



