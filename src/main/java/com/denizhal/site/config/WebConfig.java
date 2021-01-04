package com.denizhal.site.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MessageSource messageSource;


    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/haberler").setViewName("haberler");
        registry.addViewController("/admin").setViewName("admin/adminhome");
        registry.addViewController("/error").setViewName("error/");
        //registry.addViewController("/403").setViewName("403");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);

        return factory;
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path fileUploadDir = Paths.get("src/main/uploads");
        String fileUploadPath=fileUploadDir.toFile().getAbsolutePath();
        System.out.println("webconfig fileUploadPath : "+fileUploadPath);
        Path demoDir=Paths.get("src/main/uploads/demo");
        ///changed for linux
        registry.addResourceHandler("/src/main/uploads/**").addResourceLocations("file:///"+fileUploadPath+"/");
        registry.addResourceHandler("/src/main/uploads/demo/**").addResourceLocations("file:///"+demoDir+"/");

    }
}
