package br.com.andre.simpleblog.postcontext.service.impl;

import br.com.andre.simpleblog.postcontext.model.Post;
import br.com.andre.simpleblog.postcontext.repository.PostRepository;
import br.com.andre.simpleblog.postcontext.service.PostService;
import br.com.andre.simpleblog.sharedkernel.events.ApplicationEvent;
import br.com.andre.simpleblog.sharedkernel.events.EventBus;

import java.util.HashMap;
import java.util.Map;

public class PostServiceImpl implements PostService {
    static final String EVENT_POST_READY_FOR_SHARED = "PostReadyForShared";

    private PostRepository postRepository;
    private EventBus eventBus;

    @Override
    public Post create(Post post) {
        Post postSaved = this.postRepository.save(post);
        Map<String, String> payload = new HashMap<>();
        payload.put("post", String.valueOf(post.getId()));

        ApplicationEvent event = new ApplicationEvent(payload) {
            @Override
            public String getType() {
                return EVENT_POST_READY_FOR_SHARED;
            }
        };

        this.eventBus.publish(event);

        return postSaved;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
