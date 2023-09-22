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
Este reto cosiste en aplicar los conocimientos adquiridos en el programa ONE sobre <strong>Spring Boot 3 - JAVA API Rest</strong> y <strong>Spring Security - JWT </strong>. Este proyecto se enfoco a nivel de <strong>back end</strong> para replicar los procesos de la administracion de topicos de un foro, utilizando la <strong>arquitectura de software</strong> conocido como <strong>REST</strong>. Mediante del uso de <strong>HTTP Request</strong> la API respondera a las diferentes acciones de <strong>CRUD</strong> (CREATE, READ, UPDATE, DELETE), finalmente la API aplica conceptos de <strong>Spring Security</strong> mediante el uso de <strong>token JWT</strong>(JOSON WEB TOKEN).
</p>
<h2>Acerca del reto</h2>
El reto cosiste en crear una API Rest con Spring Boot 3, que repique a nivel de back end parte de los procesos de un Foro. Este reto se divide en dos partes, la primera es sobre la aplicación del CRUD en la creación de Tópicos, y la segunda sobre autenticación y seguridad.
<br>
<br>
La primera parte <strong>(Spring 1)</strong> consiste en que la API debe de permitir a los usuarios realizar las siguientes acciones:
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
La Segunda parte <strong>(Spring 2)</strong> consiste ...:
<li>
   <strong>Titulo</strong> detalle.
   <ol>
      <li>
         <code>regla</Code>
      </li>
   </ol>

 <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/AluraChanllenges.svg" height="100">

<h2>Tecnologías utilizadas</h2>
<p align="left">
   <img src="https://img.shields.io/badge/Eclipse%20IDE-2023%2006%20-8A2BE2">
   <img src="https://img.shields.io/badge/MySQL-8.0.34-8A2BE2">
   <img src="https://img.shields.io/badge/Spring%20Boot-3.0.6-8A2BE2">
   <img src="https://img.shields.io/badge/Maven-4.0.0-8A2BE2">
   <img src="https://img.shields.io/badge/Lombok-1.18.30-8A2BE2">
   <img src="https://img.shields.io/badge/JDK-17-8A2BE2">   
   
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
</ol>
<img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Tecnologias_1.svg" height="60"> <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Tecnologias_2.svg" height="60">
<h3>Spring boot dependecies:</h3>
<ol>
   <li>Spring Web.</li>
   <li>Spring Boot DevTools.</li>
   <li>Lombok.</li>
   <li>Spring Data JPA.</li>
   <li>Flyway Migration.</li>
   <li>MySQL Driver.</li>
   <li>Validation.</li>
</ol>


<h2>Pruebas de la API</h2>
Las pruebas de funcionalidad de API se pueden realizar en alguna herramienta de prueba de API, como Postman o Insomnia
<li><a href="https://www.postman.com/"><img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/LogoPostman.svg" height="25"> Postman</a></li>
<li><a href="https://insomnia.rest/"><img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/LogoInsomnia.svg" height="25"> Insomnia</a></li>
<br>
A continuacion se mostraran las purbas realizadas a la API con <strong>Postman</strong>.

<h3>Pruebas Spring 1</h3>
<p align="left">
   <img src="https://img.shields.io/badge/PRUEBAS%20SPRING%201-4-orange">
</p>
1. Registro de nuevo Topico.<br>
Para esta prueba se creó una HTTP POST request con la URI <code>http://localhost:8080/topicos</code>, después se envió un JSON con la siguiente estructura:

```
{
   "titulo":"Pagina blanca Error",
   "mensaje":"Al crear controller Hola",
   "id_autor":"1",
   "id_curso":"1"
}
```
<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Prueba01_RegristrarTopico.JPG" height="300">
   </kbd>
</p>

> Validaciones: <br>
> * Si el JSON se envia por segunda vez o se repeite el titulo y mensaje retornadará un error 500 por duplicidad.<br>
> * Si falta alguno de los campos o estan en blanco, se retornará un error 400 Bad Request.

2. Mostrar todos los topicos.<br>
Para esta prueba se creó una HTTP GET request con la URI <code>http://localhost:8080/topicos</code>, después del envio se retornará una lista de JSON como la siguiente:

```
[
    {
        "id": 1,
        "titulo": "Pagina blanca Error 2",
        "mensaje": "Al crear controller Hola",
        "fechaCreacion": "2023-09-21T00:00:00",
        "estado": "NO_RESPONDIDO",
        "id_autor": 1,
        "autor": "Admin",
        "id_curso": 1,
        "curso": "Spring Boot 3"
    },
    {
        "id": 4,
        "titulo": "Pagina blanca Error",
        "mensaje": "Al crear controller Hola",
        "fechaCreacion": "2023-09-22T00:00:00",
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
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Prueba02_GetTopicos.JPG" height="500">
   </kbd>
</p>

3. Actualización de topico.<br>
Para esta prueba se creó una HTTP PUT request con la URI <code>http://localhost:8080/topicos</code>, después se envió un JSON con la siguiente estructura:

```
{
    "id": "1",
    "titulo":"Pagina blanca Error 2",
    "mensaje":"Al crear controller Hola",
    "id_autor":"1",
    "id_curso":"1"
}
```
<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Prueba03_PutTopico.JPG" height="300">
   </kbd>
</p>

> Observaciones <br>
> * Solo el id y id_autor son obligatorios, si faltan o estan en blanco, se retornará un error 400 Bad Request.<br>
> * Si un campo no obligatorio esta nulo o en blanco, este no se actualizara en la base de datos.
> * Si el campo titulo y mensaje ya exiten en la BD, se retornara un error 500, por duplicidad.
> * Si cualquiera de los id no exiten en la BD, tambien se retonará un error 500.

4. Eliminacion de Topico. <br>
Para esta prueba se creó una HTTP DELETE request con la URI <code>http://localhost:8080/topicos/{id}</code>, después del envio se eliminará el topico con el id especificado en el URI {id}.
<p align="Center">
   <kbd>
      <img src="https://github.com/CMZhn/Foro_Alura_ONE_G5/blob/main/Readme_Recursos/Prueba04_DeleteTopico.JPG" height="300">
   </kbd>
</p>

<br>
<h3>Pruebas Spring 2</h3>
<p align="left">
   <img src="https://img.shields.io/badge/PRUEBAS%20SPRING%202-0-orange">
</p>



<h2>Autor</h2>
<p align="center"><strong><a href="https://github.com/CMZhn"><em>Carlos Melgar</em></a></strong></p>
<p align="center"><strong>2023</strong></p>
