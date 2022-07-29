package com.todorkrastev.gym.repository;

import com.todorkrastev.gym.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
