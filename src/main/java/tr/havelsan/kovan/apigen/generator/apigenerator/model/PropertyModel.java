package tr.havelsan.kovan.apigen.generator.apigenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyModel {

    private String type, name, dbName;
    private boolean notNull, useQueryParameter = true;
}
