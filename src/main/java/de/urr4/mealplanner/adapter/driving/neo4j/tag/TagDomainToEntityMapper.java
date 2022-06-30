package de.urr4.mealplanner.adapter.driving.neo4j.tag;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.domain.tag.Tag;

public class TagDomainToEntityMapper implements DomainToEntityMapper<Tag, TagEntity> {

    private static TagDomainToEntityMapper instance;

    public static TagDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new TagDomainToEntityMapper();
        }
        return instance;
    }

    private TagDomainToEntityMapper() {
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
