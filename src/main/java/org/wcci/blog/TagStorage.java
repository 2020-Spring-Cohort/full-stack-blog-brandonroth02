package org.wcci.blog;

import java.util.Collection;

public interface TagStorage {
    Collection<Tag> findAllTags();

    void storeTag(Tag tag);

    Tag findTagById(Long tagToFind);

    Tag FindTagByName(String TagName);
}
