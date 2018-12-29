package behavioral.strategy.example1.weaponImpl;

import behavioral.strategy.example1.Weapon;

public class Sword implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("fighting with sword");
    }
}
