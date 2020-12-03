package me.frenchline;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-05
 */
public class WebApplication implements WebApplicationInitializer {

    /**
     * 자바 코드로 서블릿 등록 및 초기화
     * (web.xml을 사용하지 않고, WebApplicationInitializer를 구현한 클래스에 DispatcherServlet 등록하는 방법)
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException { //onStartup 메서드 블록 내에서 서블릿을 만들어서 등록한다
        // 1.Applcation Context 만들기
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext); // @EnableWebMvc 사용 시 Application Context에 Servlet Context를 설정해야 한다
        context.register(WebConfig.class); //빈 설정 파일 등록 : 설정으로 사용할 클래스를 빈으로 등록
        context.refresh(); //이 Applcation Context 를 갱신

        // 2. DispatcherServlet 만들기
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context); //DispatcherServlet를 만들때 Application Context를 준다
        // 3. DispatcherServlet 등록
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);//서블릿 이름(servletName)을 반드시 줘야 나중에 필터(Filter) 등록 시에 특정 서블릿 이름에 필터를 걸 수도 있는 거니까
        app.addMapping("/app/*"); //서블릿 맵핑 : /app/ 이하의 모든 요청을 다 DispatcherServlet이 받도록 맵핑

    }
}
