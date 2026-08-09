package 文字版格斗小游戏;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class play {
    //创建角色
    role role = new role();
    //定义一个变量表示战斗的场数
    int round = 1;

    //创建一个集合存储敌方角色
    static ArrayList<character> enemyList = new ArrayList<>();
    static {
        enemyList.add(new warrior("初级战士",80,15,10));
        enemyList.add(new mage("神秘法师",70,25,8));
        enemyList.add(new cike("敏捷刺客",60,20,5));
        enemyList.add(new bigwarrior("重装战士",120,10,20));
    }





    public play(){
    }
    public void gamestart(String userName){
        role.setName(userName);
        //开始游戏
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("       \uD83C\uDFAE"+userName+"欢迎来到文字格斗游戏\uD83C\uDFAE       ");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("创建你的角色:");
        System.out.println("你的角色名为："+userName);
        System.out.println();

        //创建角色
        createRole();

        //开始战斗
        playstart();
    }

    //创建角色
    public void createRole(){
        Scanner sc = new Scanner(System.in);
        //定义一个变量为20，表示可分配的属性点
        int point = 20;
        System.out.println("请分配属性点(共20点)：");
        System.out.println("1. 生命值 (每点+10 HP)");
        System.out.println("2. 攻击力 (每点+2 ATK)");
        System.out.println("3. 防御力 (每点+1 DEF)");
        System.out.print("分配点数到 生命值 (剩余点数: "+point+"):");
        int hp = sc.nextInt();
        if(hp > point){
            System.out.println("分配点数错误！");
            System.out.println();
            createRole();
        }else {
            System.out.println("分配点数到 生命值 : "+hp);
            System.out.println();
        }
        int point1 = point - hp;
        if(point1 == 0){
            System.out.println("分配完成！");
            System.out.println();
            role.setHp(100 + hp*10);
            role.setATK(10);
            role.setDEF(0);
            role.setMaxhp(role.getHp());
            return;
        }
        System.out.print("分配点数到 攻击力 (剩余点数: "+(point-hp)+"):");
        int ATK = sc.nextInt();
        if (ATK > point1){
            System.out.println("分配点数错误！");
            createRole();
        }else {
            System.out.println("分配点数到 攻击力 : "+ATK);
            System.out.println();
        }
        int point2 = point1 - ATK;
        if(point2 == 0){
            System.out.println("分配完成！");
            role.setHp(100 + hp*10);
            role.setATK(10 + ATK*2);
            role.setDEF(0);
            role.setMaxhp(role.getHp());
            return;
        }
        int DEF =point-hp-ATK;
        System.out.println("分配点数到 防御力 : "+DEF);
        System.out.println();
        role.setHp(100 + hp*10);
        role.setATK(10 + ATK*2);
        role.setDEF(DEF);
        role.setMaxhp(role.getHp());
        System.out.println("角色创建成功!");
        System.out.println("\uD83C\uDF1F 初始属性  "+role.getName()+" [HP:" + role.getHp()+"/"+ role.getMaxhp() +", ATK:" + role.getATK()+", DEF:"+ role.getDEF() + "]");
        System.out.println("\uD83C\uDF1F 拥有技能:");
        System.out.println("一技能: "+role.skillList.get(0));
        System.out.println("二技能: "+role.skillList.get(1));
        System.out.println("三技能: "+role.skillList.get(2));
        System.out.println();
    }

    //开始游戏
    public void playstart(){
        //加载界面，选择对手
        Random random = new Random();
        int Choice = random.nextInt(4);
        choice(Choice);

        //一场战斗
        fight(Choice);

    }

    //选择对手
    public void choice(int  Choice){
            System.out.println("╔════════════════════════════════╗");
            System.out.println("⚔️ 第 "+round+" 场战斗开始！对手: "+enemyList.get(Choice).getName());
            System.out.println("---------------------------------------");
            //对对手的数值进行初始化
             enemyList.get(Choice).setMaxhp((enemyList.get(Choice).getMaxhp()+10*(round-1)));
             enemyList.get(Choice).setHp(enemyList.get(Choice).getMaxhp());
             enemyList.get(Choice).setATK((enemyList.get(Choice).getATK() + 3 *(round-1)));
             enemyList.get(Choice).setDEF((enemyList.get(Choice).getDEF() + 2 *(round-1)));
    }

    //一场战斗
    public void fight(int  Choice){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int nume = 1;
        while (true){
            System.out.println("⚔\uFE0F 第 "+nume+" 回合开始！ ");
            //打印我方状态
            System.out.println(role.getName() + ":");
            healthBar(role.getHp(),role.getMaxhp());
            System.out.println(" HP:" + role.getHp() + "/" + role.getMaxhp());
            //打印敌方状态
            System.out.println(enemyList.get(Choice).getName() + ":");
            healthBar(enemyList.get(Choice).getHp(),enemyList.get(Choice).getMaxhp());
            System.out.println(" HP:" + enemyList.get(Choice).getHp() + "/" + enemyList.get(Choice).getMaxhp());
            //回合开始
            System.out.println("===== 你的回合 =====");
            //选择
            System.out.println("1.普通攻击");
            System.out.println("2.强力一击(消耗10HP)");
            System.out.println("3.生命汲取(消耗10HP，恢复生命)");
            System.out.print("选择行动 (1-3):  ");
            int xuanze = sc.nextInt();
            choiceAttack(Choice,xuanze);
            //得到我方伤害
            int damage =getDamage(xuanze,Choice);
            if(Choice == 3){
                System.out.println("但因为重装战士进入了防御姿态！只造成了 " + damage/2 + "点伤害");
            }
            //扣除敌方状态
            enemyList.get(Choice).setHp(enemyList.get(Choice).getHp()-damage);
            //进行受击判定
            enemyList.get(Choice).beAttack(damage);

            //判断是否死亡，以及胜利后的后续
            if(enemyList.get(Choice).getHp() <= 0){
                int num = random.nextInt(21) + 20;
                enemyList.get(Choice).setHp(0);
                System.out.println("\uD83C\uDF89恭喜你，"+enemyList.get(Choice).getName()+"被打败了，你赢了！");
                System.out.println("\uD83C\uDFC6 当前胜场: "+  round);
                if(num+role.getHp() > role.getMaxhp()){
                    System.out.println("\uD83D\uDC9A你的生命已满！");
                    role.setHp(role.getMaxhp());
                }else {
                    System.out.println("\uD83D\uDC9A战斗结束，你恢复了" + num + "点生命");
                    role.setHp(role.getHp()+num);
                }
                //升级
                if(round %3 == 0){
                    System.out.println(role.getName() + "\uD83D\uDC9A升级了！属性获得了提升，血量回复了！");
                    role.setMaxhp(role.getMaxhp()+30);
                    role.setHp(role.getMaxhp());
                    role.setATK(role.getATK()+5);
                    role.setDEF(role.getDEF()+2);
                }
                //判断是否继续挑战
                System.out.println("═══════════════════════════════════════");
                System.out.println("是否继续挑战(Y/N)?");
                String choice = sc.next();
                if(choice.equalsIgnoreCase("Y")){
                    round++;
                    playstart();
                }else {
                    System.out.println("游戏结束！");
                    gamestart(role.getName());
                }
            }
            //对面回合开始
            int damagetest = random.nextInt(2);
            System.out.println("===== "+enemyList.get(Choice).getName()+"的回合 =====");
            enemyList.get(Choice).attack(role,damagetest);
            System.out.println();
            //获取伤害
            int getdamage =enemyList.get(Choice).getattack(role,damagetest);
            //减去我方状态
            role.setHp(role.getHp()-getdamage);
            //判断是否死亡
            if(role.getHp() <= 0){
                System.out.println("你被打败了，游戏结束！");
                System.out.println(enemyList.get( Choice).getName()+":你还得练！");
                System.out.println("返回主菜单！");
                gamestart(role.getName());
            }
            nume++;
        }

    }
    //表示血条
    public void healthBar(int hp,int maxhp){
        System.out.print("[");
        int num = hp / 10;
        int num1 = maxhp / 10;
        for (int i = 0; i < num1; i++) {
            if(i < num){
                System.out.print("█");
            }else {
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }
    //选择攻击方式
    public void choiceAttack(int Choice,int nume){
        if(nume == 1){
            role.attack(enemyList.get(Choice));
        }else if(nume == 2){
            role.attack1(enemyList.get(Choice));
        }else if(nume == 3){
            role.attack2(enemyList.get(Choice));
        }else {
            System.out.println("输入错误！请重新输入！");
            choiceAttack(Choice,nume);
        }
    }

    //返回伤害
    public int getDamage(int choice,int  Choice){
        if(choice == 1){
            return role.getATK() - enemyList.get(Choice).getDEF();
        }else if(choice == 2){
            return (int) (role.getATK()*1.8 - enemyList.get(Choice).getDEF());
        }else {
            return role.getATK() - enemyList.get(Choice).getDEF();
        }
    }
}
