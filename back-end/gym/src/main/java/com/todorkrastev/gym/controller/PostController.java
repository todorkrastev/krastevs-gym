package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.PostDTO;
import com.todorkrastev.gym.model.dto.PostResponseDTO;
import com.todorkrastev.gym.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.todorkrastev.gym.util.AppConstants.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(this.postService.createPost(postDTO), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public PostResponseDTO getAllPosts(
            @RequestParam(value = "pageNum", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return this.postService.getAllPosts(pageNum, pageSize, sortBy, sortDir);
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    // update post by id rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable(name = "id") Long id,
                                              @Valid @RequestBody PostDTO postDTO) {
        PostDTO postResponse = this.postService.updatePost(postDTO, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {

        this.postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.NO_CONTENT);
    }
}
