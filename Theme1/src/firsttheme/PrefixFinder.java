package firsttheme;

public class PrefixFinder {
    public static String findAPrefix(String[] strings) {
        if(strings.length == 0) return "";
        String result = strings[0];
        if (strings.length == 1) return result;

        for(int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if(result.equals("")) return result;
            }
        }
        return result;
    }
}
