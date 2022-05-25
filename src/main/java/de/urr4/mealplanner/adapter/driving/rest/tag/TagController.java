package de.urr4.mealplanner.adapter.driving.rest.tag;

import de.urr4.mealplanner.domain.tag.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    private final Logger LOG = LoggerFactory.getLogger(TagController.class);

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public Collection<TagDto> getAllTags() {
        LOG.info("Getting all tags");
        return tagService.getAllTags().stream().map(TagMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{tagId}")
    public TagDto getTagById(@PathVariable("tagId") UUID tagId) {
        LOG.info("Getting tag {}", tagId);
        return TagMapper.toDto(tagService.getTagById(tagId));
    }

    @PostMapping
    public TagDto createTag(@RequestBody CreateTagRequest createTagRequest) {
        LOG.info("Creating tag with name {}", createTagRequest.getName());
        return TagMapper.toDto(tagService.createTag(createTagRequest.getName()));
    }

}
