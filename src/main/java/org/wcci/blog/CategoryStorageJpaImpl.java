package org.wcci.blog;

import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {

    private CategoryRepository categoryRepository;

    public CategoryStorageJpaImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Collection<Category> findAllCategories(){
        return (Collection<Category>) categoryRepository.findAll();
    }

    @Override
    public void storeCategory(Category category){
        categoryRepository.save(category);
    }

    @Override
    public Category findCategoryByName(String categoryToFind){
        return categoryRepository.findByCategoryName(categoryToFind).get();
    }
}
