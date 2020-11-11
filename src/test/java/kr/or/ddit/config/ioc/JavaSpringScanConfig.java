package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
//@ComponentScan(basePackages = {"kr.or.ddit"})
@ComponentScan(basePackages = {"kr.or.ddit.board"})
public class JavaSpringScanConfig {

	
	
}
