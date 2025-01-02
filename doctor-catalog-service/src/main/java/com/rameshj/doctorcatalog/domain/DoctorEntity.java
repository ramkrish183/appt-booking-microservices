package com.rameshj.doctorcatalog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name="doctor_catalog")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_catalog_id_generator")
    @SequenceGenerator(name = "doctor_catalog_id_generator", sequenceName = "doctor_catalog_id_seq")
    private Long id;

    @NotEmpty(message = "First name is required")
    @Column(nullable = false,name = "first_name")
    private String firstName;

    @Column(nullable = false,name="last_name")
    private String lastName;

    @NotEmpty(message = "specialist name is required")
    @Column(nullable = false,name = "specialist")
    private String specialist;

    @NotNull(message = "Total Appointments is required") @DecimalMin("1")
    @Column(nullable = false,name="totalAppts")
    private int totalAppts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public int getTotalAppts() {
        return totalAppts;
    }

    public void setTotalAppts(int totalAppts) {
        this.totalAppts = totalAppts;
    }
}
