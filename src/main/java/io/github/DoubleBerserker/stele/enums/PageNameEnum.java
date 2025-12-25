package io.github.DoubleBerserker.stele.enums;

public enum PageNameEnum {

    BASE("base"),

    HOMEPAGE("homepage"),
    POSTS_MAIN_PAGE("allPosts"),
    POST("post"),
    ABOUT("about");

    public final String value;

    PageNameEnum(String value) {
        this.value = value;
    }

}
