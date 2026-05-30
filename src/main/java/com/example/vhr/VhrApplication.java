package com.example.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.vhr.mapper") //去这个包里找所有 Mapper 接口，自动生成代理对象并交给 Spring 管理，这样你才能在 Service 里 @Autowired 注入 Mapper
public class VhrApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrApplication.class, args);
	}

}
