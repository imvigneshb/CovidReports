package com.wipro.CovidReports.controller;

import com.wipro.CovidReports.model.Covid19Stats;
import com.wipro.CovidReports.model.CovidData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ReportsController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpHeaders headers;

    @GetMapping("/get-all-countries")
    public CovidData getAllCountries() {
        ResponseEntity<CovidData> data = restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=All", HttpMethod.GET, new HttpEntity<>(headers), CovidData.class);
        return data.getBody();
    }

    @GetMapping("/get-usa")
    public CovidData getUsa() {
        ResponseEntity<CovidData> data = restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=US", HttpMethod.GET, new HttpEntity<>(headers), CovidData.class);
        return data.getBody();
    }

    @GetMapping("/get-usa-with-limit/{page}/{size}")
    public List<Covid19Stats> getUsa(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        ResponseEntity<CovidData> data = restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=US", HttpMethod.GET, new HttpEntity<>(headers), CovidData.class);
        int start = page * size;
        int end = (int) ((start + size) > data.getBody().getData().getCovid19Stats().size() ? data.getBody().getData().getCovid19Stats().size()
                : (start + size));

        return data.getBody().getData().getCovid19Stats().subList(start, end);
    }
}
