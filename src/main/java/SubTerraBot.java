import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class SubTerraBot extends TelegramLongPollingBot{
    Callendar callendar = new Callendar();

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        if(command.startsWith("reserv")){       // reserve command
            message.setText(callendar.getSlot(/* stuff */));
        }
    }






















    public String getBotUsername() {
        return "SubTerra_Bot";
    }

    public String getBotToken() {
        return "1207169173:AAHbX2nKYq0JqE0IGOomhcCLIqLwlNiSneE";
    }
}
