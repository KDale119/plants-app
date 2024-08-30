package com.mccneb.edu.demo.service;

import com.mccneb.edu.demo.model.Comment;
import com.mccneb.edu.demo.model.Plant;
import com.mccneb.edu.demo.repository.CommentRepository;
import com.mccneb.edu.demo.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final PlantRepository plantRepository;
    private final CommentRepository commentRepository;
    private final PlantService plantService;

    public CommentService(PlantRepository plantRepository, CommentRepository commentRepository, PlantService plantService){
        this.plantRepository = plantRepository;
        this.commentRepository = commentRepository;
        this.plantService = plantService;
    }

    public Comment addComment(String username, Integer externalPlantId, Comment comment){
        Optional<Plant> plantByExternalApiId = plantRepository.findByApiId(externalPlantId);
        Plant plant = null;
        if (plantByExternalApiId.isPresent()) {
            plant = plantByExternalApiId.get();
        } else {
            plant = plantService.findPlantByApiId(externalPlantId);
            plant = plantRepository.save(plant);
        }
        comment.setPlantId(plant.getPlantId());
        comment.setUsername(username);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Integer commentId, Comment comment){
        Optional<Comment> commentResponse = commentRepository.findById(commentId);
        if (commentResponse.isPresent()) {
            comment.setWasEdited(true);
            return commentRepository.save(comment);
        } else {
            return null;
        }
    }

    public List<Comment> getCommentsByExternalPlantId(Integer externalPlantId){
        Optional<Plant> plantByExternalApiId = plantRepository.findByApiId(externalPlantId);
        Plant plant = null;
        if (plantByExternalApiId.isPresent()) {
            plant = plantByExternalApiId.get();
            return commentRepository.findCommentsByPlantId(plant.getPlantId());
        } else {
            return null;
        }
    }

    public Boolean deleteComment(Integer id){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            commentRepository.delete(comment.get());
            return true;
        } else {
            return false;
        }
    }
}
