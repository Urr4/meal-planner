package de.urr4.mealplanner.application.tag;

import de.urr4.mealplanner.domain.tag.Tag;
import de.urr4.mealplanner.domain.tag.TagService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(String tagName) {
        Tag tag = new Tag();
        tag.setTag(tagName);
        return tagRepository.createTag(tag);
    }

    @Override
    public Collection<Tag> getAllTags() {
        return tagRepository.getAllTags();
    }

    @Override
    public Tag getTagById(UUID tagId) {
        return tagRepository.getTagById(tagId);
    }
}
