package 拼图小游戏;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, MouseListener {
    Random random = new Random();
    //定义二维数组，保存图片的编号
    int[][] arr2 = new int[4][4];

    //定义图片的关键字
    String key = "animal";
    int type =random.nextInt(8)+1;

    //定义一个字符串，用于存储图片地址
    String path = "..\\pintuxiaoyouxi\\image\\"+key+"\\"+key + type+"\\";

    //定义一个二维数组，判断是否胜利
    int[][] win ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //定义一个变量表示记录移动了几次图片
    int step = 0;

    //创建选项中的条目
    JMenu changeItem = new JMenu("更换图片");//有后续条目，所以它是选项
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("zhongmi");

    //定义更换图片选项下的条目
    JMenuItem changeItem1 = new JMenuItem("美女");
    JMenuItem changeItem2 = new JMenuItem("动物");
    JMenuItem changeItem3 = new JMenuItem("运动");


    //进行界面设置
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //建立菜单
        initJmenuBar();

        //初始化数据,保存图片的编号(打乱图片)
        initData();

        //创建图片
        initImage();


        //显示
        this.setVisible(true);
    }

    //初始化数据（打乱数据）
    private void initData() {
        //生成一个一维数组，里面的元素是15以内的不重覆数字,包括0，在界面中，空白的位置为0
        int[] arr =new int[16];
        for (int i = 1; i < 16; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        //将一维数组转换成二维数组，二维数组中有四个元素，每个元素里存四个一维数组的数字
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                arr2[i][j] = arr[i * 4 + j];
            }
        }

    }

    //定义界面
    private void initJFrame() {
        //设置界面得到长和高
        this.setSize(603,680);
        //给界面命名
        this.setTitle("拼图游戏单机版");
        //设置界面永久置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消内部的默认位置放置
        this.setLayout(null);
        //键盘监听
        this.addKeyListener(this);

    }

    //创建菜单
    private void initJmenuBar(){
        //创建菜单
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单中的两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //建立联系
        functionJMenu.add(changeItem);//给选项添加选项
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //给更换图片条目添加图片类型的选择
        changeItem.add(changeItem1);
        changeItem.add(changeItem2);
        changeItem.add(changeItem3);

        //给条目绑定事件
        replayItem.addMouseListener(this);
        reLoginItem.addMouseListener(this);
        closeItem.addMouseListener(this);
        accountItem.addMouseListener(this);
        changeItem1.addMouseListener(this);
        changeItem2.addMouseListener(this);
        changeItem3.addMouseListener(this);

        //给菜单添加选项
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);



        //给界面设置菜单
        this.setJMenuBar(jMenuBar);


    }



    //创建图片
    private void initImage(){
        //清空 图片
        this.getContentPane().removeAll();

        //判断是否胜利，如果胜利就加载胜利图片
        if( Win()){
            //添加图片
            JLabel win = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\win.png"));
            win.setBounds(83,134,420,420);
            this.add(win);
        }

        //添加步数显示
        JLabel stepCount = new JLabel("步数："+this.step);
        stepCount.setBounds(50,30,100,20);
        this.add(stepCount);

        //添加拼图
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片管理器的对象，并创建一个图片对象放进管理器中
                JLabel JLabe = new JLabel(new ImageIcon(path+arr2[i][j]+".jpg"));
                //指定图片位置
                JLabe.setBounds(105 * j +83,105 * i + 134,105,105);
                //添加边框
                JLabe.setBorder(new BevelBorder(1));
                //将图片添加上去
                this.getContentPane().add(JLabe);
            }
        }

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("..\\pintuxiaoyouxi\\image\\background.png"));
        background.setBounds(40,40,508,560);
        this.add(background);

        //刷新界面
        this.repaint();
    }

    //键盘监听
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘按下
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            //清空 图片
            this.getContentPane().removeAll();
            //添加完整图片
            JLabel all = new JLabel(new ImageIcon( path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.add(all);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("..\\pintuxiaoyouxi\\image\\background.png"));
            background.setBounds(40,40,508,560);
            this.add(background);
            //刷新界面
            this.repaint();
        }

    }

    //键盘松开
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利
        if(Win()){
            return;
        }


        int code = e.getKeyCode();
        System.out.println();
        //向左移动
        if(code == 37){
            System.out.println("向左移动");
            for (int i = 0; i < 4; i++){
                boolean flag = false;
                for (int j = 0; j < 4; j++){
                    if(arr2[i][j] == 0){
                        if(j < 3){
                            arr2[i][j] = arr2[i][j + 1];
                            arr2[i][j + 1] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag)
                    break;
            }
            step++;
            initImage();
        }

        //如果键盘按下的键是向上键
        if(code == 38){
            System.out.println("向上移动");
            for (int i = 0; i < 4; i++){
                boolean flag = false;
                for (int j = 0; j < 4; j++){
                    if(arr2[i][j] == 0){
                        if(i < 3){
                            arr2[i][j] = arr2[i + 1][j];
                            arr2[i + 1][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag)
                    break;
        }
            step++;
            initImage();
        }

        //向右移动
        if(code == 39){
            System.out.println("向右移动");
            for (int i = 0; i < 4; i++){
                boolean flag = false;
                for (int j = 3; j >= 0; j--){
                    if(arr2[i][j] == 0){
                        if(j > 0){
                            arr2[i][j] = arr2[i][j - 1];
                            arr2[i][j - 1] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            step++;
            initImage();
        }

        //向下移动
        if(code == 40){
            System.out.println("向下移动");
            for (int i = 0; i < 4; i++){
                boolean flag = false;
                for (int j = 0; j < 4; j++){
                    if(arr2[i][j] == 0){
                        if(i > 0){
                            arr2[i][j] = arr2[i - 1][j];
                            arr2[i - 1][j] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag)
                    break;
            }
            step++;
            initImage();
        }

        //恢复图像
        if (code == 65){
            initImage();
        }

        //一键完成拼图
        if (code == 87){
            arr2= new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    //判断胜利
    public boolean Win() {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(win[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    //菜单栏监听实现

    //鼠标监听
    //鼠标点击事件
    @Override
    public void mouseClicked(MouseEvent e) {

    }


    //鼠标按下事件
    @Override
    public void mousePressed(MouseEvent e) {

    }

    //鼠标释放事件
    @Override
    public void mouseReleased(MouseEvent e) {
        Random r = new Random();
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");
            initData();
            step = 0;
            initImage();
        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前的界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("zhongmi");
            //创建一个弹框
            JDialog zhongmi = new JDialog();
            //创建一个图片管理器
            JLabel zhongmiLabel = new JLabel(new ImageIcon("C:\\Users\\86137\\IdeaProjects\\pintuxiaoyouxi\\image\\about.png"));
            zhongmiLabel.setBounds(0, 0, 258, 258);
            //将图片管理器放到弹框中
            zhongmi.add(zhongmiLabel);
            //设置弹框大小
            zhongmi.setSize(260, 260);
            //弹框置顶
            zhongmi.setAlwaysOnTop(true);
            //弹框居中
            zhongmi.setLocationRelativeTo(null);
            //弹框不关闭不能进行其他操作
            zhongmi.setModal(true);
            //显示弹框
            zhongmi.setVisible(true);
        } else if (obj == changeItem1) {
            System.out.println("切换美女图片拼图");
            //获取一个1到13的随机数
            int a = r.nextInt(13) + 1;
            type = a;
            key = "girl";
            path = "..\\pintuxiaoyouxi\\image\\" + key + "\\" + key + type + "\\";
            //重新游戏
            initData();
            step = 0;
            initImage();
        }else if (obj == changeItem2) {
            System.out.println("切换动物图片拼图");
            //获取一个1到8的随机数
            int a = r.nextInt(8) + 1;
            type = a;
            key = "animal";
            path = "..\\pintuxiaoyouxi\\image\\" + key + "\\" + key + type + "\\";
            //重新游戏
            initData();
            step = 0;
            initImage();
        }else if (obj == changeItem3) {
            System.out.println("切换运动图片拼图");
            //获取一个1到10的随机数;
            int a = r.nextInt(10) + 1;
            type = a;
            key = "sport";
            path = "..\\pintuxiaoyouxi\\image\\" + key + "\\" + key + type + "\\";
            //重新游戏
            initData();
            step = 0;
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
}
