package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@DataJpaTest

public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void categoryShouldHaveListOfPosts() {
        Category testCategory = new Category("Test Category", "Things");


        categoryRepository.save(testCategory);

    }
}
