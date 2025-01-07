package com.rameshj.booking.service;

import com.rameshj.booking.domain.AppointmentBookingEntity;
import com.rameshj.booking.domain.AppointmentBookingRepository;
import com.rameshj.booking.domain.Doctor;
import com.rameshj.booking.domain.DoctorAvailability;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
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
        int currentApptCount = currentAppointmentCount(doctorId);
        Optional<Doctor> optional=doctorCatalogServiceClient.getDoctorById(doctorId);
        if(optional.isPresent()){
            Doctor doctor=optional.get();
            return new DoctorAvailability(doctorId,doctor.firstName(),doctor.lastName(),doctor.specialist(),doctor.totalAppts()-currentApptCount);
        }
        else{
            return null;
        }
    }

    private int currentAppointmentCount(Long doctorId){
        return appointmentBookingRepository.currentAppointmentCount(doctorId);
    }

    public String bookAppointments(Long doctorId, int numberOfAppts){
        try {
            for(int i=1;i<=numberOfAppts;i++){
                appointmentBookingRepository.save(new AppointmentBookingEntity(doctorId, LocalDateTime.now(),null ));
            }
        }
        catch (Exception e){
            return "FAIL";
        }
        return "SUCCESS";
    }

    public List<AppointmentBookingEntity> getAllAppointments(Long doctorId){
        return appointmentBookingRepository.findAllByDoctorId(doctorId);
    }
}
