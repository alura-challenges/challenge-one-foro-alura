<p align="center"><img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/RearmeBanner.svg") </p>

<h1 style="color:rgb(12, 160, 94)">Challenge Back End Java - Foro Alura</h1>
<p align="left">
   <img src="https://img.shields.io/badge/ESTADO-FINALIZADO-brightgreen">
   <img src="https://img.shields.io/badge/LIBERACI%C3%93N-SEPTIEMBRE%202023-rgb(162%2C162%2C40)">
   <img src="https://img.shields.io/badge/VERSI%C3%93N-V1.0.23-rgb(15%2C128%2C193)">
   <img src="https://img.shields.io/github/repo-size/CMZhn/Foro_Alura_ONE_G5">
</p>

Cuarto reto de <a href="https://www.aluracursos.com/">Alura</a> + <a href="https://www.oracle.com/mx/education/oracle-next-education/">Oracle Next Education</a> grupo 5.
<br>
<p>
Este reto cosiste en aplicar los conocimientos adquiridos en el programa ONE sobre <strong>Spring Boot 3 - JAVA API Rest</strong> y <strong>Spring Security - JWT </strong>. Este proyecto se enfoco a nivel de <strong>back end</strong> para replicar los procesos de la administracion de topicos de un foro, utilizando la <strong>arquitectura de software</strong> conocido como <strong>REST</strong>. Mediante del uso de <strong>HTTP Request</strong> la API respondera a las diferentes acciones de <strong>CRUD</strong> (CREATE, READ, UPDATE, DELETE), finalmente la API aplica conceptos de <strong>Spring Security</strong> mediante el uso de <strong>token JWT </strong>(JOSON WEB TOKEN).
</p>
<h2>Acerca del reto</h2>
El reto cosiste en crear una API Rest con Spring Boot 3, que repique a nivel de back end parte de los procesos de un Foro. Este reto se divide en dos partes, la primera es sobre la aplicación del CRUD en la creación de Tópicos, y la segunda sobre autenticación y seguridad.
<br>
<br>
<h3>La primera parte - <strong>Spring 1</strong></h3>
Esta parte consiste en que la API debe de permitir a los usuarios realizar las siguientes acciones:
<ol>
<li>
  <code>Crear un nuevo tópico</Code>
</li>
<li> 
  <code>Mostrar todos los tópicos creados</Code>
</li>
<li>
  <code>Mostrar un tópico específico</Code>
</li>
<li>
  <code>Actualizar un tópico</Code>
</li>
<li>
  <code>Eliminar un tópico</Code>
</li>
</ol>
También la API deberá cumplir con las siguientes reglas de negocio para cada una de estas acciones:
<li>
   <strong>Registro de un nuevo tópico</strong> mediante un POST al URI <code>/topicos</code> de un <strong>JSON</strong> con el titulo, mensaje, autor y curso en el body.
   <ol>
      <li>
         <code>Todos los campos del JSON son obligatorios.</Code>
      </li>
      <li>
         <code>La API no debe permitirlos registros duplicados (que contengan el mismo el mismo título y mensaje).</Code>
      </li>
   </ol>
</li>
<li>
   <strong>Listar todos los topicos</strong> mediante un GET al URI <code>/topicos</code>, cuyo retornó será una lista de <strong>JSON</strong> con titulo, mensaje, fecha de creación, estado, autor y curso en el body.
</li>
<li>
   <strong>Actualizacón de un tópico</strong> mediante un PUT al URI <code>/topicos</code> de un <strong>JSON</strong> con el id, titulo, mensaje, autor y curso en el body.
   <ol>
      <li>
         <code>El campo de id y autor son obligatorios.</Code>
      </li>
      <li>
         <code>El autor no se debe acturalizar.</Code>
      </li>
      <li>
         <code>Solo el autor del topico puede actualizar el titulo, mensaje y curso.</Code>
      </li>
      <li>
         <code>Los campos que llegen nullos o en blanco no se debe de actualizar.</Code>
      </li>
      <li>
         <code>La API no debe permitirlos registros duplicados (que contengan el mismo el mismo título y mensaje).</Code>
      </li>
   </ol>
</li>
<li>
   <strong>Detalle de un tópico</strong> mediante un GET al URI <code>/topicos/{id}</code>, cuyo retornó será un <strong>JSON</strong> con titulo, mensaje, fecha de creación, estado, autor y curso en el body.
</li>
<li>
   <strong>Eliminación de un tópico</strong> mediante un DELETE al URI <code>/topicos/{id}</code>, cuya accion elimnará el topico del la base de datos.
</li>

<br>
<h3>La egunda parte - <strong>Spring 2</strong></h3>
Esta parte consiste en la seguridad de la API con Spring Boot Segurity, también incluye la documentación de la misma con Swagger, para esta parte la API de de cumplir con los siguientes requisitos:
<li>
   <strong>Seguridad de la API</strong>.
   <ol>
      <li>
         <code>Debe de existir un endpoint publico para la autenticación de los Usuarios, con un JSON con el nombre del usuario y su contraseña.</Code>
      </li>
      <li>
         <code>Después de la autenticación, si esta es exitosa (OK 200), la solicitud debe retornar con un JWT.</Code>
      </li>
      <li>
         <code>Para acceder a las operaciones de los controladores se debe autenticar por medio del un JWT en le Header del la solicitud HTTP.</Code>
      </li>
   </ol>
</li>
<li>
   <strong>Documentación</strong>.
   <ol>
      <li>
         <code>La API debe implementar una interfaz facil amigable y accesible, con la cual el usuario mediante un explorador Web podra tener acceso a las operaciones de la API <strong>(SpringFox Swagger)</strong>.</Code>
      </li>
      <li>
         <code>Agregar una descripción a las operaciones de los controladores.</Code>
      </li>
      <li>
         <code>Configurar los accesos para que la interfaz de Swagger sea accesible.</Code>
      </li>
      <li>
         <code>Configurar Swagger para con esta interfaz el usuario pueda autenticarse.</Code>
      </li>
   </ol>
</li>
 <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/AluraChanllenges.svg" height="100">

<h2>Tecnologías utilizadas</h2>
<p align="left">
   <img src="https://img.shields.io/badge/Eclipse%20IDE-2023%2006%20-8A2BE2">
   <img src="https://img.shields.io/badge/MySQL-8.0.34-8A2BE2">
   <img src="https://img.shields.io/badge/Spring%20Boot-3.0.6-8A2BE2">
   <img src="https://img.shields.io/badge/Maven-4.0.0-8A2BE2">
   <img src="https://img.shields.io/badge/Lombok-1.18.30-8A2BE2">
   <img src="https://img.shields.io/badge/JDK-17-8A2BE2">
   <img src="https://img.shields.io/badge/JWT%20Auth0-4.2.0-8A2BE2">
   <img src="https://img.shields.io/badge/Springdoc%20openapi-2.1.0-8A2BE2">    
   
</p>
Para el desarrollo de este proyecto se utilizó las siguientes tecnologías:
<br>
<ol>
   <li>
      <a href="https://www.eclipse.org/downloads/">Eclipse</a> 2023-06 (4.28.0).
   </li>
   <li>
      <a href="https://dev.mysql.com/downloads/workbench/">MySQL</a> 8.0.34.
   </li>
   <li>
      <a href="https://start.spring.io/">Spring Boot</a> 3.0.6.
   </li>
   <li>
      <a href="https://maven.apache.org/">Maven</a> 4.0.0.
   </li>
   <li>
      <a href="https://projectlombok.org/setup/eclipse">Lombok</a> 1.18.30 (eclipse plugin).
   </li>
   <li>
      <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">JDK</a> 17.
   </li>
   <li><a href="https://github.com/auth0/java-jwt">JAVA-JWT Auth0</a> 4.2.0.
   </li>
   <li><a href="https://springdoc.org/">Spring Doc Open API -Swagger</a> 2.1.0.
   </li>
</ol>
<img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Tecnologias_1.svg" height="60"> <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Tecnologias_2.svg" height="60"> <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Tecnologias_3.svg" height="60">
<h3>Spring boot dependecies:</h3>
<ol>
   <li>Spring Web.</li>
   <li>Spring Boot DevTools.</li>
   <li>Lombok.</li>
   <li>Spring Data JPA.</li>
   <li>Flyway Migration.</li>
   <li>MySQL Driver.</li>
   <li>Validation.</li>
   <li>Spring Security</li>
   <li>auth0 java-jwt</li>
   <li>Springdoc Openapi</li>
</ol>


<h2>Funcionamiento del proyecto</h2>
<h3>Preparando el ambiente</h3>
Para probar el funcionamiento de la API de este repository, primero debe de tener instalado el JDK y un IDE para proyectos Java Maven.
<br><br>
Despues de descargar y descomprimir en su PC el proyecto de este repositorio, importelo a su IDE, despues actualice el <code>pom.xml</code>, para que se descargen todas las dependencias del proyecto.
<br><br>

>**Nota**
> 
> La version de Sring framework boot puede cambiar, por lo que si tienen problemas con la actualizacion del <code>pom.xml</code>, visite <a href="https://start.spring.io/">Spring Boot Initializer</a> y cambie la version por la mas cercana a la utilizada en este proyecto.
>

<br>
Después de instalar las dependencias y preparar el entorno del IDE, instsle MySQL workbench 8, y cree la base de datos con el siguienete SQL:

```
CREATE DATABASE foro_alura;
```

Luego diríjase a las propiedades de la aplicación en archivo <code>application.properties</code> en <code>\src\main\resources</code>, en este achivo configure las propiedades de conexión a la base de datos URL, Usuario y contraseña.

```
spring.datasource.url=jdbc:mysql://localhost:3306/foro_alura
spring.datasource.username= usuario
spring.datasource.password= contraseña
```

 Por defecto la API, si no exite la tabla Usuarios, esta se creara con el usuario <strong>Admin</strong> con contraseña <strong>1234</strong>. Si desea modificar este usuario, antes de ejecutar por primera vez la API, debe modificar el SQL V1 en <code>\src\main\resources\db\migration</code>. recuede que la contraseña debe de estar encriptada, para esto puede utilizar este el <a href="https://www.browserling.com/tools/bcrypt">Bcrypt Generator</a>. 
 
 El usuario configurado lo puede cambiar modificando los valores del siguiente del SQL V1:

 ```
INSERT INTO Usuarios (nombre, email, contrasena) 
VALUES ('Admin', 'admin@g.com', '$2a$10$aga6Mf8jeIvEW/EWuC969e8NnQhVFP1wm8k.pnRf/x/1uBmkDC3vG');
```

>**Nota**
> 
> Al ejecutar por primera vez Flyway automaticamente realizara la migracion a la base que usted haya configurado en las propiedades de la aplicacion. Si ya ejecuto el servidor y no modifico el usuario por defecto, debe ir al la base de datos y realizar alli las actualizaciones, o bien deteniendo el servidor, y agregando un SQL al la migracion.

Finalmente dirijase a la clase principal <code>ForoInicialApplication</code> en el paquete <code>com.alura.foro</code>, ejecutela para iniciar el servidor.

<h3>Realizacion de HTTP Request (Utilizando la API)</h3>
<br>
Para utilizar esta API pueden utilizar Postman o Insomnia, que son herramientas para probar HTTP request:
<li><a href="https://www.postman.com/"><img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/LogoPostman.svg" height="25"> Postman</a></li>
<li><a href="https://insomnia.rest/"><img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/LogoInsomnia.svg" height="25"> Insomnia</a></li>
<br>
Tambien puede probar esta API con su explorador WEB, ya que este proyecto incluye la interfaz grafica de <strong>Springdoc Openapi</strong>.

<h3>Algunas prubas de Funcionalidad con Springdoc Openapi</h3>
1. Autenticación y generación de JWT<br>

En su explorador acceda al URI de Swagger en la direccion de su servidor, en este caso es <code>http://localhost:8080/swagger-ui/index.html#/</code>, después acceda a la opcion de <strong>Autenticacion</strong> y realice la solicitud Htpp:

<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/P01_Login.jpg" height="500">
   </kbd>
</p>

Despues de ejecutar la solicitud, la API le retornara el JWT si el usuario es valido y esta en la Base de datos: <br>

<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/P01_Login_Retorno.jpg" height="120">
   </kbd>
</p>
Utelice este JWT para obtener el acceso a las demas funcionalidades de la API, accediendo a Authorize e ingresando el toquen en el campo Value: <br>

<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/P01_Login_Autorizacion.jpg" height="280">
   </kbd>
</p>


2. Registrando primer curso<br>
Dirijase a la opcion curso-controller en la operacion POST/cursos, y ejecute la siguiente request body:

```
{
  "nombre": "Spring Boot 3",
  "categoria": "Programacion"
}
```
Si la consulta es exitosa le retornara el JSON con el curso creado:
```
{
  "id": 1,
  "nombre": "Spring Boot 3",
  "categoria": "Programacion"
}
```
3. Registrando primer topico<br>
> **Nota**
>Para poder realizar esta operacion, debe de tener registrado al menos un curso.<br>

Dirijase a la opcion topicos-controller en la operacion POST/topicos, y ejecute la siguiente request body:

```
{
   "titulo":"Pagina blanca Error",
   "mensaje":"Al crear controller Hola",
   "id_autor":"1",
   "id_curso":"1"
}
```

Si la consulta es exitosa le retornara el JSON con el topico creado:

```
{
  "id": 1,
  "titulo": "Pagina blanca Error",
  "mensaje": "Al crear controller Hola",
  "fechaCreacion": "2023-09-28T19:57:51.0443519",
  "estado": "NO_RESPONDIDO",
  "id_autor": 1,
  "autor": "Admin",
  "id_curso": 1,
  "curso": "Spring Boot 3"
}
```

4. Mostrar todos los topicos.<br>
Dirijase a la opcion topicos-controller en la operacion GET/topicos, y ejecute el HTTP.después del envio se retornará una lista de JSON como la siguiente:

```
[
  {
    "id": 1,
    "titulo": "Pagina blanca Error",
    "mensaje": "Al crear controller Hola",
    "fechaCreacion": "2023-09-28T00:00:00",
    "estado": "NO_RESPONDIDO",
    "id_autor": 1,
    "autor": "Admin",
    "id_curso": 1,
    "curso": "Spring Boot 3"
  },
  {
    "id": 2,
    "titulo": "Problema de servidor",
    "mensaje": "Al iniciar el servidor falla la migracion",
    "fechaCreacion": "2023-09-28T00:00:00",
    "estado": "NO_RESPONDIDO",
    "id_autor": 1,
    "autor": "Admin",
    "id_curso": 1,
    "curso": "Spring Boot 3"
  }
]
```
<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/P04_Lista_Tipicos.jpg" height="400">
   </kbd>
</p>


<h2>Autor</h2>
<p align="center"><strong><a href="https://github.com/CMZhn"><em>Carlos Melgar</em></a></strong></p>
<p align="center"><strong>2023</strong></p>
