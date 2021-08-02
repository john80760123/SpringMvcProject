package tw.leonchen.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//用來設定相當於web.xml的Java程式組態類別
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //用來設定相當於beans.config.xml的Java程式組態類別
	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { RootAppConfig.class };
		return null;
	}

	@Override //用來設定相當於mvc-servlet.xml的Java程式組態類別
	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { SpringMVCJavaConfig.class };//要取代再用
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter};
	}
	
	

}