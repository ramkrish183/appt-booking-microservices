package com.rameshj.booking.domain;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentBookingRepository extends JpaRepository<AppointmentBookingEntity,Long> {

    @Query("""
            select count(1) from AppointmentBookingEntity abe where abe.checkoutTime is null and abe.doctorId= :doctorId
            """)
    public int currentAppointmentCount(Long doctorId);

    public List<AppointmentBookingEntity> findAllByDoctorId(Long doctorId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE appointment_booking SET checkout_time = NOW() WHERE checkout_time is null and checkin_time < NOW() - INTERVAL '10 seconds'", nativeQuery = true)
    void updateCheckoutTime();

    @Modifying
    @Transactional
    @Query(value = "delete from appointment_booking where checkout_time < NOW() - INTERVAL '20 seconds'", nativeQuery = true)
    void deleteOldAppointments();

}
