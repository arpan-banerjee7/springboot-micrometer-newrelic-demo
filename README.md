# springboot-micrometer-newrelic-demo
Demo application to integrate New Relic with Spring Boot using micrometer

## Configuration using New Relic's Micrometer Dependency
### Steps-
1. Add this dependency
```
<dependency>
        <groupId>com.newrelic.telemetry</groupId>
        <artifactId>micrometer-registry-new-relic</artifactId>
        <version>0.7.0</version>
    </dependency>
 ```
 2. Modify the [MicrometerConfig.java](https://github.com/arpan-banerjee7/springboot-micrometer-newrelic-demo/tree/master/src/main/java/springboot/micrometer/demo/newrelic) class to add your API Key and Application name.
 3. Run the application.

### To view the Application metrics-
1. Log in to your New Relic account.
2. Go to Explorer Tab.
3. Click on Services-OpenTelemetry
4. You can see the name of your application(which you had mentioned in the MicrometerConfig file) listed there.
5. Click on the application name.
6. The dashboard should look somethin like this.

 ![image](https://user-images.githubusercontent.com/62155359/140727561-4809d9c3-f0ca-4c5b-862b-f3415995ab85.png)



## Configuration using Java Agent Provided By New Relic
### Steps-
1. Download the Java Agent from this URL- https://docs.newrelic.com/docs/release-notes/agent-release-notes/java-release-notes/
2. Extract it.
3. Modify the newrelic.yml file inside the extracted folder to inlcude your 
license_key:
app_name:
4. Create a SpringBoot application with some REST endpoints.
5. Build the application.
6. Navigate to the root path where you have extracted the newrelic java agent.
7. Enter this command
`java -javagent:<path to your new relic jar>\newrelic.jar -jar <path to your application jar>\<you rapplication jar name>.jar`

### To view the application metrics-
1. Log in to your New Relic account.
2. Go to Explorer Tab.
3. Click on Services-APM
4. You can see the name of your application(which you had mentioned in the newrelic.yml file) listed there.
5. Click on the application name.
6. The dashboard should look somethin like this.

![image](https://user-images.githubusercontent.com/62155359/140730061-24c8dc36-78cc-420b-9b4e-bccf524e5149.png)

