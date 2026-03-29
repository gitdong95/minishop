-- 1. 시퀀스 생성
CREATE SEQUENCE seq_product_id START WITH 1;
CREATE SEQUENCE seq_address_id START WITH 1;
CREATE SEQUENCE seq_orderlist_id START WITH 1;

-- 2. 회원 정보
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('chulsoo77', '김철수', 'chul1234!', 'chulsoo77@naver.com', '010-4562-1289');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('younghee02', '이영희', 'young8899#', 'younghee02@gmail.com', '010-9871-2354');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('minsoo91', '박민수', 'minsoo@91', 'minsoo91@kakao.com', '010-3342-7781');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('jiwoostar', '최지우', 'star778899', 'jiwoostar@naver.com', '010-5561-0023');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('daeunp', '정다은', 'daeun1004', 'daeunp@gmail.com', '010-2234-5567');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('hyeonwoo1', '강현우', 'hyeonw00!', 'hyeonwoo1@kakao.com', '010-8890-1234');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('seojuny', '윤서준', 'yoon_sj22', 'seojuny@gmail.com', '010-7123-4456');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('naraelim', '임나래', 'narae9900', 'naraelim@naver.com', '010-4451-9980');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('jaehyunh', '한재현', 'jaehyun7!@', 'jaehyunh@kakao.com', '010-6671-3321');
INSERT INTO registers (register_id, register_name, password, email, phone_number) 
VALUES ('kcs8899', '김철수', 'kcs8899!!', 'kcs8899@gmail.com', '010-1233-8871');

-- 3. 상품 정보
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '사과',   12800, 30);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '우유',    2980, 50);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '신라면',  4100, 100);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '삼겹살', 15600, 20);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '감귤',    9900, 45);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '햇반',   14500, 60);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '콜라',    2800, 80);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '대파',    3500, 25);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '화장지', 27900, 15);
INSERT INTO products (product_id, product_name, product_price, stock) VALUES (seq_product_id.NEXTVAL, '진라면',   750, 200);

-- 4. 배송지 주소
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '서울시강남구역삼로12',      'chulsoo77');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '경기도성남시분당로45',      'younghee02');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '부산시해운대구마린시티3',   'minsoo91');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '대구시수성구범어로7',       'jiwoostar');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '인천시연수구송도과학로11',  'daeunp');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '광주시남구봉선로88',        'hyeonwoo1');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '대전시유성구대학로99',      'seojuny');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '울산시남구번영로10',        'naraelim');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '세종시한누리대로201',       'jaehyunh');
INSERT INTO addresses (address_id, address, register_id) VALUES (seq_address_id.NEXTVAL, '제주시노형로55',            'kcs8899');

-- 5. 구매내역
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-10, 2, 25600, '카드결제',  1,  1, 'chulsoo77');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-8,  3,  8940, '네이버페이', 2,  2, 'younghee02');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-7,  2,  8200, '카카오페이', 3,  3, 'minsoo91');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-6,  1, 15600, '카드결제',  4,  4, 'jiwoostar');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-5,  1,  9900, '네이버페이', 5,  5, 'daeunp');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-4,  1, 14500, '카카오페이', 6,  6, 'hyeonwoo1');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-3,  5, 14000, '카드결제',  7,  7, 'seojuny');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-2,  2,  7000, '네이버페이', 8,  8, 'naraelim');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-1,  1, 27900, '카카오페이', 9,  9, 'jaehyunh');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE,   10,  7500, '카드결제', 10, 10, 'kcs8899');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-9,  1, 12800, '카카오페이', 1,  2, 'younghee02');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-9,  2,  5960, '카드결제',  2,  3, 'minsoo91');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-8,  1,  4100, '네이버페이', 3,  1, 'chulsoo77');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-7,  1,  2980, '카드결제',  2,  4, 'jiwoostar');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-7,  3, 38400, '카카오페이', 1,  5, 'daeunp');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-6,  2,  5600, '네이버페이', 7,  6, 'hyeonwoo1');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-5,  2, 31200, '카드결제',  4,  7, 'seojuny');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-4,  1, 14500, '네이버페이', 6,  8, 'naraelim');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-3,  4, 11920, '카카오페이', 2, 10, 'kcs8899');
INSERT INTO orderlist (orderlist_id, orderlist_date, orderlist_quantity, orderlist_price, orderlist_payment, product_id, address_id, register_id) 
VALUES (seq_orderlist_id.NEXTVAL, SYSDATE-2,  5, 20500, '카드결제',  3,  9, 'jaehyunh');