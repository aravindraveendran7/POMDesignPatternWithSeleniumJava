package utils;
import constants.FrameworkConstants;
import enums.ConfigProperties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
public final class  ReadPropertyFile {
    private ReadPropertyFile(){}
    private static Properties properties=new Properties();
    private static final Map<String,String> CONFIGMAP=new HashMap<>();
    static {
        try {
            FileInputStream fileInputStream=new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(fileInputStream);
            for(Map.Entry<Object,Object> entry:properties.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new Exception("Property file"+key+"is not found");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}