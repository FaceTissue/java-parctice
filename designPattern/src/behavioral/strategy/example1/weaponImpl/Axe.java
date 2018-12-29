package behavioral.strategy.example1.weaponImpl;

import behavioral.strategy.example1.Weapon;

public class Axe implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("fighting with axe");
    }
}
