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

    @RequestMapping("/posts")
    public String displayPosts(Model model){
        model.addAttribute( "posts", postStorage.findAllPosts());
        return "ListOfPosts";
    }

    @RequestMapping("/post/{postId}")
    public String displaySinglePost(@PathVariable Long postId, Model model){
        Post retrievedPost = postStorage.findByPostId(postId);
        model.addAttribute( "post", retrievedPost);
        return "post";
    }

    @PostMapping("/add-post")
    public String addPost(@RequestParam String postAuthor, @RequestParam String postText, @RequestParam String CategoryName, @RequestParam String postName){
      Category postCategory = categoryStorage.findCategoryByName(categoryName);
      postStorage.storePost(new Post(postAuthor, postText, postCategory, postName));
      return "redirect:categories";
    }

    @PostMapping("/post/{id}/add-tag")
    public String addTagToPost(@RequestParam String name, @PathVariable Long id){

        Tag tagToAddToPost;
        Optional<Tag> tagOptional = tagRepository.findByName(name);

        if(tagOptional.isEmpty()) {
            tagToAddToReview = new Tag(name);
            tagRepository.save(tagToAddToPost);
        }else {
            tagToAddToPost = tagOptional.get();
        }

        Post postToAddTagTo = postStorage.findPostById(id);
        postToAddTagTo.addTag(tagToAddToPost);
        postStorage.storePost(postToAddTagTo);
        return "redirect:/post/" + id;
    }























}
