create sequence doctor_catalog_id_seq start with 1 increment by 50;

create table doctor_catalog
(
    id bigint default nextval('doctor_catalog_id_seq') not null,
    first_name        text not null,
    last_name        text,
    specialist text,
    totalAppts   bigint,
    primary key (id)
);