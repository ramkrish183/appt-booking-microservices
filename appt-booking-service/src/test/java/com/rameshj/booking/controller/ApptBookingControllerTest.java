package com.rameshj.booking.controller;

import com.rameshj.booking.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class ApptBookingControllerTest extends AbstractIntegrationTest {

    @Nested
    class CreateAppointment{
        @Test
        public void shouldBookAppointment(){
            String payload = """
                    {
                        "doctorId":51,
                        "numberOfAppointments": 10
                    }
                    """;
            given().contentType(ContentType.JSON).body(payload).
                    when().post("/api/apptbooking/bookAppointment").then().statusCode(HttpStatus.CREATED.value());
        }

        @Test
        public void testWhenWrongDoctorIdGiven(){
            String payload = """
                    {
                        "doctorId":511,
                        "numberOfAppointments": 10
                    }
                    """;
            given().contentType(ContentType.JSON).body(payload).
                    when().post("/api/apptbooking/bookAppointment").then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }


}