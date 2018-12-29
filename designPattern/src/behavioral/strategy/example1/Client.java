package behavioral.strategy.example1;

import behavioral.strategy.example1.RoleImpl.King;
import behavioral.strategy.example1.RoleImpl.Knight;
import behavioral.strategy.example1.weaponImpl.Axe;

public class Client {
    public static void main(String[] args) {
        Role role = new Knight();
        role.fight();
        role.setWeapon(new Axe());
        role.fight();

        role = new King();
        role.fight();
    }
}
