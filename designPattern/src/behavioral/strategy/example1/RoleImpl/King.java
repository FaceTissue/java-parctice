package behavioral.strategy.example1.RoleImpl;

import behavioral.strategy.example1.Role;

public class King extends Role {
    @Override
    public void fight() {
        System.out.println("i'm King.I don't fight");
    }
}
