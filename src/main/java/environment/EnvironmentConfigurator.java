package environment;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.apache.log4j.Logger;
import utils.LoggerUtil;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class EnvironmentConfigurator {

    public static final String DEFAULT_TEST_ENVIRONMENT = "production";
    public static final boolean IS_PRODUCTION_ENV = EnvironmentConfigurator.getTestEnvironment().equalsIgnoreCase("production");
    public static final String DEFAULT_TEST_CLIENT = "gc";
    private static final Logger LOGGER = LoggerUtil.getInstance();
    private static volatile EnvironmentConfigurator environmentConfigurator;
    private static Properties properties = new Properties();

    private EnvironmentConfigurator() throws IOException {

        ConfigSlurper configSlurper = new ConfigSlurper();
        configSlurper.setEnvironment(getTestEnvironment());
        ConfigObject configObject = configSlurper.parse(new File("config.groovy").toURI().toURL());
        configObject.flatten();
        properties = configObject.toProperties();
    }

    public static EnvironmentConfigurator getInstance() {
        EnvironmentConfigurator sysProps = environmentConfigurator;
        if (sysProps == null) {
            synchronized (EnvironmentConfigurator.class) {
                sysProps = environmentConfigurator;
                if (sysProps == null) {
                    try {
                        environmentConfigurator = sysProps = new EnvironmentConfigurator();
                    } catch (IOException e) {
                        LOGGER.error("", e);
                    }
                }
            }
        }
        return sysProps;
    }

    public static String getTestEnvironment() {
        return getProperty("environment", DEFAULT_TEST_ENVIRONMENT);
    }

    public Boolean isGridUsed() {
        return Boolean.valueOf(getProperty("grid.isUsed", properties.getProperty("grid.isUsed")));
    }

    public String getSeleniumHub() {
        return properties.getProperty("grid.seleniumHub");
    }

    public Boolean isSafari() {
        return Boolean.valueOf(getTestClient().equalsIgnoreCase("sf"));
    }

    public Boolean isFirefox() {
        return Boolean.valueOf(getTestClient().equalsIgnoreCase("ff"));
    }

    public Boolean isInternetExplorer() {
        return Boolean.valueOf(getTestClient().equalsIgnoreCase("ie"));
    }

    public String getUserAdminLogin() {
        return properties.getProperty("users.user.login");
    }

    public String getUserAdminPassword() {
        return properties.getProperty("users.password");
    }


    public String getMySiteUrl() {
        return properties.getProperty("url");
    }

    public String getTestClient() {
        return getProperty("client", DEFAULT_TEST_CLIENT);
    }

    public String getBasicLoginForDevEnv() {
        return properties.getProperty("basic.login");
    }

    public String getBasicPasswordForDevEnv() {
        return properties.getProperty("basic.password");
    }

    public Boolean isProduction() {
        return Boolean.valueOf(System.getProperty("environment").equals("production"));
    }
}