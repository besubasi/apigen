package tr.havelsan.kovan.apigen.generator.frontendcopy.service;

import tr.havelsan.kovan.apigen.common.util.FileUtil;
import tr.havelsan.kovan.apigen.generator.frontendcopy.model.FrontEndCopyModel;

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
public class FrontEndCopyServiceImpl implements FrontEndCopyService {


    @Override
    public Boolean copy(FrontEndCopyModel frontEndCopyModel) throws IOException {
        List<Path> sourcePathList;
        try (Stream<Path> walk = Files.walk(Paths.get(frontEndCopyModel.getSourcePath()))) {
            sourcePathList = walk.collect(Collectors.toList());
        }
        for (Path sourcePath : sourcePathList)
            createTarget(sourcePath, frontEndCopyModel);

        return Boolean.TRUE;
    }

    public static void createTarget(Path sourcePath, FrontEndCopyModel frontEndCopyModel) throws IOException {
        Path targetPath = getTargetPath(sourcePath, frontEndCopyModel);
        if (Files.isDirectory(sourcePath))
            FileUtil.createDirectory(targetPath);
        else
            FileUtil.writeFile(targetPath, getTargetContent(sourcePath, frontEndCopyModel));
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


