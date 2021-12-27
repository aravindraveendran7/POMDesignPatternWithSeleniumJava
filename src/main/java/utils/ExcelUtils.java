package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ExcelUtils {
    private  ExcelUtils(){}
    public static List<Map<String,String>> getTestDetails(String sheetName)  {
        FileInputStream fileInputStream= null;
        List<Map<String,String>>list=null;
        try {
            fileInputStream = new FileInputStream(FrameworkConstants.getTestDataPath());
            XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet=workbook.getSheet(sheetName);
            Map<String,String>map=null;
            list =new ArrayList<>();
            int lastRowNumber=worksheet.getLastRowNum();
            int lastColumnNumber=worksheet.getRow(0).getLastCellNum();
            for (int i=1; i<=lastRowNumber;i++){
                map=new HashMap<>();
                for (int j=0;j<lastColumnNumber;j++){
                    String key=worksheet.getRow(0).getCell(j).getStringCellValue();
                    String value=worksheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
