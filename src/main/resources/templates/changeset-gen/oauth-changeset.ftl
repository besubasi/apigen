<#assign NOW = '{now}'>
    <changeSet author="${helper.author}" id="${helper.changesetId}" failOnError="false">
        <insert schemaName="oauth" tableName="kys_authority">
            <column name="id" valueSequenceNext="kys_authority_seq"/>
            <column name="created_by" value="logistic"/>
            <column name="created_at" valueDate="$${NOW}"/>
            <column name="updated_at" valueDate="$${NOW}"/>
            <column name="updated_by" value="logistic"/>
            <column name="uuid" value="${helper.authorityUuid}"/>
            <column name="obj_version" valueNumeric="0"/>
            <column name="deleted" valueNumeric="0"/>
            <column name="deleted_at"/>
            <column name="code" value="${model.code}"/>
            <column name="description"/>
            <column name="label" value="${model.label}"/>
        </insert>
        <#list model.roleCodeList as roleCode>
        <insert schemaName="oauth" tableName="kys_role_authority_rel">
            <column name="id" valueSequenceNext="kys_role_authority_rel_seq"/>
            <column name="created_by" value="logistic"/>
            <column name="created_at" valueDate="$${NOW}"/>
            <column name="updated_at" valueDate="$${NOW}"/>
            <column name="updated_by" value="logistic"/>
            <column name="uuid" value="${statics["java.util.UUID"].randomUUID()}"/>
            <column name="obj_version" valueNumeric="0"/>
            <column name="deleted" valueNumeric="0"/>
            <column name="deleted_at"/>
            <column name="authority_id"
                    valueComputed="(select t.id from OAUTH.kys_authority t where t.code = '${model.code}')"/>
            <column name="role_id"
                    valueComputed="(select t.id from OAUTH.kys_role t where t.code = '${roleCode}')"/>
        </insert>
        </#list>
    </changeSet>

