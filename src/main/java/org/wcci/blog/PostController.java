package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class PostController {

    private PostStorage postStorage;
    private CategoryStorage categoryStorage;
    private TagRepository tagRepository;

    public PostController(PostStorage postStorage, CategoryStorage categoryStorage, TagRepository tagRepository){
        this.postStorage = postStorage;
        this.categoryStorage = categoryStorage;
        this.tagRepository = tagRepository;
    }























}
