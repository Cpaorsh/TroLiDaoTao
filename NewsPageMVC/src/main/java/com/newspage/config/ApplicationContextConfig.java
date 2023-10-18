package com.newspage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan("com.newspage.*")

public class ApplicationContextConfig {

   // Không cần ViewResolver
 
 
 
   // Các khai báo khác nếu cần thiết ...
 
}
