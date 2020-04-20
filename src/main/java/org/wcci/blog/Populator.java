package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;
    PostStorage postStorage;
    TagStorage tagStorage;

    public Populator(CategoryStorage categoryStorage, PostStorage postStorage, TagStorage tagStorage){
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.tagStorage = tagStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populator is populating...?");

        Category cat1 = new Category("Cat1", "This is the first category");
        categoryStorage.storeCategory(cat1);

        Category cat2 = new Category("Cat2", "This is the second category");
        categoryStorage.storeCategory(cat2);

        Category cat3 = new Category("Cat3", "This is the third category");
        categoryStorage.storeCategory(cat3);

        Category cat4  = new Category("Cat4", "This is the fourth category");
        categoryStorage.storeCategory(cat4);

        Category cat5  =  new Category("Cat5", "This is the fifth category");
        categoryStorage.storeCategory(cat5);

        Category cat6 = new Category("Cat6", "This is the sixth category");
        categoryStorage.storeCategory(cat6);

        Post firstPost = new Post();
        postStorage.storePost(firstPost);

        Post secondPost = new Post();
        postStorage.storePost(secondPost);

        Post thirdPost = new Post();
        postStorage.storePost(thirdPost);

        Post fourthPost = new Post();
        postStorage.storePost(fourthPost);

        Post fifthPost = new Post();
        postStorage.storePost(fifthPost);

        Post sixthPost = new Post();
        postStorage.storePost(sixthPost);

        Post seventhPost = new Post();
        postStorage.storePost(seventhPost);


        Tag Tag1 = new Tag("tag1");
        tagStorage.storeTag(Tag1);
        firstPost.addTag(Tag1);
        postStorage.storePost(firstPost);

        Tag Tag2 = new Tag("tag2");
        tagStorage.storeTag(Tag2);
        secondPost.addTag(Tag2);
        postStorage.storePost(secondPost);

        Tag Tag3 = new Tag("tag3");
        tagStorage.storeTag(Tag3);
        thirdPost.addTag(Tag3);
        postStorage.storePost(thirdPost);

        Tag Tag4 = new Tag("tag4");
        tagStorage.storeTag(Tag4);
        fourthPost.addTag(Tag4);
        postStorage.storePost(fourthPost);

        Tag Tag5 = new Tag("tag5");
        tagStorage.storeTag(Tag5);
        fifthPost.addTag(Tag5);
        postStorage.storePost(fifthPost);

        Tag Tag6 = new Tag("tag6");
        tagStorage.storeTag(Tag6);
        sixthPost.addTag(Tag6);
        postStorage.storePost(sixthPost);

        Tag Tag7 = new Tag("tag7");
        tagStorage.storeTag(Tag7);
        seventhPost.addTag(Tag7);
        postStorage.storePost(seventhPost);


    }
}


