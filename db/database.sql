create table t_alumnos (
	id_t_usuarios SERIAL not null,
	nombre varchar (80),
	ap_paterno varchar(80),
	ap_materno varchar(80),
	activo int,
	primary key (id_t_usuarios)
);
insert into t_alumnos values (default,"John","Dow","Down",1);

create table t_materias (
    id_t_materias SERIAL not null,
    nombre varchar(80),
    activo int,
    primary key (id_t_materias)
);
insert into t_materias values (default,'matematicas',1); insert
into t_materias values (default,'programacion I',1); insert into
t_materias values (default,'ingenieria de sofware',1);

create table t_calificaciones (
    id_t_calificaciones SERIAL not null,
    id_t_materias int not null,
    id_t_usuarios int not null,
    calificacion decimal (10,2),
    fecha_registro date,
    primary key (id_t_calificaciones),
    foreign key (id_t_materias) references t_materias (id_t_materias),
foreign key (id_t_materias) references t_materias (id_t_materias) );


create table t_profesores (
	id_t_profesores SERIAL not null, 
	nombre varchar(80),
	primary key(id_t_profesores)
);

insert into t_profesores values (default, 'Pablo');


create table t_profesores_materia (
	id_t_profesores_materia SERIAL not null, 
	id_t_materias int not null, 
	id_t_profesor int not null,
	fecha_registro date, 
	primary key (id_t_profesores_materia),
	foreign key(id_t_materias) references t_materias (id_t_materias),
	foreign key(id_t_profesor) references t_profesores (id_t_profesores)
);
