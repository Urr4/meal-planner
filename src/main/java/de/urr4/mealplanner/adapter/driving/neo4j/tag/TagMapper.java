package de.urr4.mealplanner.adapter.driving.neo4j.tag;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.domain.tag.Tag;

public class TagMapper implements Mapper<Tag, TagEntity> {

    private static TagMapper instance;

    public static TagMapper getInstance() {
        if (instance == null) {
            instance = new TagMapper();
        }
        return instance;
    }

    private TagMapper() {
    }

    @Override
    public TagEntity toEntity(Tag domain) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(domain.getId());
        tagEntity.setTag(domain.getTag());
        return tagEntity;
    }

    @Override
    public Tag toDomain(TagEntity tagEntity) {
        Tag tag = new Tag();
        tag.setId(tagEntity.getId());
        tag.setTag(tagEntity.getTag());
        return tag;
    }
}
