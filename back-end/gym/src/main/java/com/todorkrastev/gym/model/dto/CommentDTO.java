package com.todorkrastev.gym.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentDTO {
    private Long id;
    private String name;
    private String body;

    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "Name must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Body must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Body must have at least 1 character!")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
