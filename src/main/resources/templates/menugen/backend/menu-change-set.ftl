<#assign NOW = '{now}'>
<changeSet author="${model.author}" id="${id}" failOnError="false">
    <insert schemaName="system" tableName="sys_menu_item">
        <column name="id" valueSequenceNext="SYS_MENU_ITEM_SEQ"/>
        <column name="created_by" value="logistic"/>
        <column name="created_at" valueDate="$${NOW}"/>
        <column name="updated_at" valueDate="$${NOW}"/>
        <column name="updated_by" value="logistic"/>
        <column name="uuid" value="${model.menuUuid}"/>
        <column name="obj_version" valueNumeric="0"/>
        <column name="deleted" valueNumeric="0"/>
        <column name="deleted_at"/>
        <column name="tenant"/>
        <column name="code"/>
        <column name="icon" value="password_criterion"/>
        <column name="label" value="${model.menuLabel}"/>
        <column name="menu_order" valueNumeric="${model.menuOrder}"/>
        <column name="parent_uuid" value="${model.menuParentUuid}"/>
        <column name="path" value="${model.menuPath}"/>
    </insert>
    <insert schemaName="system" tableName="sys_menu_authority">
        <column name="id" valueNumeric="SYS_MENU_AUTHORITY_SEQ"/>
        <column name="created_by" value="logistic"/>
        <column name="created_at" valueDate="$${NOW}"/>
        <column name="updated_at" valueDate="$${NOW}"/>
        <column name="updated_by" value="logistic"/>
        <column name="uuid" value="${model.menuUuid}_1"/>
        <column name="obj_version" valueNumeric="0"/>
        <column name="authority" value="${model.authorityCode}"/>
        <column name="menu_uuid" value="${model.menuUuid}"/>
    </insert>
    <insert schemaName="system" tableName="sys_menu_item_app_name">
        <column name="menu_item_id"
                valueComputed="(select id from system.sys_menu_item where uuid = '${model.menuUuid}')"/>
        <column name="app_name_id"
                valueComputed="(select id from system.sys_app_name where uuid = 'SYS_APP_NAME_UUID_LOG')"/>
    </insert>
    <insert schemaName="oauth" tableName="kys_authority">
        <column name="id" valueSequenceNext="kys_authority_seq"/>
        <column name="created_by" value="logistic"/>
        <column name="created_at" valueDate="$${NOW}"/>
        <column name="updated_at" valueDate="$${NOW}"/>
        <column name="updated_by" value="logistic"/>
        <column name="uuid" value="${model.authorityUuid}"/>
        <column name="obj_version" valueNumeric="0"/>
        <column name="deleted" valueNumeric="0"/>
        <column name="deleted_at"/>
        <column name="code" value="${model.authorityCode}"/>
        <column name="description"/>
        <column name="label" value="${model.authorityLabel}"/>
    </insert>
    <insert schemaName="oauth" tableName="kys_role_authority_rel">
        <column name="id" valueNumeric="1121"/>
        <column name="created_by" value="logistic"/>
        <column name="created_at" valueDate="$${NOW}"/>
        <column name="updated_at" valueDate="$${NOW}"/>
        <column name="updated_by" value="logistic"/>
        <column name="uuid" value="${model.roleUuid}_${model.authorityUuid}"/>
        <column name="obj_version" valueNumeric="0"/>
        <column name="deleted" valueNumeric="0"/>
        <column name="deleted_at"/>
        <column name="authority_id"
                valueComputed="(select id from OAUTH.kys_authority y where y.code = '${model.authorityUuid}')"/>
        <column name="role_id"
                valueComputed="(select id from OAUTH.kys_role y where y.code = '${model.roleUuid}')"/>
    </insert>
</changeSet>
