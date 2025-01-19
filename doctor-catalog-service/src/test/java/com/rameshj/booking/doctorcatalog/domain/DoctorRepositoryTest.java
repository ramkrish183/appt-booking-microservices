package com.rameshj.booking.doctorcatalog.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(
        properties = {
                "spring.test.database.replace=none",
                "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///db",
        })
@Sql("/test-data.sql")
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void shouldGetAllDoctors(){
        List<DoctorEntity> doctors = doctorRepository.findAll();
        assertThat(doctors).hasSize(4);

    }



}