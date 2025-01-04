package com.rameshj.booking.doctorcatalog.domain;

public record Doctor(long id, String firstName, String lastName, String specialist, int totalAppts) {
}
