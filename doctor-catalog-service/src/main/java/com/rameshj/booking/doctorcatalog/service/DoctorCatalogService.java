package com.rameshj.booking.doctorcatalog.service;

import com.rameshj.booking.doctorcatalog.domain.Doctor;
import com.rameshj.booking.doctorcatalog.domain.DoctorEntity;
import com.rameshj.booking.doctorcatalog.domain.DoctorMapper;
import com.rameshj.booking.doctorcatalog.domain.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorCatalogService {

    private final DoctorRepository doctorRepository;

    public DoctorCatalogService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> getDoctors(){
        return doctorRepository.findAll().stream().map(DoctorMapper::toDoctor).toList();
    }

    public Doctor getDoctor(long doctorId){

        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(doctorId);
        return optionalDoctorEntity.map(DoctorMapper::toDoctor).orElse(null);
    }
}
