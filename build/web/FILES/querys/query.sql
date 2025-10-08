create database supermercado
go
use supermercado
go
create table usuario(
id int identity(1,1) not null primary key,
correo varchar(30) unique not null,
clave varchar(150) not null,
estado varchar(20) not null
)
go
select * from usuario
go