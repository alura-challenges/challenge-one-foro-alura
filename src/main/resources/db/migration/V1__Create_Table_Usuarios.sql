create table Usuarios (
id bigint not null	auto_increment,
nombre varchar(100) not null unique,
email varchar(100) not null unique,
contrasena varchar(50) not null,
primary key(id));