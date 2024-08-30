package com.mccneb.edu.demo.controller;

import com.mccneb.edu.demo.model.Comment;
import com.mccneb.edu.demo.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{username}/{externalPlantId}")
    public ResponseEntity<Comment> addComment(@PathVariable String username, @PathVariable Integer externalPlantId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.addComment(username, externalPlantId, comment));
    }

    @GetMapping("/{externalPlantId}")
    public ResponseEntity<List<Comment>> getCommentsByExternalPlantId(@PathVariable Integer externalPlantId) {
        List<Comment> resp = commentService.getCommentsByExternalPlantId(externalPlantId);
        return resp == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(resp);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer commentId, @RequestBody Comment comment) {
        Comment resp = commentService.updateComment(commentId, comment);
        return resp == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteComment(commentId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
