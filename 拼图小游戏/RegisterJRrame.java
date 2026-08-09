package 拼图小游戏;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RegisterJRrame extends JFrame implements MouseListener {
    //创建一个集合，存储初始化的用户名和密码
    static ArrayList<User> list = new ArrayList<>();
    static{
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }

    //定义一个字符串表示注册的图片地址
    String registerImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\注册按钮.png";
    //定义一个字符串表示重置的图片地址
    String resetImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\重置按钮.png";

    //添加注册用户名输入框
    JTextField registerName = new JTextField();
    //添加注册密码输入框
    JPasswordField registerPassword = new JPasswordField();
    //添加再次输入密码输入框
    JPasswordField registerPasswordAgain = new JPasswordField();
    //添加一个按钮表示重置
    JButton resetann = new JButton();
    //添加一个按钮表示注册
    JButton registerann = new JButton();
    //添加一个按钮表示返回
    JButton back = new JButton();

    //进行界面初始化
    public RegisterJRrame() {
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
        this.setTitle("拼图 注册");
        //设置界面永久置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //关闭默认居中
        this.setLayout(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //添加按钮事件
        this.addMouseListener(this);
        registerann.addMouseListener(this);
        resetann.addMouseListener(this);
        back.addMouseListener(this);

    }

    //添加图片
    private void initImage(){
        //清空图片
        this.getContentPane().removeAll();

        //添加注册用户名图片
        JLabel register = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\注册用户名.png"));
        register.setBounds(100, 100, 79, 17);
        this.add(register);
        //添加注册用户名输入框
        registerName.setBounds( 200, 100, 200, 30);
        this.add(registerName);

        //添加注册密码图片
        JLabel password = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\注册密码.png"));
        password.setBounds( 100, 170, 79, 17);
        this.add(password);
        //添加注册密码输入框
        registerPassword.setBounds( 200, 170, 200, 30);
        this.add(registerPassword);

        //添加再次输入密码图片
        JLabel passwordAgain = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\再次输入密码.png"));
        passwordAgain.setBounds( 80, 240, 100, 17);
        this.add(passwordAgain);
        //添加再次输入密码输入框
        registerPasswordAgain.setBounds( 200, 240, 200, 30);
        this.add(registerPasswordAgain);

        //添加注册按钮
        registerann.setBounds( 123, 310, 128, 47);
        registerann.setIcon(new ImageIcon(registerImage));
        //去除边框
        registerann.setBorderPainted(false);
        //去除背景
        registerann.setContentAreaFilled(false);
        this.add(registerann);

        //添加重置按钮
        resetann.setBounds( 256, 310, 128, 47);
        resetann.setIcon(new ImageIcon(resetImage));
        //去除边框
        resetann.setBorderPainted(false);
        //去除背景
        resetann.setContentAreaFilled(false);
        this.add(resetann);

        //添加返回按钮
        back.setBounds( 10, 310, 128, 47);
        back.setIcon(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\damie.jpg"));
        //去除边框
        back.setBorderPainted(false);
        //去除背景
        back.setContentAreaFilled(false);
        this.add(back);

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\background.png"));
        background.setBounds(0,0,470,390);
        this.add(background);

        //刷新界面
        this.repaint();
    }


    //弹框
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
        if(obj ==registerann){
            if(registerName.getText().length() == 0 || registerPassword.getText().length() == 0 || registerPasswordAgain.getText().length() == 0){
                showJDialog("请输入用户名和密码");
                return;
            }
            if(check()){
                if(registerPassword.getText().equals(registerPasswordAgain.getText())){
                    list.add(new User(registerName.getText(),registerPassword.getText()));
                    showJDialog("注册成功");
                    //跳转登录界面
                    this.setVisible(false);
                    new LoginJFrame();
                }else {
                    showJDialog("密码不一致");
                }
            }else {
                showJDialog("用户名已存在");
                return;
            }
        }else if(obj ==resetann){
            registerName.setText("");
            registerPassword.setText("");
            registerPasswordAgain.setText("");
        }else if(obj ==back){
            this.setVisible(false);
            new LoginJFrame();
        }
    }


    //鼠标按下事件
    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj ==registerann){
            registerImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\注册按下.png";
            initImage();
        }else if(obj ==resetann){
            resetImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\重置按下.png";
            initImage();
        }

    }


    //鼠标释放事件
    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if(obj ==registerann){
            registerImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\注册按钮.png";
            initImage();
        }else if(obj ==resetann){
            resetImage = "C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\register\\重置按钮.png";
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

    //检测是否注册到了重复的用户名
    public boolean check(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(registerName.getText())){
                return false;
            }
        }
        return true;
    }
}
