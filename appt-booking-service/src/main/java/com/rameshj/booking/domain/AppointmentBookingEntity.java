package com.rameshj.booking.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_booking")
public class AppointmentBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_booking_id_generator")
    @SequenceGenerator(name = "appointment_booking_id_generator", sequenceName = "appointment_booking_id_seq")
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name="checkin_time")
    private LocalDateTime checkinTime;

    @Column(name="checkout_time")
    private LocalDateTime checkoutTime;

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public LocalDateTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDateTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentBookingEntity(Long doctorId, LocalDateTime checkinTime, LocalDateTime checkoutTime) {
        this.doctorId = doctorId;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
    }

    public AppointmentBookingEntity() {
    }
}
