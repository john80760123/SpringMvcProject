package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyExceptionController {
	@RequestMapping(path = "/myexception.controller", method = RequestMethod.GET)
	public String processAction() throws Exception {
		throw new Exception();
		// �o��return�����n�F�]���o�H�X��
	}
}
