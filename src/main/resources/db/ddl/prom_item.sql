-- TODO add set schema 'my_schema' to all of the sql scripts
CREATE TABLE prom_item (
  ID varchar(255) NOT NULL,
  CURRENCY varchar(255),
  EXTERNAL_ID varchar(255),
  IMAGE varchar(255),
  ITEM_ID varchar(255),
  NAME varchar(255),
  PRICE varchar(255),
  QUANTITY varchar(255),
  SKU varchar(255),
  URL varchar(255),
  PROM_ORDER_ID varchar(255),
  PRIMARY KEY (id)
);

ALTER TABLE prom_item ADD CONSTRAINT fk_prom_item_prom_order FOREIGN KEY (prom_order_id) REFERENCES prom_order(id);
