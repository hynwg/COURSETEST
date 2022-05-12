package com.course.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 把本地的路径暴露出去，配置静态资源
 * 访问 http://127.0.0.1:9003/file/f/teacher/xx-头像1.jsp
 * 相当于 本地 D:/file/imooc/teacher/xx-头像1.jsp
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    //把application的配置信息通过@value引入到变量中
    // private String FILE_PATH="D:/file/course/";
    @Value("${file.path}")
    private String FILE_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/f/**").addResourceLocations("file:D:/file/course/" );
        registry.addResourceHandler("/f/**").addResourceLocations("file:" + FILE_PATH);
    }
}
