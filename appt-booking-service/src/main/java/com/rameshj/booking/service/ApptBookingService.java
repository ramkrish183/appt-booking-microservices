package com.rameshj.booking.service;

import com.rameshj.booking.domain.AppointmentBookingRepository;
import com.rameshj.booking.domain.Doctor;
import com.rameshj.booking.domain.DoctorAvailability;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApptBookingService {

    private final AppointmentBookingRepository appointmentBookingRepository;
    private final DoctorCatalogServiceClient doctorCatalogServiceClient;


    public ApptBookingService(AppointmentBookingRepository appointmentBookingRepository, DoctorCatalogServiceClient doctorCatalogServiceClient) {
        this.appointmentBookingRepository = appointmentBookingRepository;
        this.doctorCatalogServiceClient = doctorCatalogServiceClient;
    }

    public DoctorAvailability getDoctor(long doctorId){
        Optional<Doctor> optional=doctorCatalogServiceClient.getDoctorById(doctorId);
        if(optional.isPresent()){
            Doctor doctor=optional.get();
            return new DoctorAvailability(doctorId,doctor.firstName(),doctor.lastName(),doctor.specialist(),doctor.totalAppts());
        }
        else{
            return null;
        }

    }
}
