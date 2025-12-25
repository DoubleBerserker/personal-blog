package io.github.DoubleBerserker.stele.utils;

import org.springframework.ui.Model;

public final class ModelAttributeHelper {

    private static final String ATTR_TITLE = "title";   // Title to replace in HTML <head> tag
    private static final String ATTR_PAGE = "page";     // Fragment that Thymeleaf replaces for the page

    private ModelAttributeHelper() {
        throw new UnsupportedOperationException("Static utility class, DO NOT FUCKING INSTANTIATE YOU IDIOT.");
    }

    public static void addPageAttributes(Model model, String title, String pageTemplate) {
        model.addAttribute(ATTR_TITLE, title);
        model.addAttribute(ATTR_PAGE, pageTemplate);
    }

}
