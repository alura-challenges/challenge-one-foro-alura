create table Respuestas (
id bigint not null	auto_increment,
mensaje varchar(255) unique,
id_Topico bigint not null,
fechaCreacion date not null,
id_Usuario bigint not null,
solucion bit default 0 not null,
primary key(id),
foreign key(id_Topico) references Topicos(id),
foreign key(id_Usuario) references Usuarios(id)) ENGINE=InnoDB;