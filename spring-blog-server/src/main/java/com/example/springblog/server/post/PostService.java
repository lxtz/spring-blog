package com.example.springblog.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Integer id) {
        return postRepository.findById(id);
    }

    public Optional<Post> createPost(Post post) {
        if (post.getTitle() == null || post.getAuthor() == null || post.getContent() == null) {
            return Optional.empty();
        }
        post.setId(null);
        post.setCreated(LocalDateTime.now());
        return Optional.of(postRepository.save(post));
    }
}
