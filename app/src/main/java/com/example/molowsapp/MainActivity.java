package com.example.molowsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //views
    Button mRegisterBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init views
        mRegisterBtn = findViewById(R.id.register_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle register button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start RegisterActivity
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        //handle login button click
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Login Activity
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}

/*
En esta PARTE 33;
 - Cambiar la contraseña del usuario desde el editor del perfil

En esta PARTE 32;
 - Enseñaremos quien le ha dado like a tu anuncio
 - Click en like de un anuncio para ver a quien le ha gustado

En esta PARTE 31;
 - Bloquearemos un usuario
 - desbloquear un usuario
 - El Usuario bloqueado no podra enviar mensajes a aquellos que haya bloqueado ese usuario

En esta PARTE 29;
 - Resolver errores: null me gustas null comentarios
    No hemos asignado ningun valor a "pLikes y pComments" cuando añadimos una publicacion
    Solucion: Añadir un valor inicial de likes y comentarios a 0

 - Emviar Imagenes/photos por chat
    Cambiar chat row y chatActivity UI
    Mirar permisos de storage/camera
    Escoger imagen de camara o galleria
    Subir los datoa a firebase
    Añadir otro valor a ModelChat i.e. "type"
        Cuando el mensage sea texto, el tipo sera text
        Cuando el mensage sea imagen, el tipo sera imagen

En esta PARTE 28;
 - ReCode FCM (chat notifications)
    actualizaremos a su ultima version
    usaremos Volley en vez de retrofit
    Migraremos el proyecto a AndroidX
        Librerias necesarias;
        1) Volley
        2) Google gson

En esta PARTE 27;
 - Compartir anuncio
    tendremos que usar la clase FileProvider para compartir imagnes

En esta PARTE 26;
 - Enseñar ChatList
    Nombre Usuario
    Imagen de perfil del usuario
    Online/Offline status
    Ultimo mensaje

En esta PARTE 25;
 - Borrar Comentario
 - solo el mismo usuario podra borrar el comentario
    guardaremos el UID del usuario(el que añadio el comentario) en el comentario
    asi el UID del comentario sera igual al UID del usuario actual, eso significa
    que el comentario es del usuario conectado, asi podra eliminar el comentario
    en este basis

En esta PARTE 24;
 - Mostraremos los comentarios
 - Usaremos recyclerview para enseñar los comentarios
 - Cada comentario tendra:
    - Nombre del usuario (el cual comento)
    - Foto de perfil del usuario (el cual comento)
    - el contenido del comentario

En esta PARTE 23;
 - Añadir comentarios a cualquier anuncio
 - Para este añadiremos los comentarios en una nueva activity,
 donde los comentarios esten en una lista, y la opcion de añadir comentarios estara disponible

En esta PARTE 22;
 - Me gusta anuncio
    - Añadir "Like Post" en la app
    - Añadir otra key(pLikes) en cada post, la cual contenga el total de numero de likes
    - Añadir boton de like
    >Como Database(de likes) como se verria?
     - PostID
        UID(del usuario registrado): Like
        UID(del usuario registrado): Like
        UID(del usuario registrado): Like
     +PostID
     +PostID
     +PostID

En esta PARTE 21;
 - Editar anuncios
    - añadir la opcion de editar en el popup menu
    - no crearemos otra activity para editar los anuncios, usaremos AddPostActivity para editar.
    - Clicando en "Editar" usaremos AddPostActivity con la key "editPost"
    - Cuando AddPostActivity se lance miraremos si tiene el intent String extra "editPost" y ahi editaremos

En esta PARTE 20;
 - Borrar Anuncio;
    Crear Popup Menu
    Cuando el ususario clike en los 3 botones de cualquier anuncio, le saldra un Popup menu con la option de borrar
    La opcion de borrar solo saldra en los anuncios de cada usuario
    Cuando el boton de borrar se pulse, ese anuncio se borrara

    Logica:
    Compararemos los uid de los usuarios con los uids de los anuncios
    Cuando las uids concidan, significan que ese uid pertenece a ese anuncio

    haremos esto en AdapterPosts

En esta PARTE 19;
Enseñar los posts de cada usuario
    -los anuncios de cada usuario se veran en el perfil
    -los otros usuarios podran ver sus anuncios en ThereProfileActivity
Cambios;
1)Click en cualquier usuario desplegara un dialog con dos opciones
    1) chat: ir al chat con esa persona
    2)Perfil: ver su perfil
2)Cambios en PostsList
    1)Click en la parte de arriba de un anuncio para enseñar el perfil del usuario del anuncio
    2)Esconder addPost del toolbar

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 18;
Enseñar todos los anuncios añadidos por los usuarios en HomeFragment
    1) Añadir recyclerview en HomeFragment
    2) crear row.xml para recyclerview
    3)crear Model class para recyclerView
    4)crear adapter class para recylerview
    5)obtener y enseñar post in recyclerview

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 17;
Publicar un anuncio a firebase.
    Publicar contendra usuario, nombre, email, uid, dp, Tiempo de publicacion, titulo descripcion, imagen, etc
    Usuario puede publicar un anuncio con imagen y sin imagen
    Crear AddPostActivity
    Añadir otra opcion en el action bar para ir a AddPostActivity
    Imagen puede ser importada de la galeria o de la camara

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 16;
 - Enviar notificacion de mensaje(Usanso FCM (Firebase Cloud Messaging))
    Cuando el usuario envie un mensaje, el recibidor recibira una notificacion con el mensaje
    Cuando el usuario clique en la notificacion abrira el chat con esa persona

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
En esta PARTE 15;
Eliminar Mensaje
    Quien puede eliminar el que?
    1) El que envia el mensaje es el unico que puede eliminar el mensaje o
    2) El que envia el mensaje puede eliminar mensajes recimidos y enviados
    despues de hacer el click de eliminar que pasa?
    1) Mover mensaje o
    2) Actualizar valor de mensaje a "this message was deleted"

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 14;
    Enseñar escribiendo status del usuario en toolbar de chat activity
    Cuando el usruaio Registrado, añadir una nueva variable llamada typingTo teniendo valor recibido UID
    Añadir textChange listener para edit text
    EditText no vacio significa que el usuario esta escribiendo algo
    asique asignamos el vamor recibido uid
    EditText vacio significa que el usuario no esta escribiendo
    asique asignamos a noOne

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 13;
-Enseñar Online/desconectado del usuario en toolbar del chat activity
    Cuando el usuario registrado, añadir una variable llamada onlineStatus con valor online
    Crear metodo para ver si estas en linea o desconectado...
    Llamar al metodo en onStart con el valor online
    Llamar al metodo en onPause con el valor desconectado
    obtener el valor si esta online

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 12;
Enseñar mensages enviado
    -Diseñar Diefrentes layouts para enviar y recibir
    -uso fondos customizables para enviar y recibir
    -Recibir Layout(en la izquierda) contendra la imagen del perfil, mensaje y la hora
    -Enviar Layout(en la derecha) contendra mensaje y hora

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 11;
    Enseñar la foto de perfil y nombre en el toolbar
    Enviar mensaje a cualquier usuario

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 10;
    Diseñar Chat Activity [Crear nueva Empty Activity]
    Toolbar contendra icono, nombre y status como online/offline.
    Añadir nuevo Fragment para Chats List
    Añadir este fragment al BottomNavigation

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En est PARTE 9;
Buscador para Usuarios de la lista
    1) por Nombre
    2) por Email

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 8;
-Enseñar Usuarios de Firebase Realtime database en un RecyclerView
    Enseñaremos la siguiente info de los usuarios:
    1) Profile Picture: en CircularImageView[library]
    2) Nombre
    3) Email
    Añadir libreria CardView
    Añadir libreria RecyclerView
    Añadir libreria CircularImageView

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 7;
--Editar Perfil:
    1) Nombre
    2) Telefono
    3) Foto de Perfil
    4) Cover Photo
--Requisitos:
    1) Persmisos de Camara y Storage (Para escoger una imagen de la galeria o desde la camara)
    2) Librerias de Firebase Storage (para enviar y recivir la imagen de perfil)
--UI Update:
    1) Añadir ImageView
    2) Añadir FloatingActionButton para enseñar el dialog containing options para editar el perfil
    3) Añadir Imagen por defecto al perfil

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 6;
    Diseño de perfil de usuario
    Obtener la informacion del ususario desde firebas
    Enseñar la info del usuario

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta Parte 5;
1- Guardar la info del ususario(name, email, uid, phone, image)
    en firebase realtime database.
    Requisitos:
    1)  Añadir Firebase Realtime database
    2) Cambiar las reglas de firebase realtime database
2- Añadir Bottom Navigation en el Profile Activity con tres menus
    1)   Home
    2)  Profile (User info like name, email, uid, phone, image)
    3) todos los usuarios

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 4;
Añadir Google Sign-In
    Requisitos:
    Enable Google sign-in desde Firebase Authentication
    Añadir soporte para el email en el Proyecto
    Añadir SHA-1 Certificacion
    Añadir libreria Google Sign-In

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 3;
1- Añadir recuperar Password en LoginActivity
2- Clicancdo en password olvidada enseñara un contenedor de dialogo
    TextView(como label)
    EditText(input email)
    Button(enviara intrucciones de la password) a tu mail
3- Pequeños imprevisto

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 2;
    1- Crear el activity del perfil
    2- Ver si ya hay un usuario registrado o no
    3- Crear Login
    4- Login con contraseña e email
    5- despues de loguearse ir al Perfil
    6- Añadir opciones al menu para salir
    7- Despues de salir ir al Main

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

En esta PARTE 1;
    1- Añadir internet permision para Firebase
    2- Añadir Registro y Login Botones en el Main
    3- Crear Registro
    4- Crear Firebase proyecto y conectarlo a la app
    5- Chequear google-services.json para estar seguros de que la app este conectada a firebase
    6- User Registro usando email y contraseña
    7- Crear Perfil
    8- Launcher
*/