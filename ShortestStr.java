package codingpuzzle;

// given a string and array of unique characters, find the shortest substring that contain all the unique characters.
// EX: str="minasam" , unique=['a','n'] result= "na"
import java.util.Map;
import java.util.HashMap;

public class ShortestStr {

    public static String shortStr(String str, char[] uniq){
        String res = "";
        int uniqueLen = uniq.length;
        Map<Character,Integer> unmap = new HashMap<>();
        for (int i = 0; i < uniqueLen;++i){
            unmap.put(uniq[i], 0);
        }

        int j = 0;
        int uniqCount = 0;
        int lastProcessed = 0;
        int i = 0;
        while(i < str.length()){
            if (uniqCount ==uniqueLen){
                if (res.length() == 0 || res.length() > (lastProcessed -i+1)){
                    res = str.substring(i, lastProcessed+1);
                }
            }else{
                for (; j<str.length();++j){
                    if (unmap.containsKey(str.charAt(j))){

                        int charOccur = unmap.get(str.charAt(j));
                        unmap.put(str.charAt(j), charOccur + 1);
                        if (charOccur == 0){
                            uniqCount++;
                        }

                    }

                    if (uniqCount == uniqueLen ){
                        if (res.length() == 0 || res.length() > (j -i +1)){
                            res = str.substring(i, j+1);
                        }
                        lastProcessed = j;
                        ++j;
                        break;
                    }
                }
            }
            if ( (unmap.containsKey(str.charAt(i)))){
                if (unmap.get(str.charAt(i)) == 1)
                    uniqCount--;
                unmap.put(str.charAt(i), unmap.get(str.charAt(i)) - 1);
            }
            ++i;
        }


        return res;
    }


    public static void main(String[] args){
        String str = "xxyzzyzyyzxm";
        char[] uniq = new char[]{'x','y','z'};
        System.out.println(shortStr(str,uniq));
    }
}
