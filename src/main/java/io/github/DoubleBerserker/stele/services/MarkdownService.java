package io.github.DoubleBerserker.stele.services;

import org.mapstruct.Named;

public interface MarkdownService {

    @Named(value = "toHtml")
    String convertMarkdownToHtml(String markdownText);

    String convertMarkdownToPlaintext(String markdownText);

}
