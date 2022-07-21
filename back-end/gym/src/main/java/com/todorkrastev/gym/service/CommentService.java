package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.CommentDTO;

public interface CommentService {
    CommentDTO createComment(Long postId, CommentDTO commentDTO);


}
