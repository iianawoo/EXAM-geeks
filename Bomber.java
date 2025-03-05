package kg.geeks.game.players;

public class Bomber extends Hero {
    private static final int EXPLOSION_DAMAGE = 100;
    private Boss boss;

    public Bomber(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.EXPLOSION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.boss = boss; // cохраняем ссылку на босса
    }

    @Override
    public void setHealth(int health) {
        if (health <= 0 && this.getHealth() > 0 && boss != null) { 
            System.out.println(getName() + " взрывается и наносит " + EXPLOSION_DAMAGE + " урона боссу!");
            boss.setHealth(boss.getHealth() - EXPLOSION_DAMAGE);
        }
        super.setHealth(health);
    }
}

