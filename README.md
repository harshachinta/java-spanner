This code shows how to use spanner as dependency and use it in our project. 
This code was written to share it to Htut to test the issue with accessing CMEK

Steps to run the code:
1. Run **_mvn clean install_** in the pom.xml directory
2. SpannerSample.java file is the main class. Run the main method to call createDatabase method.
3. In the createDatabase method, the current code works for single region CMEK.
4. To test multi region CMEK, uncomment the line
.setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(key1, key2))
and comment out .setEncryptionConfig(EncryptionConfigs.customerManagedEncryption(key1))
5. After this change we will get unimplemented error.