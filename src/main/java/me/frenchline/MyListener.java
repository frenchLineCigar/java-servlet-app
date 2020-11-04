package me.frenchline;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-01
 * 서블릿 컨텍스트의 라이프 사이클을 감지할 수 있는 인터페이스를 구현하는 리스너 클래스
 */
public class MyListener implements ServletContextListener {

    /* 컨텍스트가 초기화 될 때 */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized");
        sce.getServletContext().setAttribute("name", "frenchline");
    }

    /* 컨텍스트가 종료 될 때 */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
    }
}

/*
서블릿 리스너
● 웹 애플리케이션에서 발생하는 주요 이벤트를 감지하고 각 이벤트에 특별한 작업이 필요한 경우에 사용할 수 있다.
    ○ `서블릿 컨텍스트 수준`의 이벤트 -> 현재 MyListener 에 해당
        ■ 컨텍스트 `라이프사이클` 이벤트
        ■ 컨텍스트 `애트리뷰트 변경` 이벤트

    리스너들은 여러 개의 서블릿이 공통적으로 사용하는 어떠한 객체들을 넣어놓는 경우 활용할 수 있다.
*/