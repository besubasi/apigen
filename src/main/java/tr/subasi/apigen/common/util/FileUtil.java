package tr.subasi.apigen.common.util;

import freemarker.template.Template;
import tr.subasi.apigen.config.freemarker.Templates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static tr.subasi.apigen.generator.constant.ApiGeneratorConstant.*;

public class FileUtil {
    private static final Map<Template, String> mapFileEndFix = Map.of(
            Templates.CONSTANT, END_FIX_CONSTANT
            , Templates.ENTITY, END_FIX_ENTITY
            , Templates.MODEL, END_FIX_MODEL
            , Templates.SEARCH_MODEL, END_FIX_SEARCH_MODEL
            , Templates.REPOSITORY, END_FIX_REPOSITORY
            , Templates.MAPPER, END_FIX_MAPPER
            , Templates.SERVICE, END_FIX_SERVICE
            , Templates.SERVICE_IMPL, END_FIX_SERVICE_IMPL
            , Templates.REST_CONTROLLER, END_FIX_REST_CONTROLLER
    );

    private static final Map<Template, String> mapPackage = Map.of(
            Templates.CONSTANT, PACKAGE_CONSTANT
            , Templates.ENTITY, PACKAGE_ENTITY
            , Templates.MODEL, PACKAGE_MODEL
            , Templates.SEARCH_MODEL, PACKAGE_MODEL
            , Templates.REPOSITORY, PACKAGE_REPOSITORY
            , Templates.MAPPER, PACKAGE_MAPPER
            , Templates.SERVICE, PACKAGE_SERVICE
            , Templates.SERVICE_IMPL, PACKAGE_SERVICE
            , Templates.REST_CONTROLLER, PACKAGE_CONTROLLER
    );

    public static String getFileEndFix(Template template){
        return mapFileEndFix.get(template);
    }

    public static String getSubPackage(Template template){
        return mapPackage.get(template);
    }

    public static void createDirectory(Path path) throws IOException {
        if (Files.notExists(path))
            Files.createDirectories(path);
    }

    public static void writeFile(Path path, String content) throws IOException {
        if (Files.notExists(path))
            Files.createFile(path);

        Files.writeString(path, content);
    }

/*
    public static List<Path> listFiles(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public static List<Path> listFilesByDepth(Path path, int maxDepth) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path, maxDepth)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }

    public static List<Path> listDirectories(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isDirectory)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public static List<Path> findByFileExtension(Path path, String fileExtension)
            throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)   // is a file
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return result;
    }


    public static List<Path> findByFileName(Path path, String fileName)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<Path> result;
        // walk file tree, no more recursive loop
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isReadable)      // read permission
                    .filter(Files::isRegularFile)   // is a file
                    .filter(p -> p.getFileName().toString().equalsIgnoreCase(fileName))
                    .collect(Collectors.toList());
        }
        return result;
    }
*/

}
