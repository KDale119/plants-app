package com.mccneb.edu.demo.service;

import com.mccneb.edu.demo.client.PlantClient;
import com.mccneb.edu.demo.model.ApiDetailsResults;
import com.mccneb.edu.demo.model.ApiSpeciesResults;
import com.mccneb.edu.demo.model.PlantDetailsDTO;
import com.mccneb.edu.demo.model.Quiz;
import com.mccneb.edu.demo.model.QuizResultsResponseDTO;
import com.mccneb.edu.demo.repository.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final PlantClient plantClient;

    public QuizService(QuizRepository quizRepository, PlantClient plantClient) {
        this.quizRepository = quizRepository;
        this.plantClient = plantClient;

    }

    public ResponseEntity<QuizResultsResponseDTO> quizResults(Quiz results) {

        ApiSpeciesResults response = plantClient.queryForQuiz(results);

        List<PlantDetailsDTO> plantDetailsList = response.getData()
                .stream()
                .limit(3)
                .map(species -> plantClient.getDetails(species.getId()))
                .map(this::mapToPlantDetailsDTO)
                .toList();

        String apiIdString = plantDetailsList.stream()
                .map(dto -> dto.getApiId().toString())
                .collect(Collectors.joining(","));

        results.setQuizResults(apiIdString);

        quizRepository.save(results);

        QuizResultsResponseDTO responseDTO = new QuizResultsResponseDTO(results, plantDetailsList);

        return ResponseEntity.ok(responseDTO);
    }

    private PlantDetailsDTO mapToPlantDetailsDTO(ApiDetailsResults details) {
        return new PlantDetailsDTO(
                details.getId(),
                details.getCommonName(),
                details.getSunlight().toString(),
                details.getWatering(),
                details.getDimension(),
                details.getPropagation()
        );
    }

    public Quiz findQuizById (Integer quizId){
        return quizRepository.findByQuizId(quizId);
    }

    public List<Quiz> findQuizByUserName(String userName) {
        return quizRepository.findByUserName(userName);
    }
}
