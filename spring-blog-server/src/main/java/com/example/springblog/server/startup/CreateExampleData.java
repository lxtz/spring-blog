package com.example.springblog.server.startup;

import com.example.springblog.server.post.Post;
import com.example.springblog.server.post.PostService;
import com.example.springblog.server.user.UserDto;
import com.example.springblog.server.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateExampleData implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(CreateExampleData.class);
    private final PostService postService;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.containsOption("seed")) {
            logger.info("Creating Example Data");
            postService.createPost(Post.builder()
                    .title("Random Quote 1")
                    .author("Socrates")
                    .content("Wonder is the feeling of a philosopher, and philosophy begins in wonder.")
                    .build());
            postService.createPost(Post.builder()
                    .title("Random Quote 2")
                    .author("Plato")
                    .content("It is difficult to set forth any of the greater ideas, except by the use of examples; " +
                            "for it would seem that each of us knows everything that he knows as if in a dream and " +
                            "then again, when he is as it were awake, knows nothing of it all.")
                    .build());
            userService.createUser(UserDto.builder()
                    .username("admin")
                    .admin(true)
                    .password("foo")
                    .build());
            userService.createUser(UserDto.builder()
                    .username("user")
                    .admin(false)
                    .password("bar")
                    .build());
        }
    }
}
