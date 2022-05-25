package de.urr4.mealplanner.domain.tag;

import java.util.Collection;
import java.util.UUID;

public interface TagService {

    Tag createTag(String tag);

    Collection<Tag> getAllTags();

    Tag getTagById(UUID tagId);
}
