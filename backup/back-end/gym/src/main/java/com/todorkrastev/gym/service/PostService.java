package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.PostDTO;
import com.todorkrastev.gym.model.dto.PostResponseDTO;
import com.todorkrastev.gym.model.entity.Post;

public interface PostService {
    PostDTO createPost(PostDTO postDto);

    PostResponseDTO getAllPosts(int pageNum, int pageSize, String sortBy, String sortDir);

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDTO, Long id);

    void deletePostById(Long id);

    Post findById(Long id);
}
