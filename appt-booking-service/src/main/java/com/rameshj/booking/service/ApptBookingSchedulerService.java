package com.rameshj.booking.service;

import com.rameshj.booking.domain.AppointmentBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class ApptBookingSchedulerService {

    private final AppointmentBookingRepository appointmentBookingRepository;

    public ApptBookingSchedulerService(AppointmentBookingRepository appointmentBookingRepository) {
        this.appointmentBookingRepository = appointmentBookingRepository;
    }

    public void updateCheckoutTime(){
        appointmentBookingRepository.updateCheckoutTime();
    }

    public void deleteOldAppointments(){
        appointmentBookingRepository.deleteOldAppointments();
    }
}
