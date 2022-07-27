package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.CommentDTO;
import com.todorkrastev.gym.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") Long postId,
                                                    @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(this.commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return this.commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId) {

        CommentDTO commentDTO = this.commentService.getCommentById(postId, commentId);

        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = this.commentService.updateComment(postId, commentId, commentDTO);

        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable(value = "postId") Long postId,
                                          @PathVariable(value = "id") Long commentId) {
        this.commentService.deleteComment(postId, commentId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
