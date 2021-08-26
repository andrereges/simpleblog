package br.com.andre.simpleblog.post.model;

import br.com.andre.simpleblog.postcontext.model.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorTest {
    private Author createAuthor() {
        return new Author(1L, "Alfredo Santana");
    }

    private Author createAuthor(Long id, String name) {
        return new Author(id, name);
    }

    @Test
    @DisplayName("Create new author with success")
    public void testAuthorSuccess() {
        Assertions.assertEquals(1L, createAuthor().getId());
        Assertions.assertEquals("Alfredo Santana", createAuthor().getName());
    }

    @Test
    @DisplayName("Create author null or empty name with failure")
    public void testCreateAuthorNameFailure() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createAuthor(null, ""));

        Assertions.assertEquals("Author name is required", ex.getMessage());

        Exception ex2 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> createAuthor(null, null));

        Assertions.assertEquals("Author name is required", ex.getMessage());
    }

    @Test
    @DisplayName("Author toString method with success")
    public void testAuthorToStringSuccess() {
        Author author = createAuthor();
        String expected = String.format("Author(id=%d, name=%s)", author.getId(), author.getName());

        Assertions.assertEquals(expected, author.toString());
    }
}
