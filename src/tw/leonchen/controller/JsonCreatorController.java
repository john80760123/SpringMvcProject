package tw.leonchen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.model.House;

@Controller
public class JsonCreatorController {
    @RequestMapping(path = "/jsoncreation.controller", method = RequestMethod.GET)
    @ResponseBody
	public House processJsonAction() {
    	
       House hBean = new House();
       hBean.setHouseid(1001);
       hBean.setHousename("Pretty House");
       
       return hBean;
	}
    
    @RequestMapping(path = "/jsonarraycreation.controller", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<House> processJsonArrayAction(){
    	House hBean1 = new House();
        hBean1.setHouseid(1002);
        hBean1.setHousename("War House");
        
    	House hBean2 = new House();
        hBean2.setHouseid(1003);
        hBean2.setHousename("Sweet House");
        
        ArrayList<House> lists = new ArrayList<House>();
        lists.add(hBean1);
        lists.add(hBean2);
        
        return lists;
    }
}
