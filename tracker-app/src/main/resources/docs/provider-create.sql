create table cargo.Cargo (tracking_id varchar(255) not null, origin_unlocode varchar(255) not null, specification_arrival_deadline timestamp not null, specification_destination_unlocode varchar(255) not null, specification_origin_unlocode varchar(255) not null, version timestamp not null, primary key (tracking_id))
create table cargo.Itinerary (tracking_id varchar(255) not null, load_unlocode varchar(255) not null, load_time timestamp not null, unload_unlocode varchar(255) not null, unload_time timestamp not null, voyage_number varchar(255) not null)
create table voyage.Schedule (voyage_number varchar(255) not null, arrival_unlocode varchar(255) not null, arrival_time timestamp not null, departure_unlocode varchar(255) not null, departure_time timestamp not null)
create table voyage.Voyage (voyage_number varchar(255) not null, version timestamp not null, primary key (voyage_number))
alter table cargo.Itinerary add constraint FK72gly8gmvhuo0gm6st29rv5p7 foreign key (voyage_number) references voyage.Voyage
alter table cargo.Itinerary add constraint FK5wrurusgh26w7oytevnjpb1vg foreign key (tracking_id) references cargo.Cargo
alter table voyage.Schedule add constraint FK5on4g1hfe0pnfu3tm8q047qwp foreign key (voyage_number) references voyage.Voyage
