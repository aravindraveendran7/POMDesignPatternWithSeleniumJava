package com.demo.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.demo.constants.FrameworkConstants;

public class ExtractDataFromExcel {

	@DataProvider(parallel=true)
	public Object[] getData() throws IOException {

		FileInputStream fil= new FileInputStream(FrameworkConstants.getTestDataPath());
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
		XSSFSheet worksheet=workbook.getSheet("Credentials");
		int rownum=worksheet.getLastRowNum();
		int colnum=worksheet.getRow(rownum).getLastCellNum();
		Object[] data=new Object[rownum];
		Map<String,String>map;
		for(int i=1;i<=rownum;i++) {
			map=new HashMap<String,String>();
			for(int j=0;j<colnum;j++) {
				String key=worksheet.getRow(0).getCell(j).getStringCellValue();
				String value=worksheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1]=map;
			}
		}
		return data;

	}

}
