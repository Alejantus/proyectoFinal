INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (1,'Mariscos congelados',true,null);
INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (2,'Pescado Blanco',false,null);
INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (3,'Pescado azul',false,null);
INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (4,'Cefalopodos',true,null);
INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (5,'Mariscos bivalvos',true,null);
INSERT INTO CATEGORIA (id_categoria, nombre, destacada, imagen) VALUES (6,'Mariscos frescos',true,null);

INSERT INTO PROVEEDOR (id_proveedor, nombre, codigo_postal, telefono, email, direccion) VALUES (7,'Pescados La Moneda',42173,617261739,'lamoneda5@gmail.com','C/ Rodio');
INSERT INTO PROVEEDOR (id_proveedor, nombre, codigo_postal, telefono, email, direccion) VALUES (8,'LITORAL FISH SL',42782,574836782,'litoral21@gmail.com','Av. de la República Argentina');
INSERT INTO PROVEEDOR (id_proveedor, nombre, codigo_postal, telefono, email, direccion) VALUES (9,'Pescaquivir S L',42683,489372481,'pescaquivirsl@gmail.com','C/ el Real de la Jara');
INSERT INTO PROVEEDOR (id_proveedor, nombre, codigo_postal, telefono, email, direccion) VALUES (10,'Brisas del Estrecho',54379,697793829,'estrechobrisa@gmail.com','C/ Álamo Blanco');

INSERT INTO PRODUCTO (id_producto, nombre, descripcion, precio, descuento, imagen, categoria_id_categoria, proveedor_id_proveedor, disponible, fecha_caducidad) VALUES (11,'Merluza','La merluza es uno de los pescados que aceptan más preparaciones, desde las recetas más sencillas a las más sofisticadas.',10,0.1,'https://www.supermercadosmas.com/media/catalog/product/cache/d91bc430dbe2e3d899436802c7aa5233/i/m/import_catalog_images_33_11_331156_v9.jpg',2,7,true,'2021-05-18');
