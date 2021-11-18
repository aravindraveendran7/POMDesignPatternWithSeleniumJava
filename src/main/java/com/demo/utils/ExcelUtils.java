package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demo.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {}
	
	public static List<Map<String,String>> getTestDetails() throws IOException{
		FileInputStream fil= new FileInputStream(FrameworkConstants.getTestDataPath());
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
		XSSFSheet worksheet=workbook.getSheet("RunManager");
		Map<String,String>map=null;
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		int lastRownum=worksheet.getLastRowNum();
		int lastColnum=worksheet.getRow(lastRownum).getLastCellNum();
		for(int i=1;i<=lastRownum;i++) {
			map=new HashMap<String,String>();
			for(int j=0;j<lastColnum;j++) {
				String key=worksheet.getRow(0).getCell(j).getStringCellValue();
				String value=worksheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
		
	}
	
	
}
