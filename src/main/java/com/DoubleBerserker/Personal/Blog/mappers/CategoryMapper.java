package com.DoubleBerserker.Personal.Blog.mappers;

import com.DoubleBerserker.Personal.Blog.dto.CategoryDto;
import com.DoubleBerserker.Personal.Blog.dto.CreateCategoryRequestDto;
import com.DoubleBerserker.Personal.Blog.entities.Category;
import com.DoubleBerserker.Personal.Blog.entities.Post;
import com.DoubleBerserker.Personal.Blog.entities.Status;
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
