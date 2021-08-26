package br.com.andre.simpleblog.postcontext.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode(of = {"id", "title"})
@ToString(of = {"id", "title"})
public class Post {
    private Long id;
    private String title;
    private String content;
    private PostStatus status;
    private List<Author> authors;

    public Post(Long id, String title, String content, Author... authors) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Post title is required");

        if (content == null || content.isEmpty())
            throw new IllegalArgumentException("Post content is required");

        if (authors == null || authors.length < 1)
            throw new IllegalArgumentException("Post author is required to have at least one");

        this.id = id;
        this.title = title;
        this.content = content;
        this.authors = List.of(authors);
        this.status = PostStatus.CREATED;
    }

    public void changeStatus(PostStatus status) {
        this.status = status;
    }

}
