package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.exception.ResourceNotFoundException;
import com.todorkrastev.gym.model.dto.PostDTO;
import com.todorkrastev.gym.model.entity.Post;
import com.todorkrastev.gym.repository.PostRepository;
import com.todorkrastev.gym.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDto) {
        // convert DTO to entity
        Post post = mapToEntity(postDto);
        Post newPost = this.postRepository.save(post);

        // convert entity to DTO
        return mapToDTO(newPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        // get post by id from the database
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        Post updatedPost = this.postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        // get post by id from the database
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        this.postRepository.delete(post);
    }

    // convert Entity into DTO
    private PostDTO mapToDTO(Post post) {
        PostDTO postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDTO postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
