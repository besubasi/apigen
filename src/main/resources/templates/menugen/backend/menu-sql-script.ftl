-- Menu --
INSERT INTO SYSTEM.SYS_MENU_ITEM ( ID, CREATED_BY, CREATED_AT, UPDATED_AT, UPDATED_BY, UUID, OBJ_VERSION, DELETED, DELETED_AT, icon, label, menu_order, path, parent_uuid)
VALUES (NEXTVAL('SYSTEM.SYS_MENU_ITEM_SEQ'), 'logistic', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'logistic', '${model.menuUuid}', 0, 0, NULL, 'password_criterion', '${model.menuLabel}', ${model.menuOrder}, '${model.menuPath}', '${model.menuParentUuid}');

-- Menu Authority --
INSERT INTO SYSTEM.SYS_MENU_AUTHORITY VALUES (NEXTVAL('SYSTEM.SYS_MENU_AUTHORITY_SEQ'), 'logistic', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'logistic', '${model.menuUuid}_1' , 0, '${model.authorityCode}' , '${model.menuUuid}');

-- Authority--
INSERT INTO OAUTH.KYS_AUTHORITY (ID, CREATED_BY, CREATED_AT, UPDATED_AT, UPDATED_BY, UUID, OBJ_VERSION, DELETED, CODE, LABEL) VALUES (NEXTVAL('OAUTH.KYS_AUTHORITY_SEQ'), 'logistic' , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'logistic', '${model.authorityUuid}' , 0, 0, '${model.authorityCode}', '${model.authorityLabel}');

-- Role Authority --
INSERT INTO OAUTH.KYS_ROLE_AUTHORITY_REL (ID, CREATED_BY, CREATED_AT, UPDATED_AT, UPDATED_BY, UUID, OBJ_VERSION, DELETED, AUTHORITY_ID, ROLE_ID) VALUES (NEXTVAL('OAUTH.KYS_ROLE_AUTHORITY_REL_SEQ'), 'logistic', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'logistic', '${model.roleUuid}_${model.authorityUuid}', 0, 0, (SELECT a.id FROM OAUTH.KYS_AUTHORITY a WHERE a.uuid = '${model.authorityUuid}'), (SELECT r.id FROM OAUTH.KYS_ROLE r WHERE r.uuid = '${model.roleUuid}'));

-- Menu App --
INSERT INTO SYSTEM.SYS_MENU_ITEM_APP_NAME (MENU_ITEM_ID, APP_NAME_ID)
SELECT M.ID, (SELECT A.ID FROM SYSTEM.SYS_APP_NAME A WHERE A.UUID = 'SYS_APP_NAME_UUID_LOG')
FROM SYSTEM.SYS_MENU_ITEM M
WHERE M.CREATED_BY = 'logistic'
AND NOT EXISTS(SELECT 1
FROM SYSTEM.SYS_MENU_ITEM_APP_NAME R
WHERE R.MENU_ITEM_ID = M.ID
AND R.APP_NAME_ID =
(SELECT A.ID FROM SYSTEM.SYS_APP_NAME A WHERE A.UUID = 'SYS_APP_NAME_UUID_LOG'));