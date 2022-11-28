package tr.havelsan.kovan.apigen.constraint;

public final class ApiGenConstraint {

    private ApiGenConstraint() {
    }

    public static final String PACKAGE_CONSTRAINT = "constraint";
    public static final String PACKAGE_ENTITY = "entity";
    public static final String PACKAGE_ENTITY_QUERY = "entity.query";
    public static final String PACKAGE_MODEL = "model";
    public static final String PACKAGE_GENERATOR = "generator";
    public static final String PACKAGE_REPOSITORY = "repository";
    public static final String PACKAGE_CONVERTER = "converter";
    public static final String PACKAGE_RULE = "rule";
    public static final String PACKAGE_SERVICE = "service";
    public static final String PACKAGE_CONTROLLER = "controller";

    public static final String END_FIX_CONSTRAINT = "Constraint";
    public static final String END_FIX_ENTITY = "Entity";
    public static final String END_FIX_ENTITY_QUERY = "EntityQuery";
    public static final String END_FIX_DEF_ENTITY = "DefEntity";
    public static final String END_FIX_DEF_ENTITY_QUERY = "DefEntityQuery";
    public static final String END_FIX_MODEL = "Model";
    public static final String END_FIX_QUERY_MODEL = "QueryModel";
    public static final String END_FIX_QUERY_GENERATOR = "QueryGenerator";
    public static final String END_FIX_REPOSITORY = "Repository";
    public static final String END_FIX_CONVERTER = "Converter";
    public static final String END_FIX_CONVERTER_IMPL = "ConverterImpl";
    public static final String END_FIX_BASIC_CONVERTER = "BasicConverter";
    public static final String END_FIX_BASIC_CONVERTER_IMPL = "BasicConverterImpl";
    public static final String END_FIX_SERVICE = "Service";
    public static final String END_FIX_SERVICE_IMPL = "ServiceImpl";
    public static final String END_FIX_RULE_SERVICE = "RuleService";
    public static final String END_FIX_PUBLIC_REST_SERVICE = "PublicRestService";
    public static final String END_FIX_PRIVATE_REST_SERVICE = "PrivateRestService";
    public static final String END_FIX_REST_CONTROLLER = "RestController";
    public static final String END_FIX_RULES = "Rules";

    public static final String FILE_JAVA = ".java";
    public static final String FILE_GROOVY = ".groovy";
    public static final String FILE_TYPE_SCRIPT = ".ts";
    public static final String FILE_JSON = ".json";

    public static final String ENV_COMMON_PATH = "common.path";
    public static final String ENV_SERVICE_PATH = "service.path";
    public static final String ENV_GROOVY_PATH = "groovy.path";
    public static final String ENV_FRONTEND_PATH = "frontend.path";


    public static final String API_GEN = "/api-gen";
    public static final String API_GENERATE = "/generate";
    public static final String API_SAY_MY_NAME = "/sayMyName";
    public static final String API_CLONE_BASIC_CONVERTER = "/cloneBasicConverter";
    public static final String API_COPY_BACK_END = "/copyBackEnd";
    public static final String API_COPY_FRONT_END = "/copyFrontEnd";
    public static final String API_GENERATE_ENUM = "/generate-enum";
}
