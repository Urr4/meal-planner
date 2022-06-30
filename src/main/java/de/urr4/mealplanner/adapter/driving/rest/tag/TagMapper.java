package de.urr4.mealplanner.adapter.driving.rest.tag;

import de.urr4.mealplanner.adapter.driving.rest.DomainToDtoMapper;
import de.urr4.mealplanner.domain.tag.Tag;

public class TagMapper implements DomainToDtoMapper<TagDto, Tag> {

    private static TagMapper instance;

    public static TagMapper getInstance() {
        if (instance == null) {
            instance = new TagMapper();
        }
        return instance;
    }

    private TagMapper() {
    }

    public TagDto toDto(Tag tag) {
        TagDto dto = new TagDto();
        dto.setId(tag.getId());
        dto.setName(tag.getTag());
        return dto;
    }

    public Tag toDomain(TagDto dto) {
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setTag(dto.getName());
        return tag;
    }

}
