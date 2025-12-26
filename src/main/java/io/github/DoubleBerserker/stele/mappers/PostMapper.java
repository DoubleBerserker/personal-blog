package io.github.DoubleBerserker.stele.mappers;

import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.entities.Post;
import io.github.DoubleBerserker.stele.services.MarkdownService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {MarkdownService.class})
public abstract class PostMapper {

    @Mapping(target = "content", qualifiedByName = "toHtml")
    public abstract PostResponseDto postToPostResponseDto(Post post);

    @Mapping(target = "content", qualifiedByName = "toHtml")
    public abstract PostSummaryDto postToPostSummaryDto(Post post);

}
