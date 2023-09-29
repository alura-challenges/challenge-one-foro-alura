create table Usuarios (
id bigint not null	auto_increment,
nombre varchar(100) not null unique,
email varchar(100) not null unique,
contrasena varchar(300) not null,
primary key(id));

INSERT INTO Usuarios (nombre, email, contrasena) 
VALUES ('Admin', 'admin@g.com', '$2a$10$aga6Mf8jeIvEW/EWuC969e8NnQhVFP1wm8k.pnRf/x/1uBmkDC3vG');