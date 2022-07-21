package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.CommentDTO;
import com.todorkrastev.gym.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") Long postId,
                                                    @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(this.commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }
}
