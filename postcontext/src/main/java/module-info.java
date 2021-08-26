module br.com.andre.simpleblog.post {
    requires br.com.andre.simpleblog.sharedkernel;
    requires lombok;
    requires java.validation;

    exports br.com.andre.simpleblog.postcontext.service;
    exports br.com.andre.simpleblog.postcontext.model;

    provides br.com.andre.simpleblog.postcontext.service.PostService
            with br.com.andre.simpleblog.postcontext.service.impl.PostServiceImpl;
}