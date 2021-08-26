package br.com.andre.simpleblog.post.model;

import br.com.andre.simpleblog.postcontext.model.Author;
import br.com.andre.simpleblog.postcontext.model.Post;
import br.com.andre.simpleblog.postcontext.model.PostStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PostTest {
    private Post createPost() {
        return new Post(
                1L,
                "New Blog",
                "This is content new blog.",
                new Author(1L, "Alfredo Santana"),
                new Author(2L, "Carlos Tavares")
        );
    }

    private Post createPost(Long id, String title, String content, Author ... authors) {
        return new Post(id, title, content, authors);
    }

    @Test
    @DisplayName("Create new post with success")
    public void testPostSuccess() {
        Assertions.assertEquals(1L, createPost().getId());
        Assertions.assertEquals("New Blog", createPost().getTitle());
        Assertions.assertEquals("This is content new blog.", createPost().getContent());
        Assertions.assertTrue(createPost().getAuthors().size() == 2);
    }

    @Test
    @DisplayName("Change post status with success")
    public void testChangePostStatusSuccess() {
        Post postCreated = createPost();
        Assertions.assertEquals(PostStatus.CREATED, postCreated.getStatus());

        postCreated.changeStatus(PostStatus.IN_ANALYSIS);
        Assertions.assertEquals(PostStatus.IN_ANALYSIS, postCreated.getStatus());

        postCreated.changeStatus(PostStatus.APPROVED);
        Assertions.assertEquals(PostStatus.APPROVED, postCreated.getStatus());

        postCreated.changeStatus(PostStatus.PUBLISHED);
        Assertions.assertEquals(PostStatus.PUBLISHED, postCreated.getStatus());
    }

    @Test
    @DisplayName("Create post null or empty title with failure")
    public void testCreatePostTitleFailure() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, "", "Content", new Author(null, "Author Name")));

        Assertions.assertEquals("Post title is required", ex.getMessage());

        Exception ex2 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, null, "Content", new Author(null, "Author Name")));

        Assertions.assertEquals("Post title is required", ex.getMessage());
    }

    @Test
    @DisplayName("Create post null or empty content with failure")
    public void testCreatePostContentFailure() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, "Title", "", new Author(null, "Author Name")));

        Assertions.assertEquals("Post content is required", ex.getMessage());

        Exception ex2 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, "Title", null, new Author(null, "Author Name")));

        Assertions.assertEquals("Post content is required", ex.getMessage());
    }

    @Test
    @DisplayName("Create post null or empty authors with failure")
    public void testCreatePostAuthorsFailure() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, "Title", "Content"));

        Assertions.assertEquals("Post author is required to have at least one", ex.getMessage());

        Exception ex2 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, "Title", "Content", null));

        Assertions.assertEquals("Post author is required to have at least one", ex2.getMessage());

    }

    @Test
    @DisplayName("Create post all fields null with failure")
    public void testCreatePostAllFieldsFailure() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createPost(null, null, null, null));
    }

    @Test
    @DisplayName("Post toString method with success")
    public void testPostToStringSuccess() {
        Post post = createPost();
        String expected = String.format("Post(id=%d, title=%s)", post.getId(), post.getTitle());

        Assertions.assertEquals(expected, post.toString());
    }
}
