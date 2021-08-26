package br.com.andre.simpleblog.postcontext.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name"})
public class Author {
    private Long id;
    private String name;

    public Author(Long id, String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Author name is required");

        this.id = id;
        this.name = name;
    }
}
