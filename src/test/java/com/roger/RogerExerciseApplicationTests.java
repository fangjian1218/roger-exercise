//package com.roger;
//
//import io.github.swagger2markup.GroupBy;
//import io.github.swagger2markup.Language;
//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.URL;
//import java.nio.file.Paths;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RogerExerciseApplicationTests {
//
//    @Test
//    public void contextLoads() {
//    }
//
//    private String url = "http://localhost:8882/mujiapp/v2/api-docs";
//    private String asciidoc = "./target/asciidoc/generated";
//    private String markdown = "./target/markdown/generated";
//    private String confluence = "./target/confluence/generated";
//
//    /**
//     * 生成Asciidoc格式文档,并汇总成一个文件
//     */
//    @Test
//    public void generateAsciiDocsToFile() throws Exception {
//        // 输出Asciidoc到单文件
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL(url))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get(asciidoc.concat("/mujiapp")));
//    }
//
//    /**
//     * 生成Asciidoc格式文档
//     */
//    @Test
//    public void generateAsciiDocs() throws Exception {
//        // 输出Asciidoc格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL(url))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get(asciidoc));
//    }
//
//    /**
//     * 生成Markdown格式文档,并汇总成一个文件
//     */
//    @Test
//    public void generateMarkdownDocsToFile() throws Exception {
//        // 输出Markdown到单文件
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL(url))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get(markdown.concat("/mujiapp")));
//    }
//
//    /**
//     * 生成Markdown格式文档
//     */
//    @Test
//    public void generateMarkdownDocs() throws Exception {
//        // 输出Markdown格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL(url))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get(markdown));
//    }
//
//    /**
//     * 生成Confluence格式文档
//     */
//    @Test
//    public void generateConfluenceDocs() throws Exception {
//        // 输出Confluence使用的格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL(url))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get(confluence));
//    }
//}
