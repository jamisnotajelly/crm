ALTER TABLE prom_item ADD CONSTRAINT fk_prom_item_prom_order FOREIGN KEY (prom_order_id) REFERENCES prom_order(id);
