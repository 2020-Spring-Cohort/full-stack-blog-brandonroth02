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

        Category russet = new Category("Cat1", "This is the first category");
        categoryStorage.storeCategory(russet);

        Category white = new Category("Cat2", "This is the second category");
        categoryStorage.storeCategory(white);

        Category red = new Category("Cat3", "This is the third category");
        categoryStorage.storeCategory(red);

        Category blue  = new Category("Cat4", "This is the fourth category");
        categoryStorage.storeCategory(blue);

        Category yellow  =  new Category("Cat5", "This is the fifth category");
        categoryStorage.storeCategory(yellow);

        Category fingerling = new Category("Cat6", "This is the sixth category");
        categoryStorage.storeCategory(fingerling);

        Post firstPost = new Post();
        postStorage.storePost(firstPost);

        Post secondPost;
        secondPost = new Post();
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


        Tag goodTag = new Tag("good");
        tagStorage.storeTag(goodTag);
        firstPost.addTag(goodTag);
        postStorage.storePost(firstPost);

        Tag soGoodTag = new Tag("SoGood");
        tagStorage.storeTag(soGoodTag);
        secondPost.addTag(soGoodTag);
        postStorage.storePost(secondPost);

        Tag filling = new Tag("filling");
        tagStorage.storeTag(filling);
        thirdPost.addTag(filling);
        postStorage.storePost(thirdPost);

        Tag meh = new Tag("meh");
        tagStorage.storeTag(meh);
        fourthPost.addTag(meh);
        postStorage.storePost(fourthPost);

        Tag confused = new Tag("confused");
        tagStorage.storeTag(confused);
        fifthPost.addTag(confused);
        postStorage.storePost(fifthPost);

        Tag fun = new Tag("fun");
        tagStorage.storeTag(fun);
        sixthPost.addTag(fun);
        postStorage.storePost(sixthPost);

        Tag notForDog = new Tag("NotForDogs");
        tagStorage.storeTag(notForDog);
        seventhPost.addTag(notForDog);
        postStorage.storePost(seventhPost);


    }
}


