SELECT * FROM registers;
SELECT * FROM orderlist;
SELECT * FROM products;
SELECT * FROM ADDRESSES;



SELECT register_name FROM registers WHERE register_name = '홍길동' AND phone_number = '010-1111-1111';

SELECT o.orderlist_id, o.orderlist_date, p.product_name, orderlist_quantity, p.product_price, orderlist_price, orderlist_payment FROM orderlist o, products p, registers r WHERE r.register_id = o.register_id AND o.product_id = p.product_id AND r.register_id = 'gildong1';

UPDATE products SET stock = stock - 3 WHERE product_id = 1;
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, register_id, product_id)
VALUES (orderlist_id_seq.nextval, sysdate, 3, 3 * (SELECT product_price FROM products WHERE product_id = 1), '카카오페이', 'gildong1', 1);


ROLLBACK;

