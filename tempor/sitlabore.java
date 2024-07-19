import org.apache.kafka.clients.admin.Admin;

public class KafkaAdminExample {
    public static void main(String[] args) {
        // Create properties for the Admin client
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");

        // Create an instance of the Admin client
        Admin admin = Admin.create(properties);

        // Use the Admin client to perform administrative operations
        // For example, you can create a new topic
        NewTopic newTopic = new NewTopic("my-topic", 3, (short) 1);
        CreateTopicsResult createTopicsResult = admin.createTopics(Collections.singleton(newTopic));
        createTopicsResult.all().get();

        // Close the Admin client
        admin.close();
    }
}
