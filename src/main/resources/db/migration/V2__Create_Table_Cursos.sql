create table Cursos (
id bigint not null	auto_increment,
nombre varchar(100) unique,
categoria varchar(100) unique,
primary key(id));