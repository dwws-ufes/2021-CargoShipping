
create table cargo.Cargo (
    tracking_id varchar(63) not null, 
    origin_unlocode varchar(255) not null, 
    specification_origin_unlocode varchar(255) not null, 
    specification_destination_unlocode varchar(255) not null, 
    specification_arrival_deadline timestamp not null, 
    version timestamp not null, 
    primary key (tracking_id)
);

create table cargo.Itinerary (
    tracking_id varchar(63) not null, 
    load_unlocode varchar(255) not null, 
    load_time timestamp not null, 
    unload_unlocode varchar(255) not null, 
    unload_time timestamp not null, 
    voyage_number varchar(255) not null
);

alter table cargo.Itinerary add constraint FK_Itinerary_Cargo foreign key (tracking_id) references cargo.Cargo;

create sequence handlingEventSeq start 1 increment 1;

create table cargo.HandlingEvent (
    id int8 not null, 
    type varchar(255) not null, 
    tracking_id varchar(63) not null, 
    unlocode varchar(255) not null, 
    completion_time timestamp not null, 
    voyage_number varchar(255), 
    version timestamp not null, 
    primary key (id)
);

alter table cargo.HandlingEvent add constraint FK_HandlingEvent_Cargo foreign key (tracking_id) references cargo.Cargo;

--------------------------------------------------------------------------------
--- POSTGRES PERMISSIONS

-- GRANT CONNECT ON DATABASE "cargo-shipping" TO "APP";
ALTER DEFAULT PRIVILEGES GRANT ALL ON TABLES TO "APP";
ALTER DEFAULT PRIVILEGES GRANT ALL ON SEQUENCES TO "APP";
ALTER DEFAULT PRIVILEGES GRANT EXECUTE ON FUNCTIONS TO "APP";
ALTER DEFAULT PRIVILEGES GRANT USAGE ON TYPES TO "APP";

GRANT USAGE ON SCHEMA public TO "APP";
GRANT USAGE ON SCHEMA cargo TO "APP";
