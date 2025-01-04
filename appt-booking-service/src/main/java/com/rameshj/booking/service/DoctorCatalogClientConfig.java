package com.rameshj.booking.service;

import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Configuration
public class DoctorCatalogClientConfig {

    @Bean
    RestClient restClient(RestClient.Builder builder){
        return builder.baseUrl("http://localhost:8081/")
                .build();
    }
}
