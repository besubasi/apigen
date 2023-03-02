<#assign NOW = '{now}'>
    <changeSet author="${helper.author}" id="${helper.changesetId}" failOnError="false">
        <#if modelList?has_content>
        <#list modelList as model>
        <#assign MENU_ITEM_UUID =  statics["java.util.UUID"].randomUUID()>
        <insert schemaName="system" tableName="sys_menu_item">
            <column name="id" valueSequenceNext="sys_menu_item_seq"/>
            <column name="created_by" value="logistic"/>
            <column name="created_at" valueDate="$${NOW}"/>
            <column name="updated_at" valueDate="$${NOW}"/>
            <column name="updated_by" value="logistic"/>
            <column name="uuid" value="${MENU_ITEM_UUID}"/>
            <column name="obj_version" valueNumeric="0"/>
            <column name="deleted" valueNumeric="0"/>
            <column name="deleted_at"/>
            <column name="tenant"/>
            <column name="icon" value="password_criterion"/>
            <column name="label" value="${model.label}"/>
            <column name="menu_order" valueNumeric="${model.order}"/>
            <column name="app_name_id"
                    valueComputed="(select id from system.sys_app_name where uuid = 'SYS_APP_NAME_UUID_LOG')"/>
            <column name="path_type" valueNumeric="1"/>
            <#if model.parentUuid?? >
            <column name="parent_id"
                        valueComputed="(select t.id from system.sys_menu_item t where t.uuid = '${model.parentUuid}')"/>
            </#if>
            <#if model.path?? >
            <column name="path" value="${model.path}"/>
            </#if>
        </insert>
        <#if model.authorityCode?? >
        <insert schemaName="system" tableName="sys_menu_item_authority">
            <column name="id" valueSequenceNext="sys_menu_item_authority_seq"/>
            <column name="created_by" value="logistic"/>
            <column name="created_at" valueDate="$${NOW}"/>
            <column name="updated_at" valueDate="$${NOW}"/>
            <column name="updated_by" value="logistic"/>
            <column name="uuid" value="${statics["java.util.UUID"].randomUUID()}"/>
            <column name="obj_version" valueNumeric="0"/>
            <column name="authority_code" value="${model.authorityCode}"/>
            <column name="menu_item_id"
                    valueComputed="(select t.id from system.sys_menu_item t where t.uuid = '${MENU_ITEM_UUID}')"/>
        </insert>
        </#if>
        </#list>
        </#if>
    </changeSet>

