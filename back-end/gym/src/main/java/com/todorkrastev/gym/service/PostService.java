package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.PostDTO;
import com.todorkrastev.gym.model.dto.PostResponseDto;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDto);

    PostResponseDto getAllPosts(int pageNum, int pageSize);

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDTO, Long id);

    void deletePostById(Long id);
}
