package me.frenchline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-04
 */
@Configuration
@ComponentScan(basePackages = { "me.frenchline" })
@EnableWebMvc //애노테이션 기반 스프링 MVC를 사용할 때 편리한 웹 MVC 기본 설정
public class WebConfig implements WebMvcConfigurer { //WebMvcConfigurer : @EnableWebMvc가 제공하는 빈을 커스터마이징할 수 있는 기능을 제공하는 인터페이스

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }




    /**
     * Spring MVC 테마 스위처(전환기) 구성
     */

    // 정적 리소스를 제공하기 때문에 ResourceHandler를 추가해야한다.
    // 이 리소스 핸들러는 테마 폴더의 정적 리소스를 처리한다. 선택적으로 이러한 리소스에 캐싱 규칙을 추가 할 수도 있다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/themes/**").addResourceLocations("/themes/");
    }

    // 다음으로 테마 찾기를 담당하는 ResourceBundleThemeSource를 등록한다.
    // basenamePrefix를 설정하여 테마에 접두사를 붙일 수 있다. 이름 뒤의 점은 이것이 디렉토리임을 나타낸다.
    @Bean
    public ResourceBundleThemeSource themeSource() {
        ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
        themeSource.setDefaultEncoding("UTF-8");
        themeSource.setBasenamePrefix("themes.");
        return themeSource;
    }

    // CookieThemeResolver는 쿠키를 사용하여 테마를 선택하고 기본 테마로 대체한다
    @Bean(name = "themeResolver") // DispatcherServlet.initStrategies > initThemeResolver
    public CookieThemeResolver themeResolver() {
        CookieThemeResolver resolver = new CookieThemeResolver();
        resolver.setDefaultThemeName("bright");
        resolver.setCookieName("my-theme-cookie"); //쿠키를 검사하면 현재 테마의 올바른 값으로 my-theme-cookie를 찾을 수 있다.
        return resolver;
    }

    //ThemeChangeInterceptor를 사용하면 구성 가능한 요청 매개 변수를 통해 모든 요청에서 현재 테마를 변경할 수 있다
    @Bean
    public ThemeChangeInterceptor themeChangeInterceptor() {
        ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();
        interceptor.setParamName("theme");
        return interceptor;
    }


    @Autowired
    AnnotationConfigWebApplicationContext context;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(themeChangeInterceptor());
        registry.addInterceptor(context.getBean(ThemeChangeInterceptor.class));
        registry.addInterceptor(new customLoggingInterceptor());
    }



}
