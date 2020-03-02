package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    public Category testCategory;

    @BeforeEach
    public void Setup() {
        testCategory = new Category("Oh No", "AHHH");
    }

    @Test
    public void getterShouldGetName() {
        assertEquals(testCategory.getCategoryName(), "Oh No");
    }

    @Test
    public void getterShouldGetDescription() {
        assertEquals(testCategory.getCategoryDescription(), "AHHH");
    }
}



