# Spring boot multi module base project

##### Technology stack in project:

|Category        |Detail                         |Version                      |
|----------------|-------------------------------|-----------------------------|
|Java            |`JDK`                          |11                           |
|Build tool      |`apache-maven`                 |apache-maven-3.6.2           |
|Framework       |`Spring boot`                  |2.3.3.RELEASE      
|                |`Spring boot security`         |2.3.3.RELEASE  
|                |`mybatis-spring-boot`          |2.1.3                      |
|Database        |`postgresql`                   |12.1                         |
|Web server      |`Apache Tomcat Embedded`       |9.0.30                       |
|Other plugin    |`springfox-swagger`            |3.0.0                        |
|                |`Logback`                      |                             |
|                |`Lombok`                       |1.18.10    
|                |`Mybatis generate maven plugin`|1.4.0   
|                |`Mybatis schema migration maven plugin`|1.1.3  

### Module dependencies 
![Module dependencies](assets/images/rest-api-modules-dependencies.png?raw=true)

### DTO
![DTO](assets/images/DTO.png?raw=true)

##### How to call restful API

![DTO](assets/images/call-api.png?raw=true)

Note: Authorization, id_client: Get from Google Oauth2 service
Accept-Language: en, ja or null 

##### Config environment before deploy
- set "JAVA_OPTS=%JAVA_OPTS% -DLOG_PATH=YYY"
* YYY: Logging folder

##### GIT branching model
![DTO](assets/images/GIT.png?raw=true)





