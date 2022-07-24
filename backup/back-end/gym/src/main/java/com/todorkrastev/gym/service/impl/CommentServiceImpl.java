package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.exception.BlogAPIException;
import com.todorkrastev.gym.exception.ResourceNotFoundException;
import com.todorkrastev.gym.model.dto.CommentDTO;
import com.todorkrastev.gym.model.entity.Comment;
import com.todorkrastev.gym.model.entity.Post;
import com.todorkrastev.gym.repository.CommentRepository;
import com.todorkrastev.gym.service.CommentService;
import com.todorkrastev.gym.service.PostService;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostService postService, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.modelMapper = modelMapper;
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

    @Override
    public List<CommentDTO> getCommentsByPostId(Long postId) {
        //retrieve comments by postId
        List<Comment> comments = this.commentRepository.findByPostId(postId);

        // convert list of comment entities to list of comment dto
        return comments
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        Comment comment = getComment(postId, commentId);

        return mapToDTO(comment);
    }

    @Override
    public CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentRequest) {
        Comment comment = getComment(postId, commentId);

        comment.setName(commentRequest.getName());
        comment.setBody(commentRequest.getBody());

        Comment updatedComment = this.commentRepository.save(comment);

        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = getComment(postId, commentId);

        this.commentRepository.delete(comment);
    }

    @NotNull
    private Comment getComment(Long postId, Long commentId) {
        // retrieve post entity by id
        Post post = this.postService.findById(postId);

        // retrieve comment by id
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        return comment;
    }

    private CommentDTO mapToDTO(Comment comment) {
        //return this.modelMapper.map(comment, CommentDTO.class);

        CommentDTO commentDto = new CommentDTO();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setBody(comment.getBody());

        return commentDto;
    }

    private Comment mapToEntity(CommentDTO commentDTO) {
        //return this.modelMapper.map(commentDTO, Comment.class);

        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setBody(commentDTO.getBody());

        return comment;
    }
}