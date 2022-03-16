package com.wipro.CovidReports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CovidReportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidReportsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","covid-19-coronavirus-statistics.p.rapidapi.com");
        headers.add("x-rapidapi-key","854ff58740msh8c5ef61494b05acp141142jsnf7a383c5303b");
        return headers;
    }

}
