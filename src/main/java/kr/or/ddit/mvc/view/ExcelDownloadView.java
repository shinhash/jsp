package kr.or.ddit.mvc.view;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;


public class ExcelDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		// header와 data값을 model에서 가져오기
		List<String> header = (List<String>) model.get("header");
		List<Map<String, String>> data = (List<Map<String, String>>) model.get("data");
		
		// excel 파일 contentType : application/vnd.ms-excel; UTF-8
		response.setContentType("application/vnd.ms-excel; UTF-8");
		
		
		// 첨부파일임을 암시
		response.setHeader("Content-Disposition", "attachment; filename=test.xlsx");
		
		
		// poi 라이브러리를 이용하여 엑셀 파일을 생성
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("lineFriends");
		
		int rownum = 0;
		int columnum = 0;
		Row row = sheet.createRow(rownum++);
		
		// 헤더 설정
		for(String h : header) {
			row.createCell(columnum++).setCellValue(h);
		}
		
		
		// data 설정
		for(Map<String, String> map : data) {
			row = sheet.createRow(rownum++);
			
			columnum = 0;
			row.createCell(columnum++).setCellValue(map.get("userid"));
			row.createCell(columnum++).setCellValue(map.get("usernm"));
		}
		
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		
		os.flush();
		os.close();
		
		workbook.close();
	}
	
}
