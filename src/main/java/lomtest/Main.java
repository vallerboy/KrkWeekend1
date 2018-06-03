package lomtest;

import javafx.application.Platform;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        Player player = new Player.Builder("vallerboy")
                .attack(1203)
                .hp(1000000)
                .lvl(123)
                .build();

        System.out.println(player.getHp());
    }
}
