package tw.leonchen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration//我是組太java程式
//@EnableWebMvc //我是mvc
//@ComponentScan(basePackages= {"tw.leonchen"})
//我是mvc-servlet.xml的角色
public class SpringMVCJavaConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		
	}  
	
	@Bean
	public InternalResourceViewResolver viewResover() {
	InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
	viewresolver.setPrefix("/WEB-INF/pages/");
	viewresolver.setSuffix(".jsp");
	viewresolver.setOrder(6);
	return viewresolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
//		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
//		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
		//可設定多個
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "members");
		// 把原本的members路近改/也可以去
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}
	
}
