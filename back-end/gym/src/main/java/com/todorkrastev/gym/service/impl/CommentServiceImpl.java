package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.CommentDTO;
import com.todorkrastev.gym.model.entity.Comment;
import com.todorkrastev.gym.model.entity.Post;
import com.todorkrastev.gym.repository.CommentRepository;
import com.todorkrastev.gym.service.CommentService;
import com.todorkrastev.gym.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentServiceImpl(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    @Override
    public CommentDTO createComment(Long postId, CommentDTO commentDTO) {

        Comment comment = mapToEntity(commentDTO);

        // retrieve post entity by id
        Post post = this.postService.findById(postId);

        // set post to comment entity
        comment.setPost(post);

        // save comment entity to DB
        Comment newComment = this.commentRepository.save(comment);

        return mapToDTO(newComment);
    }

    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setBody(comment.getBody());

        return commentDTO;
    }

    private Comment mapToEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setBody(commentDTO.getBody());

        return comment;
    }
}
