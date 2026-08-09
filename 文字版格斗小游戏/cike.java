package 文字版格斗小游戏;

public class cike extends  character{


    public cike() {
    }

    public cike(String name, int hp, int ATK, int DEF) {
        super(name, hp, ATK, DEF);
    }

    @Override
    public int getattack(role enemy, int damage) {
        if(damage == 1){
            if( (getATK() - enemy.getDEF()) <= 0)
                return 1;
            return getATK() - enemy.getDEF();
        }else{
            if(( getATK()*2 - enemy.getDEF()) <= 0){
                return 1;
            }
            return (getATK()*2 - enemy.getDEF());
        }
    }

    @Override
    public void attack(role enemy, int damage) {
        if(damage == 1){
            int atk = getATK() - enemy.getDEF();
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F敏捷刺客对你使用了普通攻击,造成了："+atk+ "点伤害");
        }else {
            int atk =getATK()*2 - enemy.getDEF();
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F敏捷刺客对你使用了快速攻击,造成了："+ atk + "点伤害");
        }
    }

    @Override
    public void beAttack(int ATK) {

    }
}
