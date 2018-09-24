CREATE SCHEMA control_inventario DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

use control_inventario;

create table compras(
id_compra int(12) not null auto_increment primary key,
n_documento varchar(25) not null,
id_producto int(12) not null,
cantidad int(10),
monto double,
id_proveedor int(12) not null,
fecha_compra varchar(30)
);

create table ventas(
id_venta int(12) not null auto_increment primary key,
n_documento varchar(25) not null,
id_producto int(12) not null,
cantidad int(10),
monto double,
id_cliente int(12) not null,
id_usuario int(12) not null,
fecha_venta varchar(30),
id_sucursal int(12) not null,
id_inventario int(12) not null
);

create table facturas(
id_factura int(12) not null auto_increment primary key,
n_documento varchar(25) not null,
id_venta int(12) not null,
fecha_venta varchar(30),
id_sucursal int(12) not null
);

create table productos(
id_producto int(12) not null auto_increment primary key,
producto varchar(50),
id_proveedor int(12) not null,
id_fabricante int(12) not null
);

create table sucursales(
id_sucursal int(12) not null auto_increment primary key,
sucursal varchar(25),
direccion varchar(50),
municipio varchar(25),
departamento varchar(25),
telefono varchar(15)
);

create table usuario(
id_usuario int(12) not null auto_increment primary key,
usuario varchar(25),
correo varchar(25),
contra varchar(45),
cargo varchar(25)
);

create table proveedores(
id_proveedor int(12) not null auto_increment primary key,
proveedor varchar(50),
rubro varchar(25),
contacto varchar(25),
telefono varchar(25)
);

create table clientes(
id_cliente int(12) not null auto_increment primary key,
cliente varchar(25),
tipo_persona varchar(15),
direccion varchar(50),
telefono varchar(15)
);

create table inventario(
id_inventario int(12) not null auto_increment primary key,
id_producto int(12) not null,
cant int(12),
stock int(12),
estado varchar(20),
id_proveedor int(12) not null,
id_sucursal int(12) not null
);

create table fabricantes(
id_fabricante int(12) not null auto_increment primary key,
fabricante varchar(50),
direccion varchar(50),
telefono varchar(15)
);

ALTER TABLE compras ADD CONSTRAINT fk_compras_1 foreign key (id_producto) references productos (id_producto);
ALTER TABLE compras ADD CONSTRAINT fk_compras_2 foreign key (id_proveedor) references proveedores (id_proveedor);
ALTER TABLE ventas ADD CONSTRAINT fk_ventas_1 foreign key (id_producto) references productos (id_producto);
ALTER TABLE ventas ADD CONSTRAINT fk_ventas_2 foreign key (id_cliente) references clientes (id_cliente);
ALTER TABLE ventas ADD CONSTRAINT fk_ventas_3 foreign key (id_usuario) references usuario (id_usuario);
ALTER TABLE ventas ADD CONSTRAINT fk_ventas_4 foreign key (id_sucursal) references sucursales (id_sucursal);
ALTER TABLE ventas ADD CONSTRAINT fk_ventas_5 foreign key (id_inventario) references inventario (id_inventario);
ALTER TABLE facturas ADD CONSTRAINT fk_facturas_1 foreign key (id_venta) references ventas (id_venta);
ALTER TABLE facturas ADD CONSTRAINT fk_facturas_2 foreign key (id_sucursal) references sucursales (id_sucursal);
ALTER TABLE productos ADD CONSTRAINT fk_productos_1 foreign key (id_proveedor) references proveedores (id_proveedor);
ALTER TABLE productos ADD CONSTRAINT fk_productos_2 foreign key (id_fabricante) references fabricantes (id_fabricante);
ALTER TABLE inventario ADD CONSTRAINT fk_inventario_1 foreign key (id_producto) references productos (id_producto);
ALTER TABLE inventario ADD CONSTRAINT fk_inventario_2 foreign key (id_proveedor) references proveedores (id_proveedor);
ALTER TABLE inventario ADD CONSTRAINT fk_inventario_3 foreign key (id_sucursal) references sucursales (id_sucursal);