package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.havelsan.kovan.apigen.common.enums.EnumMicroservice;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthChangesetModel {

    EnumMicroservice microservice;
    String code, label;
    List<String> roleCodeList;
}
