/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_create_database_with_proto_descriptor]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.encryption.EncryptionConfigs;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateDatabaseWithEncryptionKey {

    static void createDatabaseWithEncryptionKey() {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "my-project";
        String instanceId = "my-instance";
        String databaseId = "my-database";
        String protoDescriptorFile = "com/example/spanner/descriptors.pb";

        try (Spanner spanner =
                     SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
            DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
            createDatabaseWithEncryptionKey(
                    adminClient,
                    projectId,
                    instanceId,
                    databaseId,
                    protoDescriptorFile);
        }
    }

    static void createDatabaseWithEncryptionKey(DatabaseAdminClient adminClient,
                                                String projectId, String instanceId, String databaseId, String protoDescriptorFile) {
        final Database databaseToCreate = adminClient
                .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
                .setProtoDescriptors(protoDescriptorFile)
                .build();
        final OperationFuture<Database, CreateDatabaseMetadata> operation = adminClient
                .createDatabase(databaseToCreate, Arrays.asList(
                        "CREATE PROTO BUNDLE ("
                                + "spanner.examples.music.SingerInfo,"
                                + "spanner.examples.music.Genre,"
                                + ")",
                        "CREATE TABLE Singers ("
                                + "  SingerId   INT64 NOT NULL,"
                                + "  FirstName  STRING(1024),"
                                + "  LastName   STRING(1024),"
                                + "  SingerInfo spanner.examples.music.SingerInfo,"
                                + "  SingerGenre spanner.examples.music.Genre,"
                                + "  ) PRIMARY KEY (SingerId)"
                ));
        try {
            System.out.println("Waiting for operation to complete...");
            Database createdDatabase = operation.get(120, TimeUnit.SECONDS);

            System.out.printf(
                    "Database %s created with proto descriptor %n",
                    createdDatabase.getId()
            );
        } catch (ExecutionException e) {
            // If the operation failed during execution, expose the cause.
            throw SpannerExceptionFactory.asSpannerException(e.getCause());
        } catch (InterruptedException e) {
            // Throw when a thread is waiting, sleeping, or otherwise occupied,
            // and the thread is interrupted, either before or during the activity.
            throw SpannerExceptionFactory.propagateInterrupt(e);
        } catch (TimeoutException e) {
            // If the operation timed out propagates the timeout
            throw SpannerExceptionFactory.propagateTimeout(e);
        }
    }
}
// [END spanner_create_database_with_proto_descriptor]
