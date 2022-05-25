package de.urr4.mealplanner.adapter.driving.neo4j.tag;

import de.urr4.mealplanner.application.tag.TagRepository;
import de.urr4.mealplanner.domain.tag.Tag;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Neo4jTagRepositoryImpl implements TagRepository {

    private final SpringDataNeo4jTagRepository tagRepository;

    public Neo4jTagRepositoryImpl(SpringDataNeo4jTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        return TagMapper.getInstance().toDomain(tagRepository.save(TagMapper.getInstance().toEntity(tag)));
    }

    @Override
    public Collection<Tag> getAllTags() {
        return tagRepository.findAll().stream().map(TagMapper.getInstance()::toDomain).collect(Collectors.toList());
    }

    @Override
    public Tag getTagById(UUID tagId) {
        return TagMapper.getInstance().toDomain(tagRepository.findById(tagId).orElseThrow(() -> new IllegalArgumentException(String.format("Could not find tag with id %s", tagId))));
    }
}
