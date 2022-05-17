drop table categoria if exists;
drop table producto if exists;
drop table proveedor if exists;
drop sequence if exists hibernate_sequence;

create table categoria (
	id bigint not null, 
	destacada boolean not null, 
	imagen varchar(512), 
	nombre varchar(512), 
	primary key (id)
);

create table producto (
	id bigint not null, 
	descripcion varchar(512), 
	descuento float not null, 
	imagen varchar(512), 
	nombre varchar(512), 
	precio float not null, 
	categoria_id bigint,
	proveedor_id bigint 
	primary key (id)
);

create table proveedor (
	id bigint not null, 
	nombre varchar(512), 
	codigoPostal int not null,
	direccion varchar(512),
	email varchar(512),
	telefono int not null,
	primary key (id)
);