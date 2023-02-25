package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuChangesetModel {

    EnumMicroservice microservice;
    String label, path, parentUuid, authorityCode;
    Integer order;

}
