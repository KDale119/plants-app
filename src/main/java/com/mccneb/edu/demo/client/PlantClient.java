package com.mccneb.edu.demo.client;

import com.mccneb.edu.demo.config.ApiConfig;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.utils.SSLUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@Component
public class PlantClient {

    private final ApiConfig apiConfig;
    private final RestTemplate restTemplate;

    public PlantClient(ApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public ApiDetailsResults getDetails(Integer id) {
        try {
            SSLUtils.turnOffSslChecking();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        ApiDetailsResults response = restTemplate.getForObject(apiConfig.getHost() + apiConfig.getSpeciesDetail(), ApiDetailsResults.class, id, apiConfig.getApiKey());
        return response;
    }

    public ApiSpeciesResults getSpecies(String q) {
        try {
            SSLUtils.turnOffSslChecking();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        ApiSpeciesResults response = restTemplate.getForObject(apiConfig.getHost() + apiConfig.getSpecies(), ApiSpeciesResults.class, q, apiConfig.getApiKey());
            return response;

    }
}
