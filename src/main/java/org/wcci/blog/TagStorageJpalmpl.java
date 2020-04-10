package org.wcci.blog;


import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TagStorageJpalmpl implements TagStorage {

    private TagRepository tagRepository;

    public TagStorageJpalmpl(TagRepository tagRepository) { this.tagRepository = tagRepository;}

    @Override
    public Collection<Tag> findAllTags() {
        return (Collection<Tag>) tagRepository.findAll();
    }

    @Override
    public void storeTag(Tag tag) {

        tagRepository.save(tag);
    }

    @Override
    public Tag findTagById(Long tagToFind) {
        return tagRepository.findById(tagToFind).get() ;
    }

    @Override
    public Tag FindTagByName(String tagName) {
        return tagRepository.findByName(tagName).get();
    }
}
