package com.rameshj.booking.domain;

import jakarta.persistence.*;

import java.sql.Date;

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
    private Date checkinTime;

    @Column(name="checkout_time")
    private Date checkoutTime;

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
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
}
