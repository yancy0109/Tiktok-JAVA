package com.tiktok.app.until;

public class IdUtil {
    public static Integer genId(String username){
        int maxlen = 8;
        int index = 1;
        int result = 0;
        char[] input = username.toCharArray();
        int len = username.length();
        for (int i = 0; i < (maxlen<len?maxlen:len); i++){
            result += (Math.abs((input[i]-'a'+1)%10)*index);
            index*=10;
        }
        return result;
    }
}
