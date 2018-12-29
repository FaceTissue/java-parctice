package behavioral.strategy.example1;

public abstract class Role {
    protected Weapon weapon;

    protected void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract void fight();
}
