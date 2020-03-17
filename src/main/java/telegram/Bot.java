package telegram;

import createWarrior.Create;
import fight.Arena;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import warrior.Robber;
import warrior.Warrior;
import warrior.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    Warrior warrior;

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message.getFrom());
        System.out.println(message.getFrom());


        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "How can i help you?");
                    break;

                case "/settings":
                    sendMsg(message, "What will we configure?");
                    break;

                case "/start":
                    sendMsg(message, "What type of warrior you will be? Yoy can be wizard or robber.");
                    break;

                case "/name":
                    sendMsg(message, "Your name is " + message.getText().replace("/name ", ""));
                    warrior.setName(message.getText().replace("/name ", ""));
                    break;

                case "/type":
                    sendMsg(message, "Your type is " + message.getText().replace("/type ", ""));
                    if (message.getText().replace("/type ", "").equals("robber"))
                        warrior = new Robber();
                    if (message.getText().replace("/type ", "").equals("wizard"))
                        warrior = new Wizard();
                    break;

                case "/go to arena":
                    sendMsg(message, "You will fight with wizard");
                    new Arena().deathBattle(warrior, new Wizard());
                    break;

                default:
                    System.out.println(message.getFrom());
                    break;

            }
        }
    }


    void commandCreateWarrior(String message) {

        if (message.startsWith("/name")) {
        }

        if (message.startsWith("/type")) {
        }


    }


    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/settings"));
        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }


    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try {
            //    setButtons(sendMessage);
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
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());


        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }


    }


}
