package tr.havelsan.kovan.apigen.generator.frontendcopy.service;

import tr.havelsan.kovan.apigen.common.util.FileUtil;
import tr.havelsan.kovan.apigen.generator.frontendcopy.model.FrontendCopyModel;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class FrontendCopyServiceImpl implements FrontendCopyService {


    @Override
    public Boolean copy(FrontendCopyModel frontendCopyModel) throws IOException {
        List<Path> sourcePathList;
        try (Stream<Path> walk = Files.walk(Paths.get(frontendCopyModel.getSourcePath()))) {
            sourcePathList = walk.collect(Collectors.toList());
        }
        for (Path sourcePath : sourcePathList)
            createTarget(sourcePath, frontendCopyModel);

        return Boolean.TRUE;
    }

    public static void createTarget(Path sourcePath, FrontendCopyModel frontendCopyModel) throws IOException {
        Path targetPath = getTargetPath(sourcePath, frontendCopyModel);
        if (Files.isDirectory(sourcePath))
            FileUtil.createDirectory(targetPath);
        else
            FileUtil.writeFile(targetPath, getTargetContent(sourcePath, frontendCopyModel));
    }

    public static Path getTargetPath(Path path, FrontendCopyModel frontendCopyModel) {
        String targetFileName = path.toString().replace(frontendCopyModel.getSourcePath(), frontendCopyModel.getTargetPath());

        Map<String, String> keyValueMap = frontendCopyModel.getKeyValueMap();
        for (String key : keyValueMap.keySet())
            targetFileName = targetFileName.replaceAll(key, keyValueMap.get(key));

        return Paths.get(targetFileName);
    }

    public static String getTargetContent(Path path, FrontendCopyModel frontendCopyModel) throws IOException {
        var content = Files.readString(path);
        for (Map.Entry<String, String> entry : frontendCopyModel.getKeyValueMap().entrySet())
            content = content.replaceAll(entry.getKey(), entry.getValue());

        return content;
    }

}


