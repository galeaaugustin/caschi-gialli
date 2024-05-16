create database cascigialli;

CREATE TYPE match_type AS ENUM ('initial', 'accepted_by_customer', 'viewed');
CREATE TYPE offer_type AS ENUM ('discount', 'promotion', 'free','normal');

CREATE TABLE addresses (
    	address_id bigint GENERATED ALWAYS AS IDENTITY,
    	street VARCHAR(255),
	city VARCHAR(100),
    	state VARCHAR(100),
   	postal_code VARCHAR(20),
	longitudine VARCHAR(255),
	latitudine VARCHAR(255),
        created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT address_pkey PRIMARY KEY(address_id)
);

CREATE TABLE customers (
    	customer_id bigint GENERATED ALWAYS AS IDENTITY,
    	first_name VARCHAR(50),
    	last_name VARCHAR(50),
	user_name VARCHAR(255),
	pass  VARCHAR(255),
	active_token VARCHAR(255),
	customer_type VARCHAR(255),
    	email VARCHAR(255),
    	phone_number VARCHAR(20),
    	address_id bigint REFERENCES addresses(address_id),
	is_company VARCHAR(1),
        company_name VARCHAR(255),
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT customer_pkey PRIMARY KEY(customer_id)
);



CREATE TABLE orders (
    	order_id bigint GENERATED ALWAYS AS IDENTITY,
    	customer_id bigint REFERENCES customers(customer_id),
    	order_date DATE,
	order_type VARCHAR(255),
	order_name VARCHAR(255),
	order_description VARCHAR(500),
	min_offer DECIMAL(10, 2),
	max_offer DECIMAL(10, 2),
    	total_amount DECIMAL(10, 2),
	order_start_at TIMESTAMP,
	order_end_at TIMESTAMP,
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT order_pkey PRIMARY KEY(order_id)
);

CREATE TABLE order_items (
    	order_item_id bigint GENERATED ALWAYS AS IDENTITY,
    	order_id INTEGER REFERENCES orders(order_id),
	order_item_type VARCHAR(255),
	order_item_name VARCHAR(255),
	order_item_description VARCHAR(500),
	min_order_item_offer DECIMAL(10, 2),
	max_order_item_offer DECIMAL(10, 2),
    	quantity INTEGER,
    	price DECIMAL(10, 2),
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT order_item_pkey PRIMARY KEY(order_item_id)
);

CREATE TABLE suppliers (
    	supplier_id bigint GENERATED ALWAYS AS IDENTITY,
    	first_name VARCHAR(50),
    	last_name VARCHAR(50),
	user_name VARCHAR(255),
	pass  VARCHAR(255),
	active_token VARCHAR(255),
	supplier_type VARCHAR(255),
    	email VARCHAR(255),
    	phone_number VARCHAR(20),
	is_company VARCHAR(1),
        company_name VARCHAR(255),
    	address_id bigint REFERENCES addresses(address_id),
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT supplier_pkey PRIMARY KEY(supplier_id)
);



CREATE TABLE offer (
    	offer_id  bigint GENERATED ALWAYS AS IDENTITY,
    	supplier_id INTEGER REFERENCES suppliers(supplier_id),
	offer_start_at DATE,
    	offer_expiration DATE,
	offer_type offer_type,
	order_item_type  VARCHAR(255),
	offer_name VARCHAR(255),
	offer_description VARCHAR(500),
	min_offer DECIMAL(10, 2),
	max_offer DECIMAL(10, 2),
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT offer_pkey PRIMARY KEY(offer_id)
);



CREATE TABLE match_order_offer (
    	id  bigint GENERATED ALWAYS AS IDENTITY,
	customer_id bigint REFERENCES customers(customer_id),
    	supplier_id bigint REFERENCES suppliers(supplier_id),
	match_at DATE,
	order_item_type  VARCHAR(255),
	offer_name VARCHAR(255),
	offer_description VARCHAR(500),
	min_offer DECIMAL(10, 2),
	max_offer DECIMAL(10, 2),
	match_type match_type,
	created_by VARCHAR(255),
	created_on TIMESTAMP,
        updated_by VARCHAR(255),
        updated_on TIMESTAMP,
	CONSTRAINT match_order_offer_pkey PRIMARY KEY(id)
);

