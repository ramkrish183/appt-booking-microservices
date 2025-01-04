package com.rameshj.booking.domain;

public record DoctorAvailability(long doctorId, String firstName, String lastName, String specialist,int availableAppts) {
}
