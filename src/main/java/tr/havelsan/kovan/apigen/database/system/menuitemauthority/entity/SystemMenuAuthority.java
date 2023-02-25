package tr.havelsan.kovan.apigen.database.system.menuitemauthority.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = SystemMenuAuthority.SCHEMA, name = SystemMenuAuthority.TABLE)
@Getter
@Setter
public class SystemMenuAuthority extends PanacheEntity {

    public static final String SCHEMA = "system";
    public static final String TABLE = "sys_menu_item_authority";
    public static final String COLUMN_MENU_ITEM_ID = "menu_item_id";
    public static final String COLUMN_AUTHORITY_CODE = "authority_code";


    @Column(name = COLUMN_MENU_ITEM_ID)
    Long menuItemId;

    @Column(name = COLUMN_AUTHORITY_CODE)
    String authorityCode;

}