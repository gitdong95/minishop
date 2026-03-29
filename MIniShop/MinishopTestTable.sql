/* 회원전용_구매내역 */
CREATE TABLE orderlist (
	orderlist_id number(10) NOT NULL, /* 구매내역_일련번호 */
	orderlist_date date NOT NULL, /* 구매날짜 */
	orderlist_quantity number(10) NOT NULL, /* 구매수량 */
	orderlist_price number(10) NOT NULL, /* 구매가격 */
	orderlist_payment varchar2(20) NOT NULL, /* 결제수단 */
	register_id varchar2(20) NOT NULL, /* 회원_id */
	product_id number(10) NOT NULL /* 상품_id */
);

CREATE UNIQUE INDEX PK_orderlist
	ON orderlist (
		orderlist_id ASC
	);

ALTER TABLE orderlist
	ADD
		CONSTRAINT PK_orderlist
		PRIMARY KEY (
			orderlist_id
		);

/* 회원정보 */
CREATE TABLE registers (
	register_id varchar2(20) NOT NULL, /* 회원_id */
	register_name varchar2(30) NOT NULL, /* 이름 */
	password varchar2(50) NOT NULL, /* 비밀번호 */
	email varchar2(50), /* 이메일 */
	phone_number varchar2(20) NOT NULL /* 전화번호 */
);

CREATE UNIQUE INDEX PK_registers
	ON registers (
		register_id ASC
	);

ALTER TABLE registers
	ADD
		CONSTRAINT PK_registers
		PRIMARY KEY (
			register_id
		);

/* 상품정보 */
CREATE TABLE products (
	product_id number(10) NOT NULL, /* 상품_id */
	product_name varchar2(30) NOT NULL, /* 상품명 */
	product_price number(10) NOT NULL, /* 상품가격 */
	stock number(10) /* 재고수량 */
);

CREATE UNIQUE INDEX PK_products
	ON products (
		product_id ASC
	);

ALTER TABLE products
	ADD
		CONSTRAINT PK_products
		PRIMARY KEY (
			product_id
		);

ALTER TABLE orderlist
	ADD
		CONSTRAINT FK_registers_TO_orderlist
		FOREIGN KEY (
			register_id
		)
		REFERENCES registers (
			register_id
		);

ALTER TABLE orderlist
	ADD
		CONSTRAINT FK_products_TO_orderlist
		FOREIGN KEY (
			product_id
		)
		REFERENCES products (
			product_id
		);