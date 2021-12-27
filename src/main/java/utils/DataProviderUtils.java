package utils;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class DataProviderUtils {
    @DataProvider(parallel = true)
    public  static Object[] getData(Method m){
        String testName=m.getName();
        List<Map<String, String>> listOfDataTestSheet=ExcelUtils.getTestDetails("Data");
        List<Map<String,String>>listOfMatcherList=new ArrayList<>();
        for (int i=0;i<listOfDataTestSheet.size();i++){
            if (listOfDataTestSheet.get(i).get("TestMethodName").equalsIgnoreCase(testName)){
                if (listOfDataTestSheet.get(i).get("Execute").equalsIgnoreCase("yes")){
                    listOfMatcherList.add(listOfDataTestSheet.get(i));
                }
            }
        }

        return listOfMatcherList.toArray();
    }
}
