package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TagController {

    private TagStorage tagStorage;


    public TagController(TagStorage tagStorage, PostStorage postStorage, CategoryStorage categoryStorage){
        this.tagStorage = tagStorage;
    }

    @RequestMapping("/tags")
    public String displayTags(Model model) {
        model.addAttribute( "tags", tagStorage.findAllTags());
        return "ListOfTags";
    }

    @RequestMapping("/tag/{tagName}")
    public String displaySingleTag(@PathVariable String tagName, Model model) {
      Tag retrievedTag = tagStorage.FindTagByName(tagName);
        model.addAttribute( "tag", retrievedTag);
        return "tag";


    }



}
