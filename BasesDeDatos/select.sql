SELECT
    nombre,
    birthday
FROM
    trabajadores;

-------------------------------------------
SELECT
    birthday AS cumpleaños,
    nombre,
    (id + 1) AS ID
FROM
    trabajadores;

-------------------------------------------
SELECT
    *
FROM
    trabajadores
WHERE
    birthday = "2000-10-25"
    AND nombre LIKE "%&%";

-------------------------------------------
SELECT
    *
FROM
    trabajadores
WHERE
    (
        birthday = "2000-10-25"
        AND nombre LIKE "%&%"
    )
    OR ID = 2;

-------------------------------------------
--Sesión join------------------------------

SELECT nombre,fecha_registro FROM clientes;

SELECT nombre FROM clientes WHERE fecha_registro BETWEEN '2023-01-01' AND '2023-01-31';

SELECT nombre FROM clientes WHERE MONTH(fecha_registro)=1;
SELECT nombre FROM clientes WHERE YEAR(fecha_registro)=2023;
SELECT nombre FROM clientes WHERE DAY(fecha_registro)=14;

SELECT nombre FROM clientes WHERE MONTH(fecha_registro) BETWEEN 6 AND 8;


SELECT nombre FROM clientes WHERE (MONTH(fecha_registro) >= 6 AND DAY(fecha_registro) >= 15) AND (MONTH(fecha_registro) <= 8 AND DAY(fecha_registro) <= 15);

SELECT * FROM clientes ORDER BY fecha_registro DESC;

SELECT nombre FROM clientes ORDER BY fecha_registro DESC LIMIT 5;

SELECT round(precio) FROM productos;

SELECT round(precio, 2) FROM productos;

SELECT nombre_producto FROM productos WHERE precio > 100;

SELECT * FROM ventas WHERE id_cliente = 1 GROUP BY id_cliente;

SELECT id_cliente,AVG(cantidad) AS media,((max(cantidad)+min(cantidad))/2) AS mediana FROM ventas group by id_cliente;

--Mostrar los meses con más de dos ventas--
SELECT MONTHNAME(fecha_venta) mes, count(id_venta) ventas FROM ventas GROUP BY MONTH(fecha_venta) HAVING ventas > 2;
--Mostrar los clientes que han comprado en un mes más de una vez--
SELECT id_cliente,MONTHNAME(fecha_venta) mes,count(id_venta) compras FROM ventas GROUP BY id_cliente,MONTH(fecha_venta) HAVING compras > 1;
--Mostrar los clientes que han comprado en un mes una cantidad total de productos mayor a 8--
SELECT id_cliente,MONTHNAME(fecha_venta) mes,count(id_venta) compras,sum(cantidad) productos FROM ventas GROUP BY id_cliente,MONTH(fecha_venta) HAVING productos > 8;