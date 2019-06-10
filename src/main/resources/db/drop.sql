alter table if exists prom_item drop constraint if exists fk_prom_item_prom_order
drop table if exists prom_item cascade
drop table if exists prom_order cascade
