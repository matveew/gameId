package telegram;

import database.PositionDao;
import database.UserDao;
import global.Global;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import scanerio.Position;
import scanerio.lvl_1.Main;


import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();


        User user = message.getForwardFrom();

        UserDao.saveNewUser(user);

        System.out.println("message: " + update.getMessage().getText());

        if (message != null && message.hasText()) {


            Position position = PositionDao.getPosition(message.getChatId().intValue());
            if (!position.getPosition().equals("registration"))
                position.goAhead(message.getText());

            new Main().play(position);
        }


    }


    public void setButtons(SendMessage sendMessage, String... buttons) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        for (String button : buttons)
            keyboardFirstRow.add(new KeyboardButton(button));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }


    public void sendButtonsMessage(String[] buttons, String text, int id) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(id + "");
        sendMessage.setText(text);


        try {
            setButtons(sendMessage, buttons);

            System.out.println("message: " + sendMessage.getText());


            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String text, int id) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(id + "");
        sendMessage.setText(text);


        try {


            System.out.println("message: " + sendMessage.getText());
            String[] s = new String[0];
            setButtons(sendMessage, s);


            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String getBotUsername() {
        return "gametest42bot";
    }

    public String getBotToken() {
        return "1032803141:AAE5vr9MiQXAVNAR_9dgFXNz178t2iIGG24";
    }

    public static void main(String[] args) {

        try {

            ApiContextInitializer.init();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            Bot bot = new Bot();
            telegramBotsApi.registerBot(bot);
            Telegram.bot = bot;

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public List<String> getPositionWithValue() {
        List<String> positions = new ArrayList<>();
        positions.add("registration.name");
        return positions;
    }

}
