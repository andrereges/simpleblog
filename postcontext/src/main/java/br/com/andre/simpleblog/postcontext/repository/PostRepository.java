package br.com.andre.simpleblog.postcontext.repository;

import br.com.andre.simpleblog.postcontext.model.Post;

public interface PostRepository {
    Post list();
    Post save(Post post);
    Post update(Post post);
    Post find(Long id);
    Post delete(Long id);
}
