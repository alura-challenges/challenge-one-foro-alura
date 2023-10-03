create table usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario varchar(100) not null,
    email varchar(50) not null,
    contrasena varchar(300) not null,

    primary key(id)
);

create table cursos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre varchar(200) not null,
    categoria varchar(50),

    primary key(id)
);

create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(200) not null unique,
    fecha_creacion DATETIME not null,
    status varchar(30),
    autor BIGINT not null,
    curso BIGINT not null,

    primary key(id),
    constraint fk_topicos_cursos_id FOREIGN KEY(curso) REFERENCES cursos(id),
    constraint fk_usuario_usuarios_id FOREIGN KEY(autor) REFERENCES usuarios(id)
);

create table respuestas(
     id BIGINT NOT NULL AUTO_INCREMENT,
     mensaje varchar(300) not null,
     topico_id BIGINT not null,
     fecha_Creacion DATETIME not null,
     usuario_id BIGINT not null,
     solucion tinyint,

     primary key(id),
     CONSTRAINT fk_respuestas_topico_id FOREIGN KEY(topico_id) REFERENCES topicos(id),
     CONSTRAINT fk_respuestas_usuarios_id FOREIGN KEY(usuario_id) REFERENCES usuarios(id)
 );