package de.urr4.mealplanner.adapter.driving.rest.tag;

import de.urr4.mealplanner.domain.tag.Tag;

public class TagMapper {

    public static TagDto toDto(Tag tag) {
        TagDto dto = new TagDto();
        dto.setId(tag.getId());
        dto.setName(tag.getTag());
        return dto;
    }

    public static Tag toDomain(TagDto dto) {
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setTag(dto.getName());
        return tag;
    }

}
