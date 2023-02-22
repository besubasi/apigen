package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthChangesetModel {

    String code, label;
    List<String> roleCodeList;
}
