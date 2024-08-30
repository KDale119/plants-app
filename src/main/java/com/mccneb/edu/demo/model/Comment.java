package com.mccneb.edu.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Comment")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "username")
    private String username;

    @Column(name = "plant_id")
    private Integer plantId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "edited")
    private boolean wasEdited;

    public Integer getCommentId() {
        return commentId;
    }

    public Comment setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Comment setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public Comment setPlantId(Integer plantId) {
        this.plantId = plantId;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Comment setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isWasEdited() {
        return wasEdited;
    }

    public Comment setWasEdited(boolean wasEdited) {
        this.wasEdited = wasEdited;
        return this;
    }
}
