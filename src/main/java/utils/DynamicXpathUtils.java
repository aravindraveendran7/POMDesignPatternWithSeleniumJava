package utils;
public final class DynamicXpathUtils {
    private  DynamicXpathUtils(){}
    public static String constructXpath(String xpath,String replacingString){
        return String.format(xpath,replacingString);
    }
}
