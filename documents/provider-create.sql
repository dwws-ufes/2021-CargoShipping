create table cargo.Cargo (tracking_id varchar(63) not null, origin_unlocode varchar(255) not null, specification_arrival_deadline timestamp not null, specification_destination_unlocode varchar(255) not null, specification_origin_unlocode varchar(255) not null, version timestamp not null, primary key (tracking_id))
create table cargo.HandlingEvent (id int8 not null, completion_time timestamp not null, unlocode varchar(255) not null, type varchar(255) not null, version timestamp not null, voyage_number varchar(255), tracking_id varchar(63) not null, primary key (id))
create table cargo.Itinerary (tracking_id varchar(63) not null, load_unlocode varchar(255) not null, load_time timestamp not null, unload_unlocode varchar(255) not null, unload_time timestamp not null, voyage_number varchar(255) not null)
create sequence handlingEventSeq start 1 increment 1
alter table if exists cargo.HandlingEvent add constraint FKajfr1joyu8ctafvwc3t6t0vgt foreign key (tracking_id) references cargo.Cargo
alter table if exists cargo.Itinerary add constraint FK5wrurusgh26w7oytevnjpb1vg foreign key (tracking_id) references cargo.Cargo
