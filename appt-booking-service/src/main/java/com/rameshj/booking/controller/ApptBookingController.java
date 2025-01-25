package com.rameshj.booking.controller;

import com.rameshj.booking.domain.AppointmentBookingEntity;
import com.rameshj.booking.domain.BookingRequest;
import com.rameshj.booking.domain.Doctor;
import com.rameshj.booking.domain.DoctorAvailability;
import com.rameshj.booking.service.ApptBookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apptbooking")
public class ApptBookingController {
    private static final Logger log = LoggerFactory.getLogger(ApptBookingController.class);
    private final ApptBookingService apptBookingService;


    public ApptBookingController(ApptBookingService apptBookingService) {
        this.apptBookingService = apptBookingService;
    }

    @GetMapping("/doctor/{doctorId}")
    public DoctorAvailability getDoctor(@PathVariable (name = "doctorId") Long doctorId){
        log.info("get doctor ");
        return apptBookingService.getDoctor(doctorId);
    }


    @PostMapping("/bookAppointment")
    @ResponseStatus(HttpStatus.CREATED)
    public String bookAppointment(@Valid @RequestBody BookingRequest bookingRequest) throws Exception {
        log.info("Booking Appointment");
        return apptBookingService.bookAppointments(bookingRequest.doctorId(),bookingRequest.numberOfAppointments());
    }

    @GetMapping("/appointments/doctor/{doctorId}")
    public List<AppointmentBookingEntity> getAllAppointments(@PathVariable(name = "doctorId") Long doctorId){
        return apptBookingService.getAllAppointments(doctorId);
    }

}
