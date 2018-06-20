package com.bigdata.framework.configuration;

import com.bigdata.framework.web.util.HostUtils;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author yang
 * @ClassName: Swagger2
 * @Description:
 * @date 2018-06-08
 * @version:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createUserApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户API模块")
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                //.apis(RequestHandlerSelectors.basePackage("com.bigdata.user.controller"))
                .paths(userPaths())
                .build();
    }

    @Bean
    public Docket createWxUserApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("微信用户API模块")
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                //.apis(RequestHandlerSelectors.basePackage("com.bigdata.user.controller"))
                .paths(wxUserPaths())
                .build();
    }

    @Bean
    public Docket createQhbApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("抢红包API模块")
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                //.apis(RequestHandlerSelectors.basePackage("com.bigdata.user.controller"))
                .paths(qhbPaths())
                .build();
    }


    @Bean
    public Docket createSZBApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("收账宝API模块")
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                //.apis(RequestHandlerSelectors.basePackage("com.bigdata.szb.controller"))
                .paths(szbPaths())
                .build();
    }


    /*------------------------------------私有方法-------------------------------------------------------------------------------*/
    private Predicate<String> qhbPaths() {
        return regex(".*qhb.*");
    }
    private Predicate<String> userPaths() {
        return regex(".*user.*");
    }
    private Predicate<String> wxUserPaths() {
        return regex(".*wx.*");
    }
    private Predicate<String> szbPaths() {
        return regex(".*szb.*");
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 文档标题
                .title("收账宝Api文档")
                // 文档描述
                .description("")
                .termsOfServiceUrl("")
                .version("v1.0.0")
                .build();
    }
}
