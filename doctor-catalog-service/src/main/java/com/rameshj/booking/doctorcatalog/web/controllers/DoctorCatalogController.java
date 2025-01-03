package com.rameshj.booking.doctorcatalog.web.controllers;

import com.rameshj.booking.doctorcatalog.domain.Doctor;
import com.rameshj.booking.doctorcatalog.service.DoctorCatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorCatalogController {

    private final DoctorCatalogService doctorCatalogService;

    public DoctorCatalogController(DoctorCatalogService doctorCatalogService) {
        this.doctorCatalogService = doctorCatalogService;
    }


    @GetMapping
    public List<Doctor> getDoctors(){
        return doctorCatalogService.getDoctors();
    }

}
