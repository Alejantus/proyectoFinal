INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (1,'Mariscos congelados',true,null);
INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (2,'Pescado Blanco',false,null);
INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (3,'Pescado azul',false,null);
INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (4,'Cefalopodos',true,null);
INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (5,'Mariscos bivalvos',true,null);
INSERT INTO CATEGORIA (id_categoria, NOMBRE, DESTACADA, IMAGEN) VALUES (6,'Mariscos frescos',true,null);

INSERT INTO PROVEEDOR (id_proveedor, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL, DIRECCION) VALUES (7,'Pescados La Moneda',42173,617261739,'lamoneda5@gmail.com','C/ Rodio');
INSERT INTO PROVEEDOR (id_proveedor, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL, DIRECCION) VALUES (8,'LITORAL FISH SL',42782,574836782,'litoral21@gmail.com','Av. de la República Argentina');
INSERT INTO PROVEEDOR (id_proveedor, NOMBRE, CODIGOPOSTAL, TELEOFONO, EMAIL, DIRECCION) VALUES (9,'Pescaquivir S L',42683,489372481,'pescaquivirsl@gmail.com','C/ el Real de la Jara');
INSERT INTO PROVEEDOR (id_proveedor, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL, DIRECCION) VALUES (10,'Brisas del Estrecho',54379,697793829,'estrechobrisa@gmail.com','C/ Álamo Blanco');

INSERT INTO PRODUCTO (id_producto, NOMBRE, DESCRIPCION, PRECIO, DESCUENTO, IMAGEN, CATEGORIA_ID, PROVEEDOR_ID) VALUES (11,'Merluza','La merluza es uno de los pescados que aceptan más preparaciones, desde las recetas más sencillas a las más sofisticadas.',10,0.1,'https://www.supermercadosmas.com/media/catalog/product/cache/d91bc430dbe2e3d899436802c7aa5233/i/m/import_catalog_images_33_11_331156_v9.jpg',2,7);
