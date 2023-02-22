package tr.havelsan.kovan.apigen.generator.changesetgenerator.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static tr.havelsan.kovan.apigen.common.constant.CommonConstant.USER_NAME_KEY;

public class HelperModel {
    String author;
    String changesetId;
    String menuItemUuid;
    String menuItemAuthorityUuid;
    String authorityUuid;

    public HelperModel() {
        this.author = System.getProperty(USER_NAME_KEY);
        this.changesetId = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + "-" + this.author;
        this.menuItemUuid = UUID.randomUUID().toString();
        this.menuItemAuthorityUuid = UUID.randomUUID().toString();
        this.authorityUuid = UUID.randomUUID().toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getChangesetId() {
        return changesetId;
    }

    public void setChangesetId(String changesetId) {
        this.changesetId = changesetId;
    }

    public String getMenuItemUuid() {
        return menuItemUuid;
    }

    public void setMenuItemUuid(String menuItemUuid) {
        this.menuItemUuid = menuItemUuid;
    }

    public String getMenuItemAuthorityUuid() {
        return menuItemAuthorityUuid;
    }

    public void setMenuItemAuthorityUuid(String menuItemAuthorityUuid) {
        this.menuItemAuthorityUuid = menuItemAuthorityUuid;
    }

    public String getAuthorityUuid() {
        return authorityUuid;
    }

    public void setAuthorityUuid(String authorityUuid) {
        this.authorityUuid = authorityUuid;
    }

}
