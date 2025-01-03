package com.rameshj.booking.doctorcatalog.domain;

public class DoctorMapper {

    public static Doctor toDoctor(DoctorEntity doctorEntity){
        return new Doctor(doctorEntity.getFirstName(),doctorEntity.getLastName(),doctorEntity.getSpecialist(),doctorEntity.getTotalAppts());
    }
}
