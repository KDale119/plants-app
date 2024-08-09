package com.mccneb.edu.demo.model;

import java.util.List;

public class ExternalPlantApi {
    private List<ApiSpeciesResults> apiSpeciesResults;

    private List<ApiDetailsResults> apiDetailsResults;

    public List<ApiSpeciesResults> getApiSpeciesResults() {
        return apiSpeciesResults;
    }

    public void setApiSpeciesResults(List<ApiSpeciesResults> apiSpeciesResults) {
        this.apiSpeciesResults = apiSpeciesResults;
    }

    public List<ApiDetailsResults> getApiDetailsResults() {
        return apiDetailsResults;
    }

    public void setApiDetailsResults(List<ApiDetailsResults> apiDetailsResults) {
        this.apiDetailsResults = apiDetailsResults;
    }
}
