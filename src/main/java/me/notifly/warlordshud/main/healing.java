package me.notifly.warlordshud.main;

/***
 * Created by Dan on 29/03/2017.
 */

public class healing {

    public static Integer healingCalc(String message) {

        Integer healing  = 0;


        if (!message.contains(" critically ")) {
            String endOfMsg = message.substring(message.length() - 12, (message.length()));
            if (Character.isDigit(endOfMsg.charAt(0))) { // healing > 1000
                healing = Integer.parseInt(endOfMsg.substring(0, 4));
            }

            if (Character.isWhitespace(endOfMsg.charAt(0))) { // healing >= 100, healing < 1000
                healing = Integer.parseInt(endOfMsg.substring(1, 4));
            }

            if (endOfMsg.startsWith("r")) { // healing >= 10, healing < 100
                healing = Integer.parseInt(endOfMsg.substring(2, 4));
            }

            if (endOfMsg.startsWith("o")) { // damage < 10
                healing = Integer.parseInt(endOfMsg.substring(3, 4));
            }
        } else if (message.contains(" critically healed ")) {
            String endOfMsg = message.substring(message.length() - 13, (message.length()));

            if (Character.isDigit(endOfMsg.charAt(0))) { // healing > 1000
                healing = Integer.parseInt(endOfMsg.substring(0, 4));
            }

            if (Character.isWhitespace(endOfMsg.charAt(0))) { // healing >= 100, healing < 1000
                healing = Integer.parseInt(endOfMsg.substring(1, 4));
            }
        }

        return healing;
    }
}
