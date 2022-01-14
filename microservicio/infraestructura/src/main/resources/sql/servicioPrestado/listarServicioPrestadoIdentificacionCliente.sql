select * from cliente JOIN servicioPrestado ON cliente.id = servicioPrestado.idCliente
where cliente.identificacion = :identificacion