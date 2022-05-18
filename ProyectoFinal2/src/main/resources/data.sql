INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (1,'Mariscos fresco',true,null);
INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (2,'Pescado Blanco',false,null);
INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (3,'Pescado azul',false,null);
INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (4,'Moluscos bivalvos',true,null);
INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (5,'Cefalopodos',true,null);
INSERT INTO CATEGORIA (ID, NOMBRE, DESTACADA, IMAGEN) VALUES (6,'Mariscos congelados',true,null);

INSERT INTO PROVEEDOR (ID, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL) VALUES (7,'Pescados La Moneda',42173,617261739,lamoneda5@gmail.com);
INSERT INTO PROVEEDOR (ID, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL) VALUES (8,'LITORAL FISH SL',42782,574836782,litoral21@gmail.com);
INSERT INTO PROVEEDOR (ID, NOMBRE, CODIGOPOSTAL, TELEOFONO, EMAIL) VALUES (9,'Pescaquivir S L',42683,489372481,pescaquivirsl@gmail.com);
INSERT INTO PROVEEDOR (ID, NOMBRE, CODIGOPOSTAL, TELEFONO, EMAIL) VALUES (10,'Brisas del Estrecho',54379,697793829,estrechobrisa@gmail.com);

INSERT INTO PRODUCTO (ID, NOMBRE, DESCRIPCION, PRECIO, DESCUENTO, IMAGEN, CATEGORIA_ID, PROVEEDOR_ID) VALUES (11,'Merluza','La merluza es uno de los pescados que aceptan más preparaciones, desde las recetas más sencillas a las más sofisticadas.',10,0.1,'https://www.supermercadosmas.com/media/catalog/product/cache/d91bc430dbe2e3d899436802c7aa5233/i/m/import_catalog_images_33_11_331156_v9.jpg',2,7);
INSERT INTO PRODUCTO (ID, NOMBRE, DESCRIPCION, PRECIO, DESCUENTO, IMAGEN, CATEGORIA_ID, PROVEEDOR_ID) VALUES (12,'Merluza','La merluza es uno de los pescados que aceptan más preparaciones, desde las recetas más sencillas a las más sofisticadas.',10,0.1,'https://www.supermercadosmas.com/media/catalog/product/cache/d91bc430dbe2e3d899436802c7aa5233/i/m/import_catalog_images_33_11_331156_v9.jpg',2,7)