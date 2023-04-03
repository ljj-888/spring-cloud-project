# 注册RestTemplate使用微服务

在application文件中把RestTemplate加入SpringBean工厂

springbean的注入只能放在配置类中，比如启动类，或者类上方有@Configuration注解的类。

在方法中使用RestTemplate，如果你使用的是GET就用GetForObject  如果是用POST就用PostForObject

| 方法           | 参数                           |
| -------------- | ------------------------------ |
| getForObject() | (url,responseType(返回值类型)) |



# Euraka框架

- EurekaServer ： 服务端，注册中心
  - 记录服务信息：每个服务者都会被Eureka所收录
  - 心跳监控：每隔30秒来的到服务者的状态
- EurekaClient：客户端
  - provider：服务提供者，列如案例中的user-service
    - 注册自己的信息到EurekaServer
    - 每隔30秒向EurekaServer发送心跳
  - consumer：服务消费者，列如案例中 的order-service
    - 根据服务名称从EurekaServer拉取服务列表
    - 基于服务列表做负载均衡，选中一个微服务后发起远程调用，在负载均衡中可以设置端口的优先级来确定谁可以先被调用。



# 搭建EurekaServer

- 创建项目，引入spring-cloud-starter-netflix-eureka-server的依赖

```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

- 编写启动类，添加@EnableEurekaServer注解
- 添加application.yml文件，编写下面的配置：

```
server:
	port: 10086
spring:
	application:
		name: eurekaserver
eureka:
	client:
		server-url:
			defaultZone: http://127.0.0.1:10086/eureka
```

