package telegram;

import createWarrior.Create;
import database.GameDB;
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
import telegram.registration.CreateWarrior;
import warrior.Robber;
import warrior.Warrior;
import warrior.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    CreateWarrior createWarrior = null;

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();


        if (message != null && message.hasText()) {
            switch (message.getText()) {


                case "/create":
                    createWarrior = new CreateWarrior();
                    createWarrior.setUser(update.getMessage().getFrom());
                    sendMsg(message, "Select a type(wizard, robber). Example:\n" +
                            "/type wizard");
                    break;

                case "/name":
                    createWarrior.setNameWarrior(message.getText().split(" ")[1]);
                    createWarrior.save();
                    sendMsg(message, "Congratulations, you have created:" +
                            GameDB.getWarrior(update.getMessage().getFrom().getId()).getName());
                    break;

                case "/type":
                    createWarrior.setTypeWarrior(message.getText().split(" ")[1]);
                    sendMsg(message, "Create a character name. Example:\n" +
                            "/name stalin");
                    break;

                case "/go to arena":
                    sendMsg(message, "Arena under construction");
                    //      new Arena().deathBattle(warrior, new Wizard());
                    break;

                default:
                    if (message.getText().startsWith("/type")) {
                        createWarrior.setTypeWarrior(message.getText().split(" ")[1]);
                        sendMsg(message, "Create a character name. Example:\n" +
                                "/name stalin");
                        break;
                    }

                    if (message.getText().startsWith("/name")) {
                        createWarrior.setNameWarrior(message.getText().split(" ")[1]);
                        createWarrior.save();
                        sendMsg(message, "Congratulations, your warrior: " + GameDB.getWarrior(update.getMessage().getFrom().getId()).getName());
                        break;
                    }

                    if (message.getText().startsWith("/name")) {
                        createWarrior.setNameWarrior(message.getText().split(" ")[1]);
                        createWarrior.save();
                        sendMsg(message, "Congratulations, your warrior: " + GameDB.getWarrior(update.getMessage().getFrom().getId()).getName());
                        break;
                    }

                    if (message.getText().startsWith("/name")) {
                        createWarrior.setNameWarrior(message.getText().split(" ")[1]);
                        createWarrior.save();
                        sendMsg(message, "Congratulations, your warrior: " + GameDB.getWarrior(update.getMessage().getFrom().getId()).getName());
                        break;
                    }


                    System.out.println(message.getFrom());
                    break;
            }
        }
    }


    public void registration(Update update) {
        Message message = update.getMessage();
        int i = 0;


        switch (message.getText()) {
            case "/help":
                sendMsg(message, "How can i help you?");
                break;


            default:
                System.out.println(message.getFrom());
                break;

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
