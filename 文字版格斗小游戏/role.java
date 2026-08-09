package 文字版格斗小游戏;

import java.util.ArrayList;
import java.util.Random;

public class role {
    private String name;//名称
    private int hp;//生命
    private int ATK;//攻击
    private int DEF;//防御
    private int maxhp;

    //定于一一个集合表示角色的技能列表
    static ArrayList<String> skillList = new ArrayList<>();
    static {
        skillList.add("普通攻击	消耗:无	  造成基础伤害	标准攻击方式");
        skillList.add("强力一击  消耗:10HP  造成180%攻击力的伤害  高伤害但消耗生命");
        skillList.add("生命汲取	消耗:10HP  恢复0-20点生命值	风险回报型恢复技能");
    }


    public role() {
    }

    public role(int hp, int ATK, int DEF) {
        this.hp = hp;
        this.ATK = ATK;
        this.DEF = DEF;
        this.maxhp = hp;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * 设置
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * 获取
     * @return ATK
     */
    public int getATK() {
        return ATK;
    }

    /**
     * 设置
     * @param ATK
     */
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    /**
     * 获取
     * @return DEF
     */
    public int getDEF() {
        return DEF;
    }

    /**
     * 设置
     * @param DEF
     */
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public String toString() {
        return "role{name = " + name + ", hp = " + hp + ", ATK = " + ATK + ", DEF = " + DEF + "}";
    }

    //判断角色是否存活
    public boolean isLive(){
        return hp > 0;
    }

    //普通攻击方法
    public void attack(character  enemy){
        int damage = getATK() - enemy.getDEF();
        if(damage <= 0) damage = 1;
        System.out.println("\uD83D\uDCA5"+name+"使用普通攻击攻击了"+enemy.getName() + "对" + enemy.getName() + "造成了:" + damage +"伤害");
    }

    //一技能攻击方法
    public void attack1(character enemy){
        int damage = (int) (getATK()*1.8 - enemy.getDEF());
        if(damage <= 0) damage = 1;
        System.out.println("\uD83D\uDCA5"+name+"使用了强力一击攻击了"+enemy.getName() + "，对" + enemy.getName() + "造成了:" + damage +"伤害,自己失去了10生命");
        setHp(getHp()-10);
    }

    //二技能攻击方法
    public void attack2(character enemy){
        Random random = new Random();
        int huifuhp = random.nextInt(20)+1;
        int damage = getATK() - enemy.getDEF();
        if(damage <= 0) damage = 1;
        System.out.println("\uD83D\uDCA5"+name+"使用了生命汲取攻击了"+enemy.getName() + "，对" + enemy.getName() + "造成了:" + damage +"伤害,你失去了10点生命，吸取了恢复了"+huifuhp+"生命");
        if(getHp() - 10 +huifuhp > maxhp){
            setHp(maxhp);
        }else setHp(getHp() - 10 +huifuhp);
    }
}
