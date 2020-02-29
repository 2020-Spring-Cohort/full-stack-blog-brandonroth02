package org.wcci.blog;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpalmplTest {

    @Test
    public Void shouldFindAllCategories(){
        CategoryRepository mockCatRepo = mock(CategoryRepository).class);
        Category testCategory = new Category( "Monster", "Scary");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCatRepo);
        when(mockCatRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.storeCategory(testCategory);
        verify(mockCatRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);{
        }
    }
    @Test
    public void shouldRetrieveSingleCategoryByName(){
        CategoryRepository mockCatRepo = mock(CategoryRepository).class);
        Category testCategory1 = new Category( "test Category1", "test Description 1" );
        Category testCategory2 = new Category("test Category 2", "test Description 2" );
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCatRepo);
        underTest.storeCategory((testCategory1));
        underTest.storeCategory((testCategory2));
        Optional<Category> testCategory1Optional = Optional.of(testCategory1);
        when(mockCatRepo.findByCategoryName( "test Category1").thenReturn(testCategory1Optional);
        Optional<Category> testCategory2Optional = Optional.of(testCategory2);
        when(mockCatRepo.findByCategoryName( "test Category2")).thenReturn(testCategory2Optional);

     Category retrieveCategory1 = underTest.findCategoryByName(" test Category1");
     Category retrieveCategory2 = underTest.findCategoryByName( "test Categrory2");

     assertThat(retrievedCategory1).isEqualTo(testCategory1);
     assertThat(retrievedCategory2).isEqualTo(testCategory2);


    }

































}
