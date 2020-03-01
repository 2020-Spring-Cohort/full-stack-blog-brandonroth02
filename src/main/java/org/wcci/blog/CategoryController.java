package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;
    private PostStorage postStorage;

    public  CategoryController(CategoryStorage categoryStorage, PostStorage postStorage){
       this.categoryStorage = categoryStorage;
       this.postStorage = postStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute( "categories", categoryStorage.findAllCategories());
        return "ListOfCategories";
    }

    @RequestMapping("/submissions")
    public String displaySubmissions(Model model) {
        model.addAttribute( "categories", categoryStorage.findAllCategories());
        return "Submissions";
    }

    @RequestMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = categoryStorage.findCategoryByName(categoryName);
        model.addAttribute( "category", retrievedCategory);
        return "category";
    }
}
