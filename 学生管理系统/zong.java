package com.heima.学生管理系统;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class zong {
    //面板控制
    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<yonghu> list2 = new ArrayList<>();
        ArrayList<xuesheng> list = new ArrayList<>();
        while (true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录  2注册  3忘记密码  4退出程序");
            int choice = scanner.nextInt();
            if(choice == 1){
                if(login(list2)){
                    System.out.println("登录成功");
                    while (true) {
                        System.out.println("--------------------欢迎来到黑马学生管理系统-----------------------");
                        System.out.println("1.添加学生");
                        System.out.println("2.删除学生");
                        System.out.println("3.修改学生信息");
                        System.out.println("4.查询学生信息");
                        System.out.println("5.退出");
                        System.out.println("6.彻底退出");
                        System.out.println("请输入你的选择：");
                        int choice2 = scanner.nextInt();
                        scanner.nextLine();
                        //添加学生
                        if (choice2 == 1) {
                            addStudent(list);
                            continue;
                        }
                        //删除学生
                        if (choice2 == 2) {
                            System.out.println("请输入要删除的学生的id");
                            String id1 = scanner.next();
                            if (id1.equals("返回")) {
                                continue;
                            }
                            deleteStudent(id1, list);
                            continue;
                        }
                        //修改学生信息
                        if (choice2 == 3) {
                            System.out.println("请输入要修改的学生的id");
                            String id2 = scanner.next();
                            if (id2.equals("返回")) {
                                continue;
                            }
                            updateStudent(id2, list);
                            continue;
                        }
                        //查询学生
                        if (choice2 == 4) {
                            queryStudent(list);
                            continue;
                        }
                        //退出系统
                        if (choice2 == 5) {
                            System.out.println("已退出系统");
                            break;
                        }
                        //退出虚拟机
                        if (choice2 == 6){
                            System.out.println("已彻底退出系统");
                            System.exit(0);
                        }
                        else {
                            System.out.println("输入错误，请重新输入");
                        }
                    }
                }else{
                    System.out.println("登录失败");
                    continue;
                }
            }else if(choice == 2){
                register(list2);
                System.out.println("注册成功");
                System.out.println(list2);
                continue;
            }else if(choice == 3){
                huiyimima(list2);
            }else if(choice == 4){
                System.out.println("已退出程序");
                System.exit(0);
            }
        }

    }
    //登录功能
    static boolean login(ArrayList<yonghu> list2) {
        //三次机会
        int chance = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        if(isnameUnique(username,list2)){
            int idex = getnameIndex(username,list2);
            if(list2.get(idex).getMima().equals(password)){
                return true;
            }
        }*/
        while (true){
            //判断用户是否存在
            if(list2.size() == 0){
                System.out.println("当前无用户，请先注册");
                break;
            }
            //超过三次机会直接重新登录
            if(chance >= 3){
                System.out.println("您已输入错误超过三次，请重新登录");
                break;
            }
            //随机生成一个验证码
            String yanzhengma = yanzhengma();
            System.out.println("请输入验证码：" + yanzhengma);
            String inputYanzhengma = scanner.next();
            if(!inputYanzhengma.equals(yanzhengma)){
                if(chance == 2){
                    System.out.println("验证码错误");
                    chance++;
                    continue;
                }else {
                    System.out.println("验证码错误，请重新输入");
                    chance++;
                    continue;
                }
                /*System.out.println("验证码错误，请重新输入");
                chance++;
                continue;*/
            }else {
                System.out.println("验证码正确");
                System.out.println();
            }
            System.out.println("请输入用户名：");
            String username = scanner.next();
            System.out.println("请输入密码：");
            String password = scanner.next();
            if(isnameUnique(username,list2)){
                int idex = getnameIndex(username,list2);
                if(list2.get(idex).getMima().equals(password)){
                    return true;
                }else {
                    if(chance == 2){
                        System.out.println("密码错误");
                        chance++;
                        continue;
                    }else {
                        System.out.println("密码错误，请重新输入");
                        chance++;
                        continue;
                    }
                }
            }else {
                if(chance == 2){
                    System.out.println("用户名不存在");
                    chance++;
                    continue;
                }else {
                    System.out.println("用户名不存在，请重新输入");
                    chance++;
                    continue;
                }
            }
        }
        return false;
    }
    //注册功能
    static void register(ArrayList<yonghu> list2) {
        Scanner scanner = new Scanner(System.in);
        yonghu yonghu = new yonghu();
        while (true){
            System.out.println("请输入用户名：");
            String username = scanner.nextLine();
            boolean isUnique = isnameUnique(username,list2);
            if (isUnique){
                System.out.println("用户名已存在，请重新输入");
            }else if(username.length() < 3 || username.length() > 15){
                System.out.println("用户名长度不符合要求，请重新输入");
            }else if(!isNameNumeric(username)){
            }
            else {
                yonghu.setYonghuname(username);
                while (true){
                    System.out.println("请输入密码：");
                    String password = scanner.nextLine();
                    yonghu.setMima(password);
                    System.out.println("请确认密码：");
                    String confirmPassword = scanner.nextLine();
                    if(password.equals(confirmPassword)){
                        System.out.println("密码确认成功");
                        break;
                    }else {
                        System.out.println("密码确认失败，请重新输入");
                        continue;
                    }
                }
                while (true){
                    System.out.println("请输入身份证号：");
                    String shenfenzheng = scanner.nextLine();
                    if(shenfenzheng.length() == 18){
                        if(shenfenzheng.charAt(0) == '0'){
                            System.out.println("身份证号不能以0开头，请重新输入");
                            continue;
                        }
                        if(isIDNumeric(shenfenzheng)){
                            yonghu.setShenfenzheng(shenfenzheng);
                            System.out.println("身份证号输入成功");
                            break;
                        }else {
                            System.out.println("身份证号不能存在非数字，请重新输入");
                            continue;
                        }
                    }else {
                        System.out.println("身份证号长度不符合要求，请重新输入");
                    }
                }
                while (true){
                    System.out.println("请输入手机号码：");
                    String shoujihaoma = scanner.nextLine();
                    if(shoujihaoma.length() == 11){
                        if(shoujihaoma.charAt(0) == '0'){
                            System.out.println("手机号码不能以0开头，请重新输入");
                            continue;
                        }
                        if(isIDNumeric(shoujihaoma)){
                            yonghu.setShoujihaoma(shoujihaoma);
                            break;
                        }else {
                            System.out.println("手机号码不能有字母，请重新输入");
                            continue;
                        }
                    }else {
                        System.out.println("手机号码长度不符合要求，请重新输入");
                    }
                }
                break;
            }
        }
        list2.add(yonghu);
    }
    //忘记密码
    static void huiyimima(ArrayList<yonghu> list2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        if(isnameUnique(username,list2)){
            int idex = getnameIndex(username,list2);
            System.out.println("请输入当前用户的身份证号：");
            String shenfenzheng = scanner.nextLine();
            if(list2.get(idex).getShenfenzheng().equals(shenfenzheng)){
                System.out.println("请输入当前用户的手机号：");
                String shoujihaoma = scanner.nextLine();
                if(list2.get(idex).getShoujihaoma().equals(shoujihaoma)){
                    while (true) {
                        System.out.println("请输入新的密码：");
                        String mima = scanner.nextLine();
                        System.out.println("请输入确认密码：");
                        String confirmPassword = scanner.nextLine();
                        if (confirmPassword.equals(mima)) {
                            list2.get(idex).setMima(mima);
                            System.out.println("密码修改成功");
                            break;
                        } else {
                            System.out.println("两次密码不一致，请重新输入");
                        }
                    }
                }else {
                    System.out.println("手机号不匹配,修改密码失败");
                }
            }else {
                System.out.println("身份证号不匹配,修改密码失败");
            }
        }else {
            System.out.println("用户名不存在");
        }
    }
    //获取用户存在的索引
    static int getnameIndex(String yonghuname,ArrayList<yonghu> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            String yonghunameI =list.get(i).getYonghuname();
            if(yonghuname.equals(yonghunameI)){
                index = i;
            }
        }
        return index;
    }
    //判断用户名是否存在
    static boolean isnameUnique(String yonghuname,ArrayList<yonghu> list) {
        boolean isUnique = false;
        for (int i = 0; i < list.size(); i++) {
            String username =list.get(i).getYonghuname();
            if(username.equals(yonghuname)){
                isUnique = true;
            }
        }
        return isUnique;
    }
    //判断用户名是否为纯数字
    static boolean isNameNumeric(String yonghuname) {
        //定义一个变量记录几个数字
        int numericCount = 0;
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int otherCount = 0;
        for (int i = 0; i < yonghuname.length(); i++) {
            if(yonghuname.charAt(i) >= '0' && yonghuname.charAt(i) <= '9'){
                numericCount++;
            }else if(yonghuname.charAt(i) >= 'A' && yonghuname.charAt(i) <= 'Z'){
                uppercaseCount++;
            }else if(yonghuname.charAt(i) >= 'a' && yonghuname.charAt(i) <= 'z'){
                lowercaseCount++;
            }else {
                otherCount++;
            }

        }
        if(numericCount == yonghuname.length()){
            System.out.println("用户名不能为纯数字，请重新输入");
            return false;
        }
        if(otherCount > 0){
            System.out.println("用户名不能包含特殊字符，请重新输入");
            return false;
        }
        return true;
    }
    //判断身份证上是否为纯数字
    static boolean isIDNumeric(String shenfenzheng) {
        //定义一个变量记录几个数字
        int numericCount = 0;
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int otherCount = 0;
        for (int i = 0; i < shenfenzheng.length(); i++) {
            if(shenfenzheng.charAt(i) >= '0' && shenfenzheng.charAt(i) <= '9'){
                numericCount++;
            }
            else if(shenfenzheng.charAt(i) >= 'A' && shenfenzheng.charAt(i) <= 'Z'){
                uppercaseCount++;
            }else if(shenfenzheng.charAt(i) >= 'a' && shenfenzheng.charAt(i) <= 'z'){
                lowercaseCount++;
            }else {
                otherCount++;
            }

        }
        if(uppercaseCount > 0 || lowercaseCount > 0){
            return false;
        }
        if(otherCount > 0){
            return false;
        }
        return true;
    }
    //随机生成一个验证码，长度为5，四个字母一个数字
    static String yanzhengma() {
        Random random = new Random();
        String yanzhengma = "";
        String[] ku ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i = 0; i < 4; i++) {
            int index =random.nextInt(ku.length);
            yanzhengma = yanzhengma + ku[index];
        }
        int shuzi =random.nextInt(10);
        yanzhengma = yanzhengma + shuzi;
        char[] yanzhengmaArray = yanzhengma.toCharArray();
        for (int i = 0; i < yanzhengmaArray.length; i++) {
            int index =random.nextInt(yanzhengmaArray.length);
            char temp = yanzhengmaArray[i];
            yanzhengmaArray[i] = yanzhengmaArray[index];
            yanzhengmaArray[index] = temp;
        }
        String result = new String(yanzhengmaArray);
        return result;
    }
    //添加学生方法
    static ArrayList<xuesheng> addStudent(ArrayList<xuesheng> list) {
        xuesheng xs = new xuesheng();
        System.out.println("请输入要添加的学生的id");
        //判断id是否唯一
        while (true) {
            xs.setId();
            //判断id是否为返回
            if (xs.getId().equals("返回")) {
                return list;
            }
            boolean isUnique = isIdUnique(xs.getId(), list);
            if (isUnique) {
                System.out.println("id重复，请重新输入");
            } else {
                System.out.println("请输入添加学生姓名");
                xs.setName();
                if (xs.getName().equals("返回")) {
                    return list;
                }
                System.out.println("请输入添加学生年龄");
                xs.setAge();
                if (xs.getAge() == -1) {
                    return list;
                }
                System.out.println("请输入添加学生地址");
                xs.setZhuzhi();
                if (xs.getZhuzhi().equals("返回")) {
                    return list;
                }
                System.out.println("添加成功");
                list.add(xs);
                break;
            }
        }
        return list;
    }

    //删除学生
    static ArrayList<xuesheng> deleteStudent(String id, ArrayList<xuesheng> list) {
        boolean isDeleted = isIdUnique(id, list);
        if (isDeleted) {
            list.remove(getIdIndex(id, list));
            System.out.println("删除成功");
        } else {
            System.out.println("id不存在，删除失败");
        }
        return list;
    }

    //修改学生信息
    static ArrayList<xuesheng> updateStudent(String id, ArrayList<xuesheng> list) {
        boolean isUpdated = isIdUnique(id, list);
        if (isUpdated) {
            //要修改的学生信息所在的索引
            int index = getIdIndex(id, list);
            //修改学生学号
            System.out.println("请输入要修改的学生的学号，当前学号为" + list.get(index).getId());
            list.get(index).setId();
            //修改学生的姓名
            System.out.println("请输入要修改的学生的姓名，当前姓名为" + list.get(index).getName());
            list.get(index).setName();
            //修改学生的年龄
            System.out.println("请输入要修改的学生的年龄，当前年龄为" + list.get(index).getAge());
            list.get(index).setAge();
            //修改学生的地址
            System.out.println("请输入要修改的学生的地址，当前地址为" + list.get(index).getZhuzhi());
            list.get(index).setZhuzhi();
            //修改结束
            System.out.println("修改成功");
        } else {
            System.out.println("id不存在，修改失败");
        }
        return list;
    }

    //查询学生信息
    static void queryStudent(ArrayList<xuesheng> list) {
        if (list.size() == 0) {
            System.out.println("没有学生信息,请添加后再查询");
        } else {
            System.out.println("id" + query(14) + "姓名" + query(14) + "年龄" + query(14) + "地址");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId() + query(16 - (list.get(i).getId().length())) + list.get(i).getName() + query(16 - (list.get(i).getName().length())) + list.get(i).getAge() + query(16 - 2) + list.get(i).getZhuzhi());
            }
        }
    }


    //判断id是否唯一
    static boolean isIdUnique(String id, ArrayList<xuesheng> list) {
        boolean isUnique = false;
        for (int i = 0; i < list.size(); i++) {
            String idI = list.get(i).getId();
            if (id.equals(idI)) {
                isUnique = true;
            }
        }
        return isUnique;
    }

    //获取唯一的id索引
    static int getIdIndex(String id, ArrayList<xuesheng> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            String idI = list.get(i).getId();
            if (id.equals(idI)) {
                index = i;
            }
        }
        return index;
    }

    //查询对齐
    static String query(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + " ";
        }
        return str;
    }
    //反悔系统
    static boolean back(String choice) {
        if(choice.equals("返回")){
            return true;
        }
        return false;
    }
}

