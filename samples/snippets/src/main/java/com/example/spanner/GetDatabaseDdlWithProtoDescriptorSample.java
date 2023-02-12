/*
 * Copyright 2021 Google LLC
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

//[START spanner_get_database_ddl_with_proto_descriptor]

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.util.List;

public class GetDatabaseDdlWithProtoDescriptorSample {

    static void getDatabaseDdlWithProtoDescriptor() {
        // TODO(developer): Replace these variables before running the sample.
        final String projectId = "my-project";
        final String instanceId = "my-instance";
        final String databaseId = "my-database";
        getDatabaseDdlWithProtoDescriptor(projectId, instanceId, databaseId);
    }

    static void getDatabaseDdlWithProtoDescriptor(
            String projectId, String instanceId, String databaseId) {
        try (Spanner spanner = SpannerOptions
                .newBuilder()
                .setProjectId(projectId)
                .build()
                .getService()) {
            final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
            final GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(instanceId, databaseId);
            System.out.println("Retrieved database DDL for " + databaseId);
            for (String ddl : ddls) {
                System.out.println(ddl);
            }
            System.out.println(response.getProtoDescriptors())
        }
    }
}
//[END spanner_get_database_ddl_with_proto_descriptor]
