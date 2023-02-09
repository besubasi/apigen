package tr.havelsan.kovan.apigen.generator.apigenerator.model;

import java.util.Map;

public class FrontEndCopyModel {

    private String sourcePath;
    private String targetPath;
    private Map<String, String> keyMap;

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public Map<String, String> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<String, String> keyMap) {
        this.keyMap = keyMap;
    }
}
