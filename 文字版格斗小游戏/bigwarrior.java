package 文字版格斗小游戏;

public class bigwarrior extends character{
    private boolean buff = false;

    public bigwarrior() {
    }

    public bigwarrior(String name, int hp, int ATK, int DEF) {
        super(name, hp, ATK, DEF);
    }

    @Override
    public int getattack(role enemy, int damage) {
        if(damage == 1){
            if( (getATK() - enemy.getDEF()) <= 0)
                return 1;
            return getATK() - enemy.getDEF();
        }
        return 0;
    }

    @Override
    public void attack(role enemy, int damage) {
        if(damage == 1){
            int atk = getATK() - enemy.getDEF();
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F重装战士对你使用了普通攻击,造成了："+atk+ "点伤害");
        }else {
            System.out.println("\uD83C\uDF1F重装战士进入了防御姿态，下一回合受到伤害减半");
            buff = true;
        }
    }

    @Override
    public void beAttack(int damage) {
        if(buff){
            setHp(getHp() + damage/2);
        }
    }

}
