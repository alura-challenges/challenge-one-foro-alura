create table Topicos (
id bigint not null	auto_increment,
titulo varchar(100),
mensaje varchar(255),
fechaCreacion date not null,
estado enum ('NO_RESPONDIDO', 'NO_SOLUCIONADO','SOLUCIONADO','CERRADO'),
id_Usuario bigint not null,
id_Curso bigint not null,
primary key(id),
foreign key(id_Usuario) references Usuarios(id),
foreign key(id_Curso) references Cursos(id)) ENGINE=InnoDB;

create unique index titulo_mensaje_uidx on Topicos (titulo,mensaje);