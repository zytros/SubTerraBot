import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        DataManager dm = new DataManager();
        dm.readData(new Date(2020, 1, 1));
        dm.writeData("Sandy", 1900, 2100, new Date(2020, 1,1));
        Callendar callendar = new Callendar();
        System.out.println(callendar.reserve(new Date(2020, 1, 1), "Luca", 1200, 1500));


        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new SubTerraBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
