package tr.subasi.apigen.generator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyModel {

    private String type;
    private String name;
    private String dbName;
    private boolean notNull;
    private boolean useSearchParameter;

}
