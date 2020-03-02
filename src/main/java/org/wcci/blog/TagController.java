package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class TagController {

    private TagStorage tagStorage;
    private CategoryStorage categoryStorage;
    private PostStorage postStorage;

    public TagController(PostStorage postStorage, CategoryStorage categoryStorage) {

    }

    public TagController(TagStorage tagStorage, PostStorage postStorage, CategoryStorage categoryStorage){
        this.tagStorage = tagStorage;
        this.postStorage = postStorage;
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/tags")
    public String displayTags(Model model) {
        model.addAttribute( "tags", tagStorage.findAllTags());
        return "ListOfTags";
    }

    @RequestMapping("/tag/{tagName")
    public String displaySingleTag(@PathVariable String tagName, Model model) {
      Tag retrievedTag = TagStorage.findTagByName(tagName);
        model.addAttribute( "tag", retrievedTag);
        return "tag";


    }


}
