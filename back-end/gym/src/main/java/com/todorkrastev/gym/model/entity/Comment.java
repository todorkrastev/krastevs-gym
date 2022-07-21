package com.todorkrastev.gym.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private String name;
    private String body;

    private Post post;

    public Comment() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "body", nullable = false)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
