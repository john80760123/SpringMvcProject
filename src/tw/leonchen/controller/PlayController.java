package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller//我就Controller這裡是controller了就盡量避免用servlet方法
@SessionAttributes(names = {"player"})
//把player設成Session等級讓session也有值
public class PlayController {
	
	@RequestMapping(path="/play.controller",method = RequestMethod.GET)
	public String processAction(Model m) {//processAction只是個名子
		//request.setAttribute("player","DarkAngel");
		m.addAttribute("player","DarkAngel");
		
		return "/playResult.jsp";//導到這個jsp
	}
	
	@RequestMapping(path="/playclean.controller",method = RequestMethod.GET)
	public String processSessionClean(SessionStatus status) {
		status.setComplete();//去清除session資料 不然會一直保留下去
		return "/playResult.jsp";
	}
}
