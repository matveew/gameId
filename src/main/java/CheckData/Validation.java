package CheckData;


public class Validation {

    public static boolean isInteger(String string){
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public static boolean isLess(int less, String str){
        if (less > str.length())
            return false;
        return true;
    }


    public static boolean isMax(int max, String str){
        if (max < str.length())
            return false;
        return true;
    }

}
