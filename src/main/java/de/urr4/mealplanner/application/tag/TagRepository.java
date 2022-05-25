package de.urr4.mealplanner.application.tag;

import de.urr4.mealplanner.domain.tag.Tag;

import java.util.Collection;
import java.util.UUID;

public interface TagRepository {

    Tag createTag(Tag tag);

    Collection<Tag> getAllTags();

    Tag getTagById(UUID tagId);
}
