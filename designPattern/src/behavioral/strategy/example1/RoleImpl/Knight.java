package behavioral.strategy.example1.RoleImpl;

import behavioral.strategy.example1.Role;
import behavioral.strategy.example1.Weapon;
import behavioral.strategy.example1.weaponImpl.Sword;

public class Knight extends Role {
    public Knight() {
        this.weapon = new Sword();
    }

    @Override
    public void fight() {
        System.out.println("i'm Knight.i can fight");
        weapon.useWeapon();
    }
}
