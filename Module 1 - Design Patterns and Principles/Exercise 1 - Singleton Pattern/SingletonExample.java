class ConfigurationManager {

    // Single object creation
    private static ConfigurationManager instance;

    // Data members
    private String environment;
    private String version;

    // Private constructor
    private ConfigurationManager() {
        environment = "Development";
        version = "1.0";
    }

    // Singleton method
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void displayConfiguration() {
        System.out.println("Application Configuration");
        System.out.println("Environment : " + environment);
        System.out.println("Version     : " + version);
    }

    public void updateEnvironment(String env) {
        environment = env;
    }
}

public class SingletonExample {

    public static void main(String[] args) {

        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        config1.displayConfiguration();

        config1.updateEnvironment("Production");

        System.out.println();

        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        config2.displayConfiguration();

        if (config1 == config2) {
            System.out.println("\nSame instance reused");
        }
    }
}