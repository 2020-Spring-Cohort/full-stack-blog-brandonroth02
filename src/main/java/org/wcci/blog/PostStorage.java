package org.wcci.blog;

import java.util.Collection;

public interface PostStorage {
    Collection<Post> findAllPosts();

    Post storePost(Post post);

    Post findByPostId(Long postToFind);


    Post findPostById(Long id);
}
