package tr.subasi.apigen.common.model;

import lombok.Data;

@Data
public class ConfModel {

    private String servicePackage;

    public ConfModel(String servicePackage) {
        this.servicePackage = servicePackage;
    }
}
