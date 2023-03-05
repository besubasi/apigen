package tr.havelsan.kovan.apigen.generator.apigenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloneBasicConverterModel {

    private String sourcePath;
    private Map<String, String> keyMap;

}
