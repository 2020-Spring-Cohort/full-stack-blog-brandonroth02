package org.wcci.blog;

import java.util.Collection;

public interface TagStorage {

    static Tag findTagByName(String tagName) {
    }

    Collection<Tag> findAllTags();

    void storeTag(Tag tag);

    Tag findTagById(Long tagToFind);

    Tag FindTagByName(String TagName);
}
