package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfliesController {
	
	@RequestMapping(path="/profilesMain.controller",method=RequestMethod.GET)
	public String processMainPage() {
		return "profiles";
	}
	
	@RequestMapping(path = "/profiles.controller", method = RequestMethod.GET)//GET蛤POST常JSPformよ猭ノぐ或
    public String processProfilesAction(@RequestParam(name = "userName") String userName, @RequestParam(name = "userAddress") String userAddress,
    		                            @RequestParam(name = "userPhone") String userPhone, Model m) {
		m.addAttribute("userName", userName);
		m.addAttribute("userAddress", userAddress);
		m.addAttribute("userPhone", userPhone);
		return "/profilesResult";
	}
	
	@RequestMapping(path = "/profiles2.controller", method = RequestMethod.POST)//GET蛤POST常JSPformよ猭ノぐ或
    public String processProfilesAction2(@RequestParam(name = "userName") String userName, @RequestParam(name = "userAddress") String userAddress,
    		                            @RequestParam(name = "userPhone") String userPhone, Model m) {
		m.addAttribute("userName", userName);
		m.addAttribute("userAddress", userAddress);
		m.addAttribute("userPhone", userPhone);
		return "/profilesResult";
	}
}
