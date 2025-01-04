package com.rameshj.booking.controller;

import com.rameshj.booking.domain.Doctor;
import com.rameshj.booking.domain.DoctorAvailability;
import com.rameshj.booking.service.ApptBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
