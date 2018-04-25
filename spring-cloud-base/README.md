# Spring Cloud
学习地址：http://edu.51cto.com/course/11321.html   

是一个工具箱  
基于SpringBoot，封装了Netflix的框架
将Netflix与Spring容器进行整合

## 整合的框架
Eureka:基于rest服务的分布式中间件，主要用于服务管理   
Hystrix:容错框架，通过添加延迟阀值以及容错的逻辑，来帮助我们控制
分布式系统间组建的交互   
Feign:一个rest客户端，目的是为了简化webService客户端   
Ribbon：负载均衡框架   
Zuul：为微服务集群提供代理、过滤、路由等功能    


## Spring Boot
auto-configuration: 自动配置    

starters: 主要用来简化依赖用的    

cli:  是 Spring Boot Commad Line 的缩写，是 Spring Boot 命令行工具  

Actator:是spring boot提供的对应用系统的自省和监控的集成功能，可以对应用系统进行配置查看、相关功能统计等
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
