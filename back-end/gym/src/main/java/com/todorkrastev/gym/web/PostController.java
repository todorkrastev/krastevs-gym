package com.todorkrastev.gym.web;

import com.todorkrastev.gym.model.dto.PostDTO;
import com.todorkrastev.gym.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post rest api
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(this.postService.createPost(postDTO), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return this.postService.getAllPosts();
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    // update post by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable(name = "id") Long id) {

        PostDTO postResponse = this.postService.updatePost(postDTO, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {

        this.postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
