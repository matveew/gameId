package telegram;

import scanerio.Position;

public class Telegram {
    static public Bot bot;


    static public void sendButtonsMessage(Position position, String... elements) {

        String[] buttons = new String[elements.length - 1];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = elements[i];
        }

        String message = elements[elements.length - 1];
        bot.sendButtonsMessage(buttons, message, position.getId());
    }


    static public void sendMessage(Position position, String message) {
        bot.sendMessage(message, position.getId());
    }


}
