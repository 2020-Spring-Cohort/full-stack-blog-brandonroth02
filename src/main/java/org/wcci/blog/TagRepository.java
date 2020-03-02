package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long> {

    Optional<Tag> findById(Long idToFind);

    Optional<Tag> findByName(String name);
}
