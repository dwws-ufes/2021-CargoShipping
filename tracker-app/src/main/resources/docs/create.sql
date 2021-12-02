
create table cargo.Cargo (
    tracking_id varchar(255) not null, 
    origin_unlocode varchar(255) not null, 
    specification_origin_unlocode varchar(255) not null, 
    specification_destination_unlocode varchar(255) not null, 
    specification_arrival_deadline timestamp not null, 
    version timestamp not null, 
    primary key (tracking_id)
);

create table cargo.Itinerary (
    tracking_id varchar(255) not null, 
    load_unlocode varchar(255) not null, 
    load_time timestamp not null, 
    unload_unlocode varchar(255) not null, 
    unload_time timestamp not null, 
    voyage_number varchar(255) not null
);

alter table cargo.Itinerary add constraint FK_Itinerary_Cargo foreign key (tracking_id) references cargo.Cargo;
