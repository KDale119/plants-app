package com.mccneb.edu.demo.client;

import com.mccneb.edu.demo.config.ApiConfig;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.ExternalPlantApi;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PlantClient {

    private final ApiConfig apiConfig;
    private final RestTemplate restTemplate;

    public PlantClient(ApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public ApiDetailsResults getDetails(String q){
        ExternalPlantApi response = restTemplate.getForObject(apiConfig.getHost() + apiConfig.getPath(), ExternalPlantApi.class, q, apiConfig.getApiKey());
        return response.getApiDetailsResults().stream().findFirst().get();
    }

    public ApiSpeciesResults getSpecies(String q){
        ExternalPlantApi response = restTemplate.getForObject(apiConfig.getHost() + apiConfig.getPath(), ExternalPlantApi.class, q, apiConfig.getApiKey());
        return response.getApiSpeciesResults().stream().findFirst().get();
    }
}
