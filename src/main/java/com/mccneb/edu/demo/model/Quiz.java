package com.mccneb.edu.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Quiz")
public class Quiz {

    @Id
    @Column(name = "quizid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizId;

    @Column(name = "username")
    private String userName;

    @Column(name = "quizresults", length= 10000)
    private String quizResults;
//    store apiId's instead as strings'

    @Column(name = "apiid")
    private Integer apiId;


    @Column(name = "plantsunlight")
    private String plantSunlight;
//    part sun
//    part shade
//    full shade
//    full sun

    @Column(name = "plantwatering")
    private String plantWatering;
//    Average
//    Frequent
//    Minimum

    @Column(name = "edible")
    private Boolean edible;

    @Column(name = "poisonous")
    private Boolean poisonous;

    @Column(name = "cycle")
    private String cycle;

    @Column(name = "hardiness")
    private Integer hardiness;

    @Column(name = "indoor")
    private Boolean indoor;

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuizResults() {
        return quizResults;
    }

    public void setQuizResults(String quizResults) {
        this.quizResults = quizResults;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getPlantSunlight() {
        return plantSunlight;
    }

    public void setPlantSunlight(String plantSunlight) {
        this.plantSunlight = plantSunlight;
    }

    public String getPlantWatering() {
        return plantWatering;
    }

    public void setPlantWatering(String plantWatering) {
        this.plantWatering = plantWatering;
    }

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
    }

    public Boolean getPoisonous() {
        return poisonous;
    }

    public void setPoisonous(Boolean poisonous) {
        this.poisonous = poisonous;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getHardiness() {
        return hardiness;
    }

    public void setHardiness(Integer hardiness) {
        this.hardiness = hardiness;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }


}
