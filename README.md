# _springBoot 基础配置学习项目_ 

- **springBoot 的配置基础配置项目**
- **基础**
- **项目构建**
- **运行原理**
- **web开发**
- **数据访问** 
- **企业级开发**
- **开发部署及测试**  
- **应用监控**

-------------------

## 基础

### 外部配置
### 日志配置
### Profile配置
### 运行原理

##项目构建

```
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.2.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

###Thymeleaf 

* 导入jar包

```
	<!-- thymeleaf -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
		<optional>true</optional>
	</dependency>
```
 

### webSocket


*  依赖：支持webSocket全双工

```
<!-- springboot websocket -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-websocket</artifactId>
		</dependency>
```

*   订阅--聊天

```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-websocket</artifactId>
	</dependency>
```


访问地址：http://localhost:8080/login 用户名/密码：sanduo/sanduo，lantian/lantian

**注意**聊天必须要@SendToUser("/queue/chat") 根据这个注解查到对应的返回，否则报错

```
    @MessageMapping("/chat")
    @SendToUser("/queue/chat") // 消息订阅
    public void handleChat(Principal principal, @Payload String message) {// principle为当前用户的信息
        if (principal.getName().equals("sanduo")) {// 相互发送消息代码
            messagingTemplate.convertAndSendToUser("lantian", "/queue/notifications",
                principal.getName() + "-send:" + message);// 向用户发送消息，第一个参数接受消息的用户，第二个订阅的地址，第三个消息本身
        } else {
            messagingTemplate.convertAndSendToUser("sanduo", "/queue/notifications",
                principal.getName() + "-send:" + message);
        }
    }
```
 
-------

###测试

*   创建Application.jar 启动类
*   编写测试类DemoController.jar
*	启动测试


## springboot + BootStrap + AngularJs (实战)


