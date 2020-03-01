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
}
