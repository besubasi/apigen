package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuChangesetModel {

    String label, path, parentUuid, authorityCode;
    Integer order;

}
