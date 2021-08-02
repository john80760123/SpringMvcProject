package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller//�ڴNController�o�̬Ocontroller�F�N�ɶq�קK��servlet��k
@SessionAttributes(names = {"player"})
//��player�]��Session������session�]����
public class PlayController {
	
	@RequestMapping(path="/play.controller",method = RequestMethod.GET)
	public String processAction(Model m) {//processAction�u�O�ӦW�l
		//request.setAttribute("player","DarkAngel");
		m.addAttribute("player","DarkAngel");
		
		return "/playResult.jsp";//�ɨ�o��jsp
	}
	
	@RequestMapping(path="/playclean.controller",method = RequestMethod.GET)
	public String processSessionClean(SessionStatus status) {
		status.setComplete();//�h�M��session��� ���M�|�@���O�d�U�h
		return "/playResult.jsp";
	}
}
