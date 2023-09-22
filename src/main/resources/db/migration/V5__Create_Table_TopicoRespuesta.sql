create table Topico_Respuesta (
id_Topico bigint not null,
id_Respuesta bigint not null,
foreign key(id_Topico) references Topicos(id),
foreign key(id_Respuesta) references Respuestas(id)) ENGINE=InnoDB;