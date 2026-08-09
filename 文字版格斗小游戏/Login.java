package 文字版格斗小游戏;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login {
    //创建一个集合用来存储用户信息
    ArrayList< User> userList = new ArrayList<>();

    //定义一个变量表示当前用户登录错误几次
    int errorCount = 0;

    int choice;
    public Login() {
        //菜单界面
        init();


    }

    //界面初始化
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔════════════════════════════════╗");
        System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("请选择操作：1登录 2注册 3退出"+"   :");
        choice = sc.nextInt();
        //选择操作
        choice();
    }


    //进行选项操作
    public void choice() {
        if(choice == 1){
            if(userList.isEmpty()){
                System.out.println("请先注册用户");
                init();
            }else {
                System.out.println("开始登录，输入返回可回到主菜单");
                login();
            }

        }else if(choice == 2){
            System.out.println("开始注册，输入返回可回到主菜单");
            register();
        }else if(choice == 3){
            System.out.println("退出");
            System.exit(0);
        }else{
            System.out.println("输入错误,请重新输入");
            init();
        }
    }

    //注册操作
    public void register() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        //注册用户名
        setName(user);

        //注册密码
        setPassword(user);

        //随机生成一段字符作为该用户的id
        user.setID(getID());

        //将用户添加到集合中
        System.out.println("注册成功");
        userList.add(user);
        System.out.println("用户名："+user.getName()+"  密码："+user.getPassword()+"  ID："+user.getID());

        //返回主菜单
        init();

    }

    //1.注册密码
    public void setPassword(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入密码:");
        String password = sc.next();
        if(password.equals("返回")){
            System.out.println("返回主菜单");
            init();
        }
        if(password.length() < 3 || password.length() > 8){
            System.out.println("密码长度必须在3-8位之间");
            setPassword(user);
        }else if(!getClassCount1(password)){
            System.out.println("密码不能为纯数字");
            setPassword(user);
        }else if(!getClassCount2(password)){
            System.out.println("密码不能有字符");
            setPassword(user);
        }else if(!getClassCount(password)){
            System.out.println("密码不能为纯字母");
            setPassword(user);
        }else if(getClassCount(password)){
            System.out.print("请再次输入密码:");
            String passwordtwo = sc.next();
            if (passwordtwo.equals("返回")){
                System.out.println("返回主菜单");
                init();
            }
            if(password.equals(passwordtwo)){
                user.setPassword(password);
                return;
            }else {
                System.out.println("密码不一致，请重新输入");
                setPassword(user);
            }
        }
    }

    //2.注册用户名
    public void setName(User  user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
        if(username.equals("返回")){
            System.out.println("返回主菜单");
            init();
        }
        if(username.length() < 3 || username.length() > 16){
            System.out.println("用户名长度必须在3-16位之间");
            setName(user);
        }else if(!getClassCount1(username)){
            System.out.println("用户名不能全为数字");
            setName(user);
        }else if(!getClassCount2(username)){
            System.out.println("用户名有特殊字符");
            setName(user);
        }else {
            if(isRepeat(username)){
                user.setName(username);
                return;
            }else {
                System.out.println("用户名已存在，请重新输入");
                setName(user);
            }
        }
    }

    //3.判断用户名是否重复
    public boolean isRepeat(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getName().equals(username)){
                return false;
            }
        }
        return true;
    }

    //找到重复用户名所在集合的位置
    public int getIndex(String username) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getName().equals(username)){
                index = i;
            }
        }
        return index;
    }

    //4.随机生成id
    public String getID() {
        StringBuilder id = new StringBuilder("heima");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    //5.密码合格
    public boolean getClassCount(String str) {
        //定义一个变量，记录字符串中数字有几个
        int count = 0;
        //定义一个变量，记录字符串中字母有几个
        int count1 = 0;
        //定义一个变量，记录字符串中特殊字符有几个
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                count++;
            }else if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                count1++;
            }else{
                count2++;
            }
        }
        if(count > 0 && count1 > 0 && count2 == 0){
            return  true;
        }
        return false;
    }
    //6.用户名不合格
    public boolean getClassCount1(String str) {
        //定义一个变量，记录字符串中数字有几个
        int count = 0;
        int lengh = str.length();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                count++;
            }
        }
        if(count == lengh){
            return false;
        }
        return true;
    }

    //7.用户名有特殊字符
    public boolean getClassCount2(String str) {
        //定义一个变量，记录字符串中数字有几个
        int count = 0;
        //定义一个变量，记录字符串中字母有几个
        int count1 = 0;
        //定义一个变量，记录字符串中特殊字符有几个
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                count++;
            }else if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                count1++;
            }else{
                count2++;
            }
        }
        if(!(count2 == 0)){
            return  false;
        }
        return true;
    }



    //登陆操作
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
        if(username.equals("返回")){
            System.out.println("返回主菜单");
            init();
        }

        //登录用户名
        setUserName(username);

        //登录密码
        setPassword(username);

        //通过验证码
        VerifyCode();

        System.out.println();
        System.out.println();
        System.out.println();
        //进入游戏界面
        play Play = new play();
        Play.gamestart(username);
        System.out.println();
        System.out.println();
        System.out.println();

        //返回主菜单
        init();

    }

    //登录用户名
    public void setUserName(String username) {
        //判断用户名是否存在集合中
        boolean repeat = isRepeat(username);
        if(!repeat){
            if(userList.get(getIndex(username)).getStatus().equals("锁号")){
                System.out.println("该用户已被锁号，请联系管理员解除限制。");
                init();
            }
            else {
                return;
            }
        }else {
        System.out.println("用户名不存在,请重新输入");
        login();
        }
    }

    //登录密码
    public void setPassword(String username) {
        Scanner sc = new Scanner(System.in);
            System.out.print("请输入密码：");
            String password = sc.next();
            //定义一个变量表示该用户所对应的正确密码
            String rightPassword = userList.get(getIndex(username)).getPassword();
            if(password.equals(rightPassword)){
                System.out.println("密码正确");
                errorCount = 0;
            }else if(password.equals("返回")){
                System.out.println("返回主菜单");
                init();
            } else {
                errorCount++;
                if(errorCount == 3){
                    System.out.println("密码错误次数达到3次，请联系管理员解封账号");
                    userList.get(getIndex(username)).setStatus("锁号");
                    errorCount = 0;
                    //返回主菜单
                    init();
                }else {
                    System.out.println("密码错误，还剩下"+(3-errorCount)+"次机会");
                    setPassword(username);
                }
            }
    }



    //获取并用户输入的验证码
    public void VerifyCode(){
        Scanner sc = new Scanner(System.in);
        //返回系统

        //获取验证码
        String verifyCodeture = getVerifyCode();
        System.out.println("验证码:" + verifyCodeture);
        System.out.print("请输入验证码:");
        String verifyCode = sc.next();
        if(verifyCode.equalsIgnoreCase(verifyCodeture)){
            System.out.println("验证码正确,登陆成功");
            return;
        }else if (verifyCode.equals("返回")){
            System.out.println("返回主菜单");
            init();
        }
        else{
            System.out.println("验证码错误,请重新输入。");
            VerifyCode();
        }
    }

    //生成验证码
    public String getVerifyCode() {
        StringBuilder verifyCode = new StringBuilder();
        String[] chars ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            String c = chars[random.nextInt(chars.length)];
            verifyCode.append(c);
        }
        int b = random.nextInt(10);
        verifyCode.append(b);
        int i = random.nextInt(5);
        char c = verifyCode.charAt(4);
        verifyCode.setCharAt(4,verifyCode.charAt( i));
        verifyCode.setCharAt(i, (char) c);
        return verifyCode.toString();
    }
}
