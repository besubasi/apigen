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
    public static final String COLUMN_PARENT_ID = "parent_id";
    public static final String COLUMN_MENU_ORDER = "menu_order";

    String label, path;
    @Column(name = COLUMN_PARENT_ID)
    Long parentId;

    @Column(name = COLUMN_MENU_ORDER)
    Long order;

}
