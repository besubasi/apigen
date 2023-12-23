package tr.subasi.apigen.common.model;

import lombok.Data;

@Data
public class ConfModel {

    private String servicePackage;
    private boolean importNotBlank;
    private boolean importBigDecimal;
    private boolean importLocalDate;
    private boolean importLocalDateTime;

    private boolean importBigDecimalSearchModel;
    private boolean importLocalDateSearchModel;
    private boolean importLocalDateTimeSearchModel;

    public ConfModel(String servicePackage) {
        this.servicePackage = servicePackage;
    }
}
