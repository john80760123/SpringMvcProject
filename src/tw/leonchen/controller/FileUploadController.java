package tw.leonchen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;

@Controller
public class FileUploadController {
	@RequestMapping(path = "/uploadMainPage.controller", method = RequestMethod.GET)
	public String processMainPageAction() {
		return "uploadFile";
	}

	@RequestMapping(path = "/fileupload.controller", method = RequestMethod.POST)
	@ResponseBody
	public String processFileUploadAction(@RequestParam("myFiles") MultipartFile multipartFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println("fileName:" + fileName);

		String saveDirPath = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir\\";
		File savefileDir = new File(saveDirPath);
		savefileDir.mkdirs();

		File saveFilePath = new File(savefileDir, fileName);
		multipartFile.transferTo(saveFilePath);
		System.out.println("saveFilePath:" + saveFilePath);

		if (fileName != null && fileName.length() != 0) {
			String saveFilePathStr = saveDirPath + fileName;
			saveFile(fileName, saveFilePathStr);
		}

		return "Success";
	}

	@Autowired
	private PictureService pService;

	private void saveFile(String fileName, String path) throws IOException {
		Picture picture = new Picture();
		picture.setFilename(fileName);

		FileInputStream fis1 = new FileInputStream(path);
		byte[] b = new byte[fis1.available()];
		fis1.read(b);
		fis1.close();

		picture.setPicture(b);

		pService.insert(picture);
	}
}
