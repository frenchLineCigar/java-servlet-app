package me.frenchline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-27
 */
public class customLoggingInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(customLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("[" + handler.getClass().getSimpleName() + "]");
        logger.info("[" + request.getMethod() + "]");
        logger.info("[" + request.getRequestURL() + "]");

        return true;
    }

}
