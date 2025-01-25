package com.rameshj.booking.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(
        properties = {
                "spring.test.database.replace=none",
                "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///db",
        })
@Sql("/test-data-insert.sql")
class AppointmentBookingRepositoryTest {

    @Autowired
    AppointmentBookingRepository appointmentBookingRepository;

    @Test
    void testForExistingData(){
        List<AppointmentBookingEntity> allByDoctorId = appointmentBookingRepository.findAllByDoctorId(51l);
        assertThat(allByDoctorId).hasSize(1);
        assertThat(allByDoctorId).doesNotContainNull().hasSize(1);
        assertThat(allByDoctorId).extracting("doctorId").contains(51L);
    }

    @Test
    void testForCurrentAppointment(){
        int totalAppt = appointmentBookingRepository.currentAppointmentCount(51L);
        assertThat(totalAppt).isPositive();
        assertThat(totalAppt).isEqualTo(1);
    }
    @Test
    void testForNotValidData(){
        List<AppointmentBookingEntity> allByDoctorId = appointmentBookingRepository.findAllByDoctorId(511l);
        assertThat(allByDoctorId).hasSize(0);

    }
}