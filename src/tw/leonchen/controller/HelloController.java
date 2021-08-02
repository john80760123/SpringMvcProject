package tw.leonchen.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName = request.getParameter("userName");
		
		Map<String, String>errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);
		//shift+\=|
		if(userName==null|| userName.length()==0) {
			errors.put("username", "name is empty");
		}
		
		if(errors!=null && !errors.isEmpty()) {
//			return new ModelAndView("/form.jsp");
			return new ModelAndView("form");//設定resourceviewresoler後 裡面有+路徑跟.jsp了
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);
//		return new ModelAndView("/success.jsp");
		return new ModelAndView("success");//設定resourceviewresoler後 裡面有+路徑跟.jsp了
	}
}
