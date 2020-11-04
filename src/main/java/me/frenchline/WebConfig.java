package me.frenchline;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-04
 */
@Configuration
@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class)) //디폴트 필터들을 사용하지 않고, 오직 컨트롤러만 빈으로 등록하겠다
public class WebConfig { //자식 애플리케이션 컨텍스트(Servlet WebApplicationContext)

}
