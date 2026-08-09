package 拼图小游戏;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static 拼图小游戏.code.code;

public class LoginJFrame extends JFrame implements MouseListener {

    //创建一个集合，存储初始化的用户名和密码
    static ArrayList<User> list = new ArrayList<>();
    static{
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }


    //添加一个文本输入框，表示用户名
    JTextField usernameTest = new JTextField();
    //添加一个密文输入框，表示密码
    JPasswordField passwordTest = new JPasswordField();
    //添加一个文本输入框，表示验证码
    JTextField code = new JTextField();


    //创建登录按钮图像
    JButton login = new JButton();
    //创建注册按钮
    JButton register = new JButton();
    //添加一个按钮，表示切换验证码
    JButton changeCode = new JButton();

    //照片位置
    String loginpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\登录按钮.png";
    String registerpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\注册按钮.png";
//验证码
    String codeStr = code();
    JLabel rightCode = new JLabel();



    //进行界面初始化
    public LoginJFrame() {
        //初始化界面
        initJFrame();

        //添加图片
        initImage();

        //显示
        this.setVisible( true);
    }

    //初始化界面
    private void initJFrame(){
        //设置界面得到长和高
        this.setSize(488,430);
        //给界面命名
        this.setTitle("拼图 登录");
        //设置界面永久置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中
        this.setLayout(null);
        //添加按钮事件
        this.addMouseListener(this);
        register.addMouseListener(this);
        login.addMouseListener(this);
        changeCode.addMouseListener( this);
    }

    //添加图片
    private void initImage(){
        //清空图片
        this.getContentPane().removeAll();
        //添加用户名文字
        JLabel username = new JLabel(new  ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\用户名.png"));
        username.setBounds( 116, 135, 47, 17);
        this.add(username);

        //设置位置和宽高
        usernameTest.setBounds(195,134,200,30);
        //添加到界面
        this.add(usernameTest);

        //添加密码文字
        JLabel password = new JLabel(new  ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\密码.png"));
        password.setBounds( 130, 195, 32, 16);
        this.add(password);

        //设置位置和宽高
        passwordTest.setBounds(195,195,200,30);
        //添加到界面
        this.add(passwordTest);


        //添加验证码文字
        JLabel codeText = new JLabel(new  ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\验证码.png"));
        codeText.setBounds( 133, 256, 50, 30);
        this.add(codeText);

        //设置位置和宽高
        code.setBounds(195,256,100,30);
        //添加到界面
        this.add(code);

        //添加验证码正确输入
        //验证码
        rightCode.setText(codeStr);
        rightCode.setBounds( 300, 256, 50, 30);
        this.add(rightCode);
        changeCode.setBounds( 300, 256, 50, 30);
        //去除边框
        changeCode.setBorderPainted(false);
        //去除背景
        changeCode.setContentAreaFilled(false);
        this.add(changeCode);


        //添加登录按钮
        //JButton login = new JButton();
        login.setBounds( 123, 310, 128, 47);
        login.setIcon(new ImageIcon(loginpath));
        //去除边框
        login.setBorderPainted(false);
        //去除背景
        login.setContentAreaFilled(false);
        this.add(login);

        //添加注册按钮
        //JButton register = new JButton();
        register.setBounds( 256, 310, 128, 47);
        register.setIcon(new ImageIcon(registerpath));
        //去除边框
        register.setBorderPainted(false);
        //去除背景
        register.setContentAreaFilled(false);
        this.add(register);

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\background.png"));
        background.setBounds(0,0,470,390);
        this.add(background);


        //刷新界面
        this.repaint();

    }

    //展示弹框
    public void showJDialog(String content){
        //创建一个弹框
        JDialog jDialog = new JDialog();
        //设置弹框大小
        jDialog.setSize( 200, 150);
        //弹框置顶
        jDialog.setAlwaysOnTop(true);
        //弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永不进行下面的操作
        jDialog.setModal(true);

        //创建的对象管理用于存储文字到弹框中
        JLabel warning = new JLabel(content);
        warning.setBounds( 0, 0, 200, 150);
        jDialog.add(warning);

        //展示弹框
        jDialog.setVisible( true);
    }



    //鼠标点击事件
    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();

        if(obj == login){
            if(passwordTest.equals("") || usernameTest.equals("")){
                showJDialog("用户名或密码输入不能为空");
            }else if(code.getText().equalsIgnoreCase(codeStr)){
                if(check()){
                    //登录成功，并进入游戏
                    this.setVisible( false);
                    new GameJFrame();
                }else {
                    showJDialog("用户名或密码输入错误");
                    passwordTest.setText("");
                }
            }else {
                showJDialog("验证码输入错误");
                //清空输入框的数字
                code.setText("");
            }
        }else if(obj == register){
            //进入注册页面
            this.setVisible( false);
            new RegisterJRrame();
        }
    }


    //鼠标按下事件
    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == login){
            //替换图片
            loginpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\登录按下.png";
            initImage();
        }else if(obj == register){
            //替换图片
            registerpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\注册按下.png";
            initImage();
        }

    }


    //鼠标弹起事件
    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == login){
            //替换图片
            loginpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\登录按钮.png";
            initImage();
        }else if(obj == register){
            //替换图片
            registerpath = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\login\\注册按钮.png";
            initImage();
        }else if(obj == changeCode){
            codeStr = code();
            initImage();
        }
    }


    //鼠标进入事件
    @Override
    public void mouseEntered(MouseEvent e) {

    }


    //鼠标离开事件
    @Override
    public void mouseExited(MouseEvent e) {

    }


    //判断用户名是否对应集合中的用户名
    public boolean check(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(usernameTest.getText())){
                if(list.get(i).getPassword().equals(passwordTest.getText())){
                    return true;
                }
            }
        }
        return false;
    }
}
