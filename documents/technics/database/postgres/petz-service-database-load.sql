/* ACCOUNT SERVICE DATABASE LOAD */

DROP ROLE IF EXISTS petz;
CREATE ROLE petz LOGIN ENCRYPTED PASSWORD 'petz' SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;
DROP DATABASE IF EXISTS petz;
CREATE DATABASE petz WITH OWNER = petz ENCODING = 'UTF8' TABLESPACE = pg_default LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8' CONNECTION LIMIT = -1;
\connect petz;

--CREATE SCHEMA CORE
DROP SCHEMA IF EXISTS petz_service_schema CASCADE;
CREATE SCHEMA petz_service_schema AUTHORIZATION petz;
GRANT ALL ON SCHEMA petz_service_schema TO petz;
COMMENT ON SCHEMA petz_service_schema IS 'Defines the database structure of the application';

--CREATE SEQUENCE CORE
DROP SEQUENCE IF EXISTS petz_service_schema.CUSTOMERS_IDCUSTOMER_SEQ;
CREATE SEQUENCE petz_service_schema.CUSTOMERS_IDCUSTOMER_SEQ INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

DROP SEQUENCE IF EXISTS petz_service_schema.PETS_IDPET_SEQ;
CREATE SEQUENCE petz_service_schema.PETS_IDPET_SEQ INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;


--CREATE TABLES PETZ SERVICE
CREATE TABLE petz_service_schema.Customers (
  idCustomer INTEGER NOT NULL DEFAULT NEXTVAL('petz_service_schema.CUSTOMERS_IDCUSTOMER_SEQ'),
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
ALTER TABLE petz_service_schema.Customers ADD CONSTRAINT PKEY_BY_IDCUSTOMER PRIMARY KEY(idCustomer);

CREATE TABLE petz_service_schema.Pets (
  idPet INTEGER NOT NULL DEFAULT NEXTVAL('petz_service_schema.PETS_IDPET_SEQ'),
  idCustomer INTEGER NOT NULL,
  name VARCHAR(250) NOT NULL,
  age INTEGER NOT NULL
);
ALTER TABLE petz_service_schema.Pets ADD CONSTRAINT PKEY_BY_IDPET PRIMARY KEY(idPet);
ALTER TABLE petz_service_schema.Pets ADD CONSTRAINT FK_CUSTOMER_PET FOREIGN KEY(idCustomer) REFERENCES petz_service_schema.Customers(idCustomer) ON DELETE NO ACTION ON UPDATE NO ACTION;

--SELECT TEST PETZ SERVICE DATABASE
SELECT * FROM petz_service_schema.Customers;
SELECT * FROM petz_service_schema.Pets;
