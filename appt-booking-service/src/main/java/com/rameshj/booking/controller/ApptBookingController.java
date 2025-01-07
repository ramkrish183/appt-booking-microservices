package com.rameshj.booking.controller;

import com.rameshj.booking.domain.AppointmentBookingEntity;
import com.rameshj.booking.domain.BookingRequest;
import com.rameshj.booking.domain.Doctor;
import com.rameshj.booking.domain.DoctorAvailability;
import com.rameshj.booking.service.ApptBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apptbooking")
public class ApptBookingController {
    private final ApptBookingService apptBookingService;


    public ApptBookingController(ApptBookingService apptBookingService) {
        this.apptBookingService = apptBookingService;
    }

    @GetMapping("/doctor/{doctorId}")
    public DoctorAvailability getDoctor(@PathVariable (name = "doctorId") Long doctorId){
        return apptBookingService.getDoctor(doctorId);
    }

    @PostMapping("/bookAppointment")
    public String bookAppointment(@RequestBody BookingRequest bookingRequest){
        return apptBookingService.bookAppointments(bookingRequest.doctorId(),bookingRequest.numberOfAppointments());
    }

    @GetMapping("/appointments/doctor/{doctorId}")
    public List<AppointmentBookingEntity> getAllAppointments(@PathVariable(name = "doctorId") Long doctorId){
        return apptBookingService.getAllAppointments(doctorId);
    }

}
