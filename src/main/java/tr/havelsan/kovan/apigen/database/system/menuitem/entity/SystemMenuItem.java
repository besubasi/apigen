package tr.havelsan.kovan.apigen.database.system.menuitem.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = SystemMenuItem.SCHEMA, name = SystemMenuItem.TABLE)
@Getter
@Setter
public class SystemMenuItem extends PanacheEntity {

    public static final String SCHEMA = "system";
    public static final String TABLE = "sys_menu_item";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_UUID = "uuid";
    public static final String COLUMN_PARENT_ID = "parent_id";
    public static final String COLUMN_MENU_ORDER = "menu_order";
    public static final String COLUMN_LABEL = "label";
    public static final String COLUMN_PATH = "path";

    @Column(name = COLUMN_ID)
    Long id;

    @Column(name = COLUMN_UUID)
    String uuid;

    @Column(name = COLUMN_LABEL)
    String label;

    @Column(name = COLUMN_PARENT_ID)
    Long parentId;

    @Column(name = COLUMN_MENU_ORDER)
    Long order;

    @Column(name = COLUMN_PATH)
    String path;

}
