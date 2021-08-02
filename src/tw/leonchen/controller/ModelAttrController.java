package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"weather"})
public class ModelAttrController {
	
	@RequestMapping(path = "/modelattr.controller", method = RequestMethod.GET)
    public String processModelAttrAction(Model m) {
    	m.addAttribute("weather", "rainny");
    	return "/modelattrResult.controller";
    }
	
	@RequestMapping(path = "/modelattrResult.controller", method = RequestMethod.GET)
	public void processModelAttrResultAction(@ModelAttribute(name = "weather") String weatherStatus) {
		System.out.println("weatherStatus:" + weatherStatus);
	}
	
	@RequestMapping (path="/pathvaribleTest/{mid}",method = RequestMethod.GET)
	public void processPathVariableAction(@PathVariable("mid")String mid) {
		System.out.println("member id : "+mid);
	}
	
}