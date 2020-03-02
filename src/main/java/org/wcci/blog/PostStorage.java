package org.wcci.blog;

public interface PostStorage {
    void storePost(Post postToAddTagTo);

    Post findByPostId(Long postId);

    Object findAllPosts();
}
