package io.github.DoubleBerserker.stele.services.impl;

import io.github.DoubleBerserker.stele.services.MarkdownService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
public class MarkdownServiceImpl implements MarkdownService {

    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

    @Override
    @Named(value = "toHtml")
    public String convertMarkdownToHtml(String markdownText) {

        if(markdownText == null)
            return "";

        Node node = parser.parse(markdownText);
        return renderer.render(node);
    }
}
