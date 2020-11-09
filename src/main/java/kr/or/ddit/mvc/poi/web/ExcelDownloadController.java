package kr.or.ddit.mvc.poi.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExcelDownloadController {

	
	@RequestMapping("/excelDown")
	public String excelDown(Model model) {
		
		
		// Model 객체에 header, data 주입
		List<String> header = new ArrayList<String>();
		header.add("userid");
		header.add("usernm");
		
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("userid", "brown");
		map1.put("usernm", "브라운");
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("userid", "sally");
		map2.put("usernm", "셀리");
		
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("userid", "boss");
		map3.put("usernm", "보스");
		
		
		data.add(map1);
		data.add(map2);
		data.add(map3);
		
		
		model.addAttribute("header", header);
		model.addAttribute("data", data);
		
		return "excelView";
	}
	
}
