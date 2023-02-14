package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 내가 xml을 대신하는 설정 class파일
// <context:com.... base-pake="upload">
//@ComponentScan //현재 패키지를 배이스 페키지로 하겠다. 없어도 자동 포함
// 하지만 다른 패키지를 스캔하고 싶으면
@ComponentScan
@ComponentScan(basePackages = {"mybatis","board.spring.mybatis"})
@MapperScan(basePackages = {"mybatis","board.spring.mybatis"}) //@mapper을 읽어라
@ComponentScan(basePackages = "dbsecure")
public class SecondApplication {

	public static void main(String[] args) { //내장된 톰켓서버를 실행하는 메인
		//설정 안하면 포트번호 8080
		SpringApplication.run(SecondApplication.class, args);
	}

}
