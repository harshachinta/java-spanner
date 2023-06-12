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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.ProtoDescriptorsFileConverter;
import com.google.common.io.ByteStreams;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProtoDescriptorsFileConverterTest {
  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(
            ProtoDescriptorsFileConverter.class, Dialect.GOOGLE_STANDARD_SQL);
    assertNotNull(allowedValues);
    ProtoDescriptorsFileConverter converter = new ProtoDescriptorsFileConverter(allowedValues);
    byte[] protoDescriptors;
    try {
      InputStream in =
          ProtoDescriptorsConverterTest.class
              .getClassLoader()
              .getResourceAsStream("com/google/cloud/spanner/descriptors.pb");
      assertNotNull(in);
      protoDescriptors = ByteStreams.toByteArray(in);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }

    assertNull(converter.convert(""));
    assertNull(converter.convert("null"));
    assertNull(converter.convert("random string"));
    assertNull(converter.convert("/descriptors.txt"));

    assertArrayEquals(
        converter.convert("src/test/resources/com/google/cloud/spanner/descriptors.pb"),
        protoDescriptors);
  }
}
