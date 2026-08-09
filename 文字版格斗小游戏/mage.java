package 文字版格斗小游戏;

public class mage extends  character{
    public mage() {
    }

    public mage(String name, int hp, int ATK, int DEF) {
        super(name, hp, ATK, DEF);
    }

    //获取伤害
    @Override
    public int getattack(role enemy, int skill) {
        if(skill == 1){
            if( (getATK() - enemy.getDEF()) <= 0)
                return 1;
            return getATK() - enemy.getDEF();
        }else{
            if(((int) (getATK()*1.8 - enemy.getDEF())) <= 0){
                return 1;
            }
            return (int) (getATK()*1.8 - enemy.getDEF());
        }
    }


    //攻击
    @Override
    public void attack(role enemy, int damage) {
        if(damage == 1){
            int atk = getATK() - enemy.getDEF();
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F法师对你使用了普通攻击,造成了："+atk+ "点伤害");
        }else {
            int atk = (int) (getATK()*1.8 - enemy.getDEF());
            System.out.println("⚔\uFE0F法师对你使用了火球术,造成了："+atk+ "点伤害");
        }
    }


    //被攻击
    @Override
    public void beAttack(int damage) {
    }
}
