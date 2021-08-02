package tw.leonchen.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//�Ψӳ]�w�۷��web.xml��Java�{���պA���O
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //�Ψӳ]�w�۷��beans.config.xml��Java�{���պA���O
	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { RootAppConfig.class };
		return null;
	}

	@Override //�Ψӳ]�w�۷��mvc-servlet.xml��Java�{���պA���O
	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { SpringMVCJavaConfig.class };//�n���N�A��
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