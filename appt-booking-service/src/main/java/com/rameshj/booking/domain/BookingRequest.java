package com.rameshj.booking.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookingRequest(@NotNull  Long doctorId, int numberOfAppointments) {
}
