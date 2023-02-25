package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static tr.havelsan.kovan.apigen.common.constant.CommonConstant.USER_NAME_KEY;

@Data
public class HelperModel {

    String author, changesetId;

    public HelperModel() {
        this.author = System.getProperty(USER_NAME_KEY);
        this.changesetId = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(OffsetDateTime.now()) + "-" + this.author;
    }

}
