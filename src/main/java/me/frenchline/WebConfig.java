package me.frenchline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-04
 */
@Configuration
@ComponentScan
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        //디폴트로 사용하는 뷰 리졸버인 InternalResourceViewResolver
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //그런데 설정을 조금 하면 viewName을 리턴하는 코드가 좀 더 간결해진다
        viewResolver.setPrefix("/WEB-INF/"); //view를 항상 WEB-INF 하위에 두겠다
        viewResolver.setSuffix(".jsp"); //view는 항상 다 .jsp로 끝난다
        return viewResolver;
    }

}
