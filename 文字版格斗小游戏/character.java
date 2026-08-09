package 文字版格斗小游戏;

public abstract class character {
    private String name;
    private int hp;
    private int ATK;
    private int DEF;
    private int maxhp;


    public character() {
    }

    public character(String name, int hp, int ATK, int DEF) {
        this.name = name;
        this.hp = hp;
        this.ATK = ATK;
        this.DEF = DEF;
        this.maxhp = hp;
    }

    public int getMaxhp() {
        return maxhp;
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
        return "character{name = " + name + ", hp = " + hp + ", ATK = " + ATK + ", DEF = " + DEF + "}";
    }

    //获取攻击数值
    public abstract int getattack(role  enemy, int skill);

    //攻击方法，抽象方法
    public abstract void attack(role  enemy, int skill);

    //被攻击
    public abstract void beAttack(int damage);

    public boolean isLive(){
        return hp > 0;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }
}
