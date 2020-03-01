package org.wcci.blog;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String postName;
    private String postAuthor;
    private Date postDate;
    private String postText;
    @ManyToOne
    private Category postCategory;
    @ManyToMany
    private Set<Tag> tags;

    public Post() {
    }

    public Post(String postAuthor, String postText, Category postCategory, String postName) {
       this.postAuthor = postAuthor;
       this.postDate = new Date();
       this.postText = postText;
       this.postCategory = postCategory;
       this.postName = postName;
       this.tags = new HashSet<>();

    }

    public Collection<Tag> getTags() {return tags; }

    public String getPostName() { return postName;}

    public String getPostAuthor() {return postAuthor;}

    public Date getPostDate() {return postDate;}

    public String getPostText() {return postText;}

    public Category getPostCategory() {return postCategory;}

    public Long getId() {return id;}

    public void addTag(Tag tagToAdd) {tags.add(tagToAdd);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postName, post.postName) &&
                Objects.equals(postCategory, post.postCategory) &&
                Objects.equals(postAuthor, post.postAuthor) &&
                Objects.equals(postDate, post.postDate) &&
                Objects.equals(postText, post.postText) &&
                Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(postAuthor, postDate, postText, postCategory, postName, id, tags);
    }


































}
