package com.rameshj.booking.doctorcatalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {

     Optional<DoctorEntity> findById(long id);
}
