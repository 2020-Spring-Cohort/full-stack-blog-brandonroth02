package org.wcci.blog;


import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostStorageJpalmpl implements PostStorage {

    private PostRepository postRepository;

    public  PostStorageJpalmpl(PostRepository postRepository) {
        this.postRepository=postRepository; }


    @Override
    public Collection<Post> findAllPosts(){
    return (Collection<Post>) postRepository.findAll();
    }

    @Override
    public Collection<Post> storePost(Post post){
        return (Collection<Post>) postRepository.findAll();
    }

    @Override
    public Post findByPostId(Long postId) {
        return null;
    }

    @Override
    public Post findPostById(Long postToFind){
        return postRepository.findById(postToFind).get();
    }


}

