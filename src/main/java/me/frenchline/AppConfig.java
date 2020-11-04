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
@ComponentScan(excludeFilters = @ComponentScan.Filter(Controller.class)) //컨텍스트의 계층 구조를 만들기 위해 부모 컨텍스트 설정 파일인 AppConfig의 빈등록 시 컨트롤러만 제외한다
public class AppConfig { //부모 애플리케이션 컨텍스트(Root WebApplicationContext)

}
