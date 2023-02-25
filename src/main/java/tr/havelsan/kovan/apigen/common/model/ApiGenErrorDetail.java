package tr.havelsan.kovan.apigen.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApiGenErrorDetail implements Serializable {

    private String uuid, errorClassName, errorCode, errorDetail, errorMessage, service;
    private transient Object[] errorArguments;
    private Date time;

}