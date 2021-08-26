package br.com.andre.simpleblog.postcontext.service;

import br.com.andre.simpleblog.postcontext.model.Post;
import br.com.andre.simpleblog.sharedkernel.service.ApplicationService;

public interface PostService extends ApplicationService {
    Post create(Post post);
}
