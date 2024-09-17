package com.mccneb.edu.demo.client;

import com.mccneb.edu.demo.config.ApiConfig;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.Quiz;
import com.mccneb.edu.demo.utils.SSLUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


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
        return restTemplate.getForObject(apiConfig.getHost() + apiConfig.getSpeciesDetail(), ApiDetailsResults.class, id, apiConfig.getApiKey());
    }

    public ApiSpeciesResults getSpecies(String q) {
        try {
            SSLUtils.turnOffSslChecking();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        return restTemplate.getForObject(apiConfig.getHost() + apiConfig.getSpecies(), ApiSpeciesResults.class, apiConfig.getApiKey(), q);
    }

    public ApiSpeciesResults queryForQuiz(Quiz quizResult) {
        String apiKey = apiConfig.getApiKey();
        try {
            SSLUtils.turnOffSslChecking();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        String sunlight = quizResult.getPlantSunlight().replace(" ", "_");
        String watering = quizResult.getPlantWatering().replace(" ", "_");
        String cycle = quizResult.getCycle().replace(" ", "_");

        Integer hardiness = quizResult.getHardiness();

        String poisonous = quizResult.getPoisonous() ? "1" : "0";
        String edible = quizResult.getEdible() ? "1": "0";
        String indoor = quizResult.getIndoor()? "1": "0";



        String apiUrl = "https://perenual.com/api/species-list?key=" + apiKey + "&sunlight=" + sunlight
                + "&watering=" + watering
                + "&poisonous=" + poisonous
                + "&edible=" + edible
                + "&cycle=" + cycle
                + "&indoor=" + indoor
                + "&hardiness=" + hardiness;

        System.out.println(apiUrl);
        return restTemplate.getForObject(apiUrl, ApiSpeciesResults.class);
    }
}
