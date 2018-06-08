package com.kenfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo
 * @Description: 启动类
 *
 * @EnableSwagger2 表示开启Swagger
 *
 * @date 2018/5/12 上午2:07
 */
@SpringBootApplication
public class SpringbootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerApplication.class, args);
    }
}
