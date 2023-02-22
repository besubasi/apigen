package tr.havelsan.kovan.apigen.common.util;

import tr.havelsan.kovan.apigen.generator.apigenerator.model.FrontEndCopyModel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class ApiGenUtil {

    public static void createDirectory(Path path) throws IOException {
        if (Files.notExists(path))
            Files.createDirectories(path);
//
//        try {
//            Files.createDirectories(path);
//        } catch (IOException e) {
//            if (!(e instanceof FileAlreadyExistsException))
//                e.printStackTrace();
//        }
    }


    public static void createTarget(Path sourcePath, FrontEndCopyModel frontEndCopyModel) throws IOException {
        Path targetPath = ApiGenUtil.getTargetPath(sourcePath, frontEndCopyModel);
        if (Files.isDirectory(sourcePath))
            ApiGenUtil.createDirectory(targetPath);
        else
            ApiGenUtil.writeFile(targetPath, ApiGenUtil.getTargetContent(sourcePath, frontEndCopyModel));
    }

    public static void writeFile(Path path, String content) throws IOException {
        if (Files.notExists(path))
            Files.createFile(path);

        Files.write(path, content.getBytes(StandardCharsets.UTF_8));

//        try {
//            Files.createFile(path);
//            System.out.println("File created : " + path);
//        } catch (IOException e) {
//            if (e instanceof FileAlreadyExistsException) {
//                System.out.println("File updated : " + path);
//            } else {
//                e.printStackTrace();
//            }
//        }
//        try {
//            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            if (!(e instanceof FileAlreadyExistsException))
//                e.printStackTrace();
//        }
    }


    public static Path getTargetPath(Path path, FrontEndCopyModel frontEndCopyModel) {
        String targetFileName = path.toString().replace(frontEndCopyModel.getSourcePath(), frontEndCopyModel.getTargetPath());

        Map<String, String> keyMap = frontEndCopyModel.getKeyMap();
        for (String key : keyMap.keySet())
            targetFileName = targetFileName.replaceAll(key, keyMap.get(key));

        return Paths.get(targetFileName);
    }

    public static String getTargetContent(Path path, FrontEndCopyModel frontEndCopyModel) throws IOException {
        var content = Files.readString(path);
        for (Map.Entry<String, String> entry : frontEndCopyModel.getKeyMap().entrySet())
            content = content.replaceAll(entry.getKey(), entry.getValue());

        return content;
    }

}
