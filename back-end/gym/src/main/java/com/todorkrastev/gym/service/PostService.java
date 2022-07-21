package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDto);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDTO, Long id);

    void deletePostById(Long id);
}
