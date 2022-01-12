select * from cliente JOIN maquinaTrabajo ON cliente.id = maquinaTrabajo.idCliente
where cliente.identificacion = :identificacion