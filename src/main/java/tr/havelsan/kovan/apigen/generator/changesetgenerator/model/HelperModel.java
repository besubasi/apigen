package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static tr.havelsan.kovan.apigen.common.constant.CommonConstant.USER_NAME_KEY;

@Data
public class HelperModel {

    String author, changesetId, menuItemUuid, menuItemAuthorityUuid, authorityUuid;

    public HelperModel() {
        this.author = System.getProperty(USER_NAME_KEY);
        this.changesetId = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(OffsetDateTime.now()) + "-" + this.author;
        this.menuItemUuid = UUID.randomUUID().toString();
        this.menuItemAuthorityUuid = UUID.randomUUID().toString();
        this.authorityUuid = UUID.randomUUID().toString();
    }

}
