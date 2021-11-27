package firsttheme;

import java.lang.reflect.Array;

public class PrefixFinder {

    public static String findAPrefix(String[] strings2) {
        String[] strings = new String[strings2.length];
        for(int i = 0; i < strings.length; i++) {
            strings[i] = strings2[i].toLowerCase();
        }
        if(strings.length == 0) {
            return "";
        }
        for(int i = 0; i < strings[0].length(); i++){
            char ch = strings[0].charAt(i);
            for(int j = 1; j < strings.length; j++) {
                if((i == strings[j].length()) || (strings[j].charAt(i) != ch)) {
                    return strings[0].substring(0,i);
                }
            }
        }
        return strings[0];
    }

    @Deprecated
    public static String findAPrefixOld(String[] strings) {
        if(strings.length == 0) {
            return "";
        }
        String result = strings[0].toLowerCase();
        if (strings.length == 1) {
            return result;
        }

        for(int i = 1; i < strings.length; i++) {
            while (strings[i].toLowerCase().indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if(result.equals("")) return result;
            }
        }
        return result;
    }

}
