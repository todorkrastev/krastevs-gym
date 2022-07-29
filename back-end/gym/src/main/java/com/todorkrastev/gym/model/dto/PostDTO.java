package com.todorkrastev.gym.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDTO> comments;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "Title must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Title must have at least 1 character!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank(message = "Title must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Description must have at least 1 character!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank(message = "Title must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Content must have at least 1 character!")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDTO> comments) {
        this.comments = comments;
    }
}
