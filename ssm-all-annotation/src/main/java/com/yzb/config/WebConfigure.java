package com.yzb.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yzb.controller")
public class WebConfigure implements WebMvcConfigurer {

    private static final Logger log = Logger.getLogger(WebConfigure.class);

    /*
     * <mvc:default-servlet-handle/>
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp();
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setSuffix(".jsp");
//        resolver.setOrder(1);//设置优先级
//        resolver.setCache(false);
//        return resolver;
//    }

}
