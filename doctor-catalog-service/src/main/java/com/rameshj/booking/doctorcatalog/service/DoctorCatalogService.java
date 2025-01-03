package com.rameshj.booking.doctorcatalog.service;

import com.rameshj.booking.doctorcatalog.domain.Doctor;
import com.rameshj.booking.doctorcatalog.domain.DoctorMapper;
import com.rameshj.booking.doctorcatalog.domain.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorCatalogService {

    private final DoctorRepository doctorRepository;

    public DoctorCatalogService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> getDoctors(){
        return doctorRepository.findAll().stream().map(DoctorMapper::toDoctor).toList();

    }
}
