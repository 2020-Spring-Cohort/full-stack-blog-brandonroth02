package org.wcci.blog;

import java.util.Collection;

public interface CategoryStorage {
    Collection<Category> findAllCategories();

    void StoreCategory(Category category);

    Category findCategoryByName(String categoryToFind);
}
