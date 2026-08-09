package 拼图小游戏;

import java.util.Random;

public class code {
    //定义为工具类
    private code(){}
    public static String code(){
        Random random = new Random();
        StringBuilder ma = new StringBuilder();
        String[] code = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(code.length);
            ma.append(code[index]);
        }
        int index = random.nextInt(10);
        ma.append( index);
        int x = random.nextInt(5);
        char a = ma.charAt(x);
        char b = ma.charAt(4);
        ma.setCharAt(x,b);
        ma.setCharAt(4,a);
        return ma.toString();
    }
}
