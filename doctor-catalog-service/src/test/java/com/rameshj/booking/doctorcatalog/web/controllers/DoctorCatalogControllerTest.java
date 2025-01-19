package com.rameshj.booking.doctorcatalog.web.controllers;

import com.rameshj.booking.doctorcatalog.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@Sql("/test-data.sql")
public class DoctorCatalogControllerTest extends AbstractIntegrationTest {

    @Test
    public void shouldReturnDoctors(){
        given().contentType(ContentType.JSON).when().get("/api/doctors").then().statusCode(200).body("data",hasSize(4));
    }

    @Test
    public void shouldReturnDoctor(){
        given().contentType(ContentType.JSON).when().get("/api/doctors/1").then().statusCode(200);
    }

}