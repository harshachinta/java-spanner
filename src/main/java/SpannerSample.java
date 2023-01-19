import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.*;
import com.google.cloud.spanner.encryption.EncryptionConfigs;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class SpannerSample {

    public static void main(String[] args) {
        SpannerOptions options = SpannerOptions.newBuilder()
                .setHost("https://staging-wrenchworks.sandbox.googleapis.com")
                .setProjectId("span-cloud-testing")
                .build();
        Spanner spanner = options.getService();
        String clientProject = spanner.getOptions().getProjectId();
        System.out.println(clientProject);

        DatabaseAdminClient dbAdminClient = spanner.getDatabaseAdminClient();
        createDatabase(dbAdminClient);
    }

    static void createDatabase(DatabaseAdminClient dbAdminClient) {
        String key1 = "projects/span-cloud-testing/locations/us-central1/keyRings/cmek_demo/cryptoKeys/test-key";
        String key2 = "projects/span-cloud-testing/locations/us-central1/keyRings/cmek_demo/cryptoKeys/apalicherla-test";
        final Database sourceDatabase =
                dbAdminClient
                        .newDatabaseBuilder(DatabaseId.of("span-cloud-testing", "spanner-testing-central1", "test_db_multi_cmek2"))
                        //.setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(key1, key2))
                        .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(key1))
                        .build();

        OperationFuture<Database, CreateDatabaseMetadata> createDatabaseOperation =
                dbAdminClient.createDatabase(
                        sourceDatabase,
                        Collections.singletonList(
                                "CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
        try {
            // Initiate the request which returns an OperationFuture.
            Database db = createDatabaseOperation.get();
            System.out.println("Created database [" + db.getId() + "]");
        } catch (ExecutionException e) {
            // If the operation failed during execution, expose the cause.
            throw (SpannerException) e.getCause();
        } catch (InterruptedException e) {
            // Throw when a thread is waiting, sleeping, or otherwise occupied,
            // and the thread is interrupted, either before or during the activity.
            throw SpannerExceptionFactory.propagateInterrupt(e);
        }
    }
}
