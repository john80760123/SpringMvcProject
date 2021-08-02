package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.leonchen.model.Account;
import tw.leonchen.model.AccountDao;

@Controller
public class LoginSystemController {
    @Autowired
	private AccountDao accountDao;

	@RequestMapping(path = "/loginmainPage.controller", method = RequestMethod.GET)
	public String processLoginMainPage() {
		return "loginSystem";
	}
	
	@RequestMapping(path="/loginAccountCheck.controller",method=RequestMethod.POST)
	public String processAccountCheckAction(@RequestParam("userName") String user,@RequestParam("userPwd")String pwd,Model m ) {
		Map<String,String>errors=new HashMap<String,String>();
		m.addAttribute("errors",errors);
		
		if(user==null || user.length()==0) {
			errors.put("userName", "userName is required");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("userPwd", "Password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean checkStatus = accountDao.checkLogin(new Account(user, pwd));
		
		if(checkStatus) {
			m.addAttribute("user", user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}
		
		errors.put("msg", "please input correct username and password");
		return "loginSystem";
	}
}