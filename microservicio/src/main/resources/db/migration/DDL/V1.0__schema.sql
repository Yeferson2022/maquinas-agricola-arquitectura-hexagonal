create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 identificacion varchar(45) not null,
 vereda varchar(45) not null,
 primary key (id)
);
create table maquinaTrabajo (
    id int(11) not null auto_increment,
    idCliente int(11),
    identificacionMaquina varchar(50) not null,
    tipoTrabajo int(1) not null,
    cantidadHorasCargas int(10),
    total int(6),
    fechaUltimoMantenimiento varchar(45),
    fechaProximoMantenimiento varchar(45),
    primary key (id),
    foreign key (idCliente) references cliente(id)
);

