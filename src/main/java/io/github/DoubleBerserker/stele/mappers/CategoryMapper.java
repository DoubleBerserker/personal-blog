package io.github.DoubleBerserker.stele.mappers;

import io.github.DoubleBerserker.stele.dto.CategoryDto;
import io.github.DoubleBerserker.stele.dto.CreateCategoryRequestDto;
import io.github.DoubleBerserker.stele.entities.Category;
import io.github.DoubleBerserker.stele.entities.Post;
import io.github.DoubleBerserker.stele.entities.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto createCategoryRequestDto);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts.stream().filter(
                post -> Status.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
