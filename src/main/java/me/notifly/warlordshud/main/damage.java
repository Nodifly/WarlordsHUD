package me.notifly.warlordshud.main;

/***
 * Created by Dan on 29/03/2017.
 */

public class damage {

    public static Integer damageCalc(String message) {

        Integer damage = 0;

        if (!message.contains(" critical ")) {
            String endOfMsg = message.substring(message.length() - 12, (message.length()));
            if (Character.isDigit(endOfMsg.charAt(0))) { // damage > 1000
                damage = Integer.parseInt(endOfMsg.substring(0, 4));
            }

            if (Character.isWhitespace(endOfMsg.charAt(0))) { // damage >= 100, damage < 1000
                damage = Integer.parseInt(endOfMsg.substring(1, 4));
            }

            if (endOfMsg.startsWith("r")) { // damage >= 10, damage < 100
                damage = Integer.parseInt(endOfMsg.substring(2, 4));
            }

            if (endOfMsg.startsWith("o")) { // damage < 10
                damage = Integer.parseInt(endOfMsg.substring(3, 4));
            }
        } else if (message.contains("! critical damage.")) {
            String endOfMsg = message.substring(message.length() - 22, (message.length()));

            if (Character.isDigit(endOfMsg.charAt(0))) { // damage => 1000
                damage = Integer.parseInt(endOfMsg.substring(0, 4));
            }

            if (Character.isWhitespace(endOfMsg.charAt(0))) { // damage >= 100, damage < 1000
                damage = Integer.parseInt(endOfMsg.substring(1, 4));
            }
        }

        return damage;
    }
}
