package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leonchen.model.Members;

@Controller
public class MembersController {

	@RequestMapping(path = "/members", method = RequestMethod.GET)
	public String showForm(Model m) {
		Members members = new Members();
		m.addAttribute("members", members);
		return "members";
		
	}
	
	
	@RequestMapping(path = "/addMembers", method = RequestMethod.POST)
	public String processMembersAction(@ModelAttribute("members") Members members, BindingResult result, Model m) {
		if(result.hasErrors()) {
			return "membersError";
		}
		
		m.addAttribute("mName", members.getMemberName());
		m.addAttribute("mGender", members.getGender());
		m.addAttribute("mAge", members.getAge());
		
		return "membersResult";
	}
}
