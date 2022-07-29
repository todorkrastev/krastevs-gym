package com.todorkrastev.gym.service;

import com.todorkrastev.gym.payload.PostDto;
import com.todorkrastev.gym.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
