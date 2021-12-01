
create table voyage.Voyage (
    voyage_number varchar(255) not null, 
    version timestamp not null, 
    primary key (voyage_number)
);

create table voyage.Schedule (
    voyage_number varchar(255) not null, 
    arrival_unlocode varchar(255) not null, 
    arrival_time timestamp not null, 
    departure_unlocode varchar(255) not null, 
    departure_time timestamp not null
);

alter table voyage.Schedule add constraint FK_Schedule_Voyage foreign key (voyage_number) references voyage.Voyage;

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
alter table cargo.Itinerary add constraint FK_Itinerary_Voyage foreign key (voyage_number) references voyage.Voyage;
