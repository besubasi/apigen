package tr.havelsan.kovan.apigen.common.constant;

public interface PathConstant {

    String LOGISTIC_GENERAL_MICROSERVICE_NAME = "general";
    String LOGISTIC_GENERAL_MODULE_CONDITION = "condition";
    String LOGISTIC_GENERAL_MODULE_GENERAL = "general";
    String LOGISTIC_GENERAL_MODULE_GENERAL_ADDRESS = "generalAddress";
    String LOGISTIC_GENERAL_MODULE_INTEGRATIONS = "integrations";
    String LOGISTIC_GENERAL_MODULE_ORGANIZATION = "organization";
    String LOGISTIC_GENERAL_MODULE_PARAMETERS = "parameters";
    String LOGISTIC_GENERAL_YML_PATH = "/hvl-kovan-logistic/resources/configuration/modules/general-application.yml";
    String LOGISTIC_GENERAL_COMMON_PATH = "/hvl-kovan-logistic/modules/logistic-general/common/src/main/java";
    String LOGISTIC_GENERAL_COMMON_PACKAGE = "tr.com.havelsan.kovan.logistic.general.common";
    String LOGISTIC_GENERAL_SERVICE_PATH = "/hvl-kovan-logistic/modules/logistic-general/service/src/main/java";
    String LOGISTIC_GENERAL_SERVICE_PACKAGE = "tr.com.havelsan.kovan.logistic.general.service";
    String LOGISTIC_GENERAL_GROOVY_PATH = "/hvl-kovan-logistic/modules/logistic-general/service/src/main/resources/groovy";
    String LOGISTIC_GENERAL_GROOVY_PACKAGE = "tr.com.havelsan.kovan.logistic.general.service";
    String LOGISTIC_GENERAL_FRONTEND_PATH = "/hvl-kovan-ng/projects/logistic-general";
    String LOGISTIC_GENERAL_FRONTEND_SHARED_PATH = "/hvl-kovan-ng/projects/logistic-public-shared";
    String LOGISTIC_GENERAL_CONFIGURATION_CONSTANT = "GeneralConfigurationConstant";
    String LOGISTIC_GENERAL_MENU_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/maintenance-management/service/src/main/resources/db/changelog/logistic/maintenance.management/db.changelog-logistic-maintenance-menu-v2.0.xml";
    String LOGISTIC_GENERAL_OAUTH_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/maintenance-management/service/src/main/resources/db/changelog/logistic/maintenance.management/db.changelog-logistic-maintenance-oauth-v2.0.xml";
    String CONTROL_CLASS_ORGANIZATION_PATH = "CONTROL_CLASS_ORGANIZATION_PATH";
    String CONTROL_CLASS_LOGISTIC_GENERAL_PATH = "CONTROL_CLASS_LOGISTIC_GENERAL_PATH";

    String MATERIAL_MANAGEMENT_MICROSERVICE_NAME = "materialManagement";
    String MATERIAL_MANAGEMENT_MODULE_MATERIAL_IDENTIFICATION = "materialIdentification";
    String MATERIAL_MANAGEMENT_MODULE_PURCHASING = "purchasing";
    String MATERIAL_MANAGEMENT_MODULE_STOCK = "stock";
    String MATERIAL_MANAGEMENT_MODULE_WAREHOUSE = "warehouse";
    String MATERIAL_MANAGEMENT_YML_PATH = "/hvl-kovan-logistic/resources/configuration/modules/material-management-application.yml";
    String MATERIAL_MANAGEMENT_COMMON_PATH = "/hvl-kovan-logistic/modules/material-management/common/src/main/java";
    String MATERIAL_MANAGEMENT_COMMON_PACKAGE = "tr.com.havelsan.kovan.logistic.materialManagement.common";
    String MATERIAL_MANAGEMENT_SERVICE_PATH = "/hvl-kovan-logistic/modules/material-management/service/src/main/java";
    String MATERIAL_MANAGEMENT_SERVICE_PACKAGE = "tr.com.havelsan.kovan.logistic.materialManagement.service";
    String MATERIAL_MANAGEMENT_GROOVY_PATH = "/hvl-kovan-logistic/modules/material-management/service/src/main/resources/groovy";
    String MATERIAL_MANAGEMENT_GROOVY_PACKAGE = "tr.com.havelsan.kovan.logistic.materialManagement.service";
    String MATERIAL_MANAGEMENT_FRONTEND_PATH = "/hvl-kovan-ng/projects/logistic-material-management";
    String MATERIAL_MANAGEMENT_FRONTEND_SHARED_PATH = "/hvl-kovan-ng/projects/logistic-material-management-shared";
    String MATERIAL_MANAGEMENT_CONFIGURATION_CONSTANTS = "MaterialManagementConfigurationConstants";
    String MATERIAL_MANAGEMENT_MENU_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/material-management/service/src/main/resources/db/changelog/logistic/material.management/db.changelog-logistic-material-menu-v2.0.xml";
    String MATERIAL_MANAGEMENT_OAUTH_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/material-management/service/src/main/resources/db/changelog/logistic/material.management/db.changelog-logistic-material-oauth-v2.0.xml";
    String CONTROL_CLASS_MATERIAL_IDENTIFICATION_PATH = "CONTROL_CLASS_MATERIAL_IDENTIFICATION_PATH";
    String CONTROL_CLASS_PURCHASING_PATH = "CONTROL_CLASS_PURCHASING_PATH";
    String CONTROL_CLASS_STOCK_PATH = "CONTROL_CLASS_STOCK_PATH";

    String MAINTENANCE_MANAGEMENT_MICROSERVICE_NAME = "maintenanceManagement";
    String MAINTENANCE_MANAGEMENT_MODULE_CONFIGURATION_MANAGEMENT = "configurationManagement";
    String MAINTENANCE_MANAGEMENT_MODULE_ENGINEERING = "engineering";
    String MAINTENANCE_MANAGEMENT_MODULE_MAINTENANCE_ASSETS_MANAGEMENT = "maintenanceAssetsManagement";
    String MAINTENANCE_MANAGEMENT_MODULE_MAINTENANCE_REPAIR_APPLICATION = "maintenanceRepairApplication";
    String MAINTENANCE_MANAGEMENT_MODULE_PREVENTIVE_MAINTENANCE = "preventiveMaintenance";
    String MAINTENANCE_MANAGEMENT_YML_PATH = "/hvl-kovan-logistic/resources/configuration/modules/maintenance-management-application.yml";
    String MAINTENANCE_MANAGEMENT_COMMON_PATH = "/hvl-kovan-logistic/modules/maintenance-management/client/src/main/java";
    String MAINTENANCE_MANAGEMENT_COMMON_PACKAGE = "tr.com.havelsan.kovan.logistic.maintenanceManagement.client";
    String MAINTENANCE_MANAGEMENT_SERVICE_PATH = "/hvl-kovan-logistic/modules/maintenance-management/service/src/main/java";
    String MAINTENANCE_MANAGEMENT_SERVICE_PACKAGE = "tr.com.havelsan.kovan.logistic.maintenanceManagement.service";
    String MAINTENANCE_MANAGEMENT_GROOVY_PATH = "hvl-kovan-logistic/modules/maintenance-management/service/src/main/resources/groovy";
    String MAINTENANCE_MANAGEMENT_GROOVY_PACKAGE = "tr.com.havelsan.kovan.logistic.maintenanceManagement.service";
    String MAINTENANCE_MANAGEMENT_FRONTEND_PATH = "/hvl-kovan-ng/projects/logistic-maintenance-management";
    String MAINTENANCE_MANAGEMENT_FRONTEND_SHARED_PATH = "/hvl-kovan-ng/projects/logistic-maintenance-management-shared";
    String MAINTENANCE_MANAGEMENT_CONFIGURATION_CONSTANTS = "MaintenanceConfigurationConstants";
    String MAINTENANCE_MANAGEMENT_MENU_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/maintenance-management/service/src/main/resources/db/changelog/logistic/maintenance.management/db.changelog-logistic-maintenance-menu-v2.0.xml";
    String MAINTENANCE_MANAGEMENT_OAUTH_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/maintenance-management/service/src/main/resources/db/changelog/logistic/maintenance.management/db.changelog-logistic-maintenance-oauth-v2.0.xml";
    String CONTROL_CLASS_MAINTENANCE_ENGINEERING_PATH = "CONTROL_CLASS_MAINTENANCE_ENGINEERING_PATH";
    String CONTROL_CLASS_MAINTENANCE_ASSETS_MANAGEMENT_PATH = "CONTROL_CLASS_MAINTENANCE_ASSETS_MANAGEMENT_PATH";
    String CONTROL_CLASS_MAINTENANCE_REPAIR_APPLICATION_PATH = "CONTROL_CLASS_MAINTENANCE_REPAIR_APPLICATION_PATH";
    String CONTROL_CLASS_CONFIGURATION_MANAGEMENT_PATH = "CONTROL_CLASS_CONFIGURATION_MANAGEMENT_PATH";
    String CONTROL_CLASS_PREVENTIVE_MAINTENANCE_PATH = "CONTROL_CLASS_PREVENTIVE_MAINTENANCE_PATH";

    String PRODUCTION_MICROSERVICE_NAME = "production";
    String PRODUCTION_MODULE_CUSTOMISATION = "customisation";
    String PRODUCTION_YML_PATH = "/hvl-kovan-logistic/resources/configuration/modules/production-application.yml";
    String PRODUCTION_COMMON_PATH = "/hvl-kovan-logistic/modules/production/client/src/main/java";
    String PRODUCTION_COMMON_PACKAGE = "tr.com.havelsan.kovan.logistic.production.client";
    String PRODUCTION_SERVICE_PATH = "/hvl-kovan-logistic/modules/production/service/src/main/java";
    String PRODUCTION_SERVICE_PACKAGE = "tr.com.havelsan.kovan.logistic.production.service";
    String PRODUCTION_GROOVY_PATH = "hvl-kovan-logistic/modules/production/service/src/main/resources/groovy";
    String PRODUCTION_GROOVY_PACKAGE = "tr.com.havelsan.kovan.logistic.production.service";
    String PRODUCTION_FRONTEND_PATH = "/hvl-kovan-ng/projects/logistic-production";
    String PRODUCTION_FRONTEND_SHARED_PATH = "/hvl-kovan-ng/projects/logistic-production-shared";
    String PRODUCTION_CONFIGURATION_CONSTANTS = "ProductionConfigurationConstant";
    String PRODUCTION_MENU_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/production/service/src/main/resources/db/changelog/logistic/production/db.changelog-production-system-2.1.xml";
    String PRODUCTION_OAUTH_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/production/service/src/main/resources/db/changelog/logistic/production/db.changelog-production-oauth-2.1.xml";
    String CONTROL_CLASS_PRODUCTION_CUSTOMISATION_PATH = "CONTROL_CLASS_PRODUCTION_CUSTOMISATION_PATH";
    String CONTROL_CLASS_PRODUCTION_APPLICATION_PATH = "CONTROL_CLASS_PRODUCTION_APPLICATION_PATH";


    String QUALITY_MICROSERVICE_NAME = "quality";
    String QUALITY_MODULE_CUSTOMISATION = "customisation";
    String QUALITY_MODULE_APPLICATION = "application";
    String QUALITY_YML_PATH = "/hvl-kovan-logistic/resources/configuration/modules/quality-application.yml";
    String QUALITY_COMMON_PATH = "/hvl-kovan-logistic/modules/quality/client/src/main/java";
    String QUALITY_COMMON_PACKAGE = "tr.com.havelsan.kovan.logistic.quality.client";
    String QUALITY_SERVICE_PATH = "/hvl-kovan-logistic/modules/quality/service/src/main/java";
    String QUALITY_SERVICE_PACKAGE = "tr.com.havelsan.kovan.logistic.quality.service";
    String QUALITY_GROOVY_PATH = "hvl-kovan-logistic/modules/quality/service/src/main/resources/groovy";
    String QUALITY_GROOVY_PACKAGE = "tr.com.havelsan.kovan.logistic.quality.service";
    String QUALITY_FRONTEND_PATH = "/hvl-kovan-ng/projects/logistic-quality";
    String QUALITY_FRONTEND_SHARED_PATH = "/hvl-kovan-ng/projects/logistic-quality-shared";
    String QUALITY_CONFIGURATION_CONSTANTS = "QualityConfigurationConstant";
    String QUALITY_MENU_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/quality/service/src/main/resources/db/changelog/logistic/quality/2.1.0/db.changelog-quality-system-2.1.0.xml";
    String QUALITY_OAUTH_CHANGELOG_PATH = "/hvl-kovan-logistic/modules/quality/service/src/main/resources/db/changelog/logistic/quality/2.1.0/db.changelog-quality-oauth-2.1.0.xml";
    String CONTROL_CLASS_QUALITY_CUSTOMISATION_PATH = "CONTROL_CLASS_QUALITY_CUSTOMISATION_PATH";
    String CONTROL_CLASS_QUALITY_APPLICATION_PATH = "CONTROL_CLASS_QUALITY_APPLICATION_PATH";

    String i18n_TR_PATH = "/src/assets/i18n/tr";
    String i18n_EN_PATH = "/src/assets/i18n/en";
    String PUBLIC_API_TS = "/src/public.api.ts";
    String PUBLIC_API_TS2 = "/src/public-api.ts";
    String SRC_LIB = "/src/lib";

}
