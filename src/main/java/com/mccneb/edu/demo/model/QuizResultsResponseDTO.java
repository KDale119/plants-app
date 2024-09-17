package com.mccneb.edu.demo.model;


import java.util.List;

public class QuizResultsResponseDTO {
    private Quiz quiz;
    private List<PlantDetailsDTO> plantDetails;

    public QuizResultsResponseDTO(Quiz quiz, List<PlantDetailsDTO> plantDetails) {
        this.quiz = quiz;
        this.plantDetails = plantDetails;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<PlantDetailsDTO> getPlantDetails() {
        return plantDetails;
    }

    public void setPlantDetails(List<PlantDetailsDTO> plantDetails) {
        this.plantDetails = plantDetails;
    }
}

