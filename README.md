# Rest_Assured
Framework to test different API requests with TestNG using maven as build tool.

Build Tool:Maven
Reporting:com.aventstack

Base File has the request and response setup with required specifications.
Base URI and authorization token values are read from config.properties file.
TextFile property is to create text file with details of request and response values of the run request in the target folder.
Payloads are created in different formats using different methods in the request payloads package. In a similar manner patch request body is created with values mentioned in parameters.
All the tests for different request types are written in Tests package.
Utils package to read config values and get JSON values from response.
resources package has extent report setup.
XML files has the E2E test case from creating user to delete passing user ID between test cases using ItestContext.
Reports with current time stamp generated in reports folder in target.



