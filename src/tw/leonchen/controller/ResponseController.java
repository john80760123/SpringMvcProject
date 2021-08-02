package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ResponseController {

	@RequestMapping(path = "/response/messageBody.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processResponseBodyAction() {
		return "The Response Body Message";
	}

	@RequestMapping(path = "/response/messageBodyCharset.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processResponseBodyCharsetAction() {
		return "The Response Body Message:你好";
	}

	@RequestMapping(path = "/response/messageBodyCharset2.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processResponseBodyCharsetAction2() {
		return "The Response Body Message:你好";
	}

	@RequestMapping(path = "/response/responseEntity.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseEntityAction() {
		return new ResponseEntity<String>("403 Forbidden", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/responseImage.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void processResponseImageAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
		IOUtils.copy(in, response.getOutputStream());
	}
}
