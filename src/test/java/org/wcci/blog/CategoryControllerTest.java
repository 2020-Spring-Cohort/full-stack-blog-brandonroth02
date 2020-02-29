package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CategoryControllerTest {
    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;
    private PostStorage mockPostStorage;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(CategoryStorage.class);
        mockPostStorage = mock(PostStorage.class);
        underTest = new CategoryController(mockStorage, mockPostStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockModel = mock(Model.class);
    }

    @Test
    public void shouldReturnViewWithOneCategory(){
        Category testCategory = new Category( "Monster", "Scary");
        when(mockStorage.findCategoryByName( "Sasquatch")).thenReturn(testCategory);

        underTest.displaySingleCategory( "Sasquatch", mockModel);

        verify(mockStorage).findCategoryByName( "Sasquatch");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCategory() {
        String viewName = underTest.displaySingleCategory( "Sasquatch", mockModel);
        assertThat(viewName).isEqualTo("category");
    }
    @Test
    public void shouldGoToSpecificCategories() throws Exception {
        Category testCategory = new Category( "Monster", "Evil");
        when(mockStorage.findCategoryByName( "Sasquatch")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/Sasquatch"))
                .andExpect(status().isOk());
    }
    @Test
    public void listControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category( "Demon", "From Hell");

        List<Category> categoryCollection = Collections.singletonList((testCategory));
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get( "/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name( "ListOfCategories"))
                .andExpect(model().attribute( "categories", categoryCollection));

    }
}
