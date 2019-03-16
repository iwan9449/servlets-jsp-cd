package pl.sda.repository;

import pl.sda.model.Post;
import pl.sda.service.UserService;
import pl.sda.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PostRepository {

    private List<Post> posts;
    private static PostRepository instance = null;
    private UserService userService;

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private PostRepository() {
        userService = UserService.getInstance();
        posts = new ArrayList<>();
        save(new Post("przykładowy tekst", userService.getUserByLogin("user").get()));
        save(new Post("przykładowy tekst jakiś inny", userService.getUserByLogin("admin").get()));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void save(Post post) {
        post.setId(IdGenerator.next());
        post.setCreatedDate(LocalDateTime.now());
        posts.add(post);
    }

    public Optional<Post> getPost(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public boolean update(Post post) {
        OptionalInt optIndex = IntStream.range(0, posts.size()).filter(i -> post.getId().equals(posts.get(i).getId())).findFirst();
        if (optIndex.isPresent()) {
            posts.set(optIndex.getAsInt(), post);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Post> deletePost(Long id) {
        Optional<Post> optRemovedPost = getPost(id);
        optRemovedPost.ifPresent(removedPost -> posts.removeIf(post -> post.equals(removedPost)));
        return optRemovedPost;
    }
}
