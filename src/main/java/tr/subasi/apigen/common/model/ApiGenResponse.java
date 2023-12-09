package tr.subasi.apigen.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.http.HttpHeaders;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiGenResponse<T> implements Serializable {

    private T body;

    private ApiGenErrorDetail errorDetail;

    private HttpHeaders headers;

    public ApiGenResponse(T body) {
        this.body = body;
    }

}