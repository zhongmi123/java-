package 文字版格斗小游戏;

public class warrior extends character{
    public warrior() {
    }

    public warrior(String name, int hp, int ATK, int DEF) {
        super(name, hp, ATK, DEF);
    }




    @Override
    public void attack(role  enemy, int damage) {
        if(damage == 1){
            int atk = getATK() - enemy.getDEF();
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F初级战士对你使用了普通攻击,造成了："+atk+ "点伤害");
        }else {
            int atk = (int) (getATK()*1.5 - enemy.getDEF());
            if(atk <= 0) atk = 1;
            System.out.println("⚔\uFE0F初级战士对你使用了猛击,造成了："+ atk + "点伤害");
        }
    }

    @Override
    public void beAttack(int damage) {
    }

    public String toString() {
        return "warrior{}";
    }


    //获取攻击
    @Override
    public int getattack(role enemy, int damage) {
        if(damage == 1){
            if( (getATK() - enemy.getDEF()) <= 0)
                return 1;
            return getATK() - enemy.getDEF();
        }else{
            if(((int) (getATK()*1.5 - enemy.getDEF())) <= 0){
                return 1;
            }
            return (int) (getATK()*1.5 - enemy.getDEF());
        }
    }
}
