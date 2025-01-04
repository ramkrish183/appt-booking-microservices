create sequence  appointment_booking_id_seq start with 1 increment by 50;

create table  appointment_booking
(
    id bigint default nextval('appointment_booking_id_seq') not null,
    doctor_id bigint not null,
    checkin_time timestamp  not null,
    checkout_time timestamp default null,
    primary key (id)
);
