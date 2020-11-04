package me.frenchline;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-04
 *
 * DispatcherServlet의 기본 핸들러 맵핑 전략 중 BeanNameUrlHandlerMapping을 사용하는 방법
 * 핸들러 실행: SimpleControllerHandlerAdapter -> Controller 인터페이스를 구현해서 만든 핸들러를 실행하는 핸들러 어댑터
 */
@org.springframework.stereotype.Controller("/simple") //BeanNameUrl을 설정: /simple 이라는 요청을 처리하는 핸들러가 된다
public class SimpleController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("simple");
    }
}
