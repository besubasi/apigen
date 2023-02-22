package tr.havelsan.kovan.apigen.generator.apigenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinPropertyModel {

    private String relation, foreignKey, type, name, dbName;
    private boolean lazy;
}
