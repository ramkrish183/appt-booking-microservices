package com.rameshj.booking.service;


import com.rameshj.booking.domain.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class DoctorCatalogServiceClient {

    private final static String CATALOG_SERVICE_URL="http://localhost:8081/api/doctors";

    private final RestClient restClient;

    public DoctorCatalogServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Optional<Doctor> getDoctorById(Long doctorId){
        var doctor= restClient.get().uri("/api/doctors/{doctorId}",doctorId).retrieve().body(Doctor.class);
        return Optional.ofNullable(doctor);
    }

}
