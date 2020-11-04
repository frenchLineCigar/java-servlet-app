package me.frenchline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-04
 *
 *  DispatcherServlet의 기본 핸들러 맵핑 전략 중 RequestMappingHandlerMapping을 사용하는 방법
 *  핸들러 실행: RequestMappingHandlerAdapter -> 애노테이션 기반(@GetMapping 등)의 스프링 MVC 핸들러를 실행하는 핸들러 어댑터
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, " + helloService.getName();
    }

    @GetMapping("/sample")
    public String sample() {
        return "/WEB-INF/sample.jsp"; //ModelAndView [view="/WEB-INF/sample.jsp"; model={}]
    }
}
