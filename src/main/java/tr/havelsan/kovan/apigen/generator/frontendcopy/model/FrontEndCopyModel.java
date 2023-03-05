package tr.havelsan.kovan.apigen.generator.frontendcopy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontEndCopyModel {

    private String sourcePath, targetPath;
    private Map<String, String> keyMap;

}
