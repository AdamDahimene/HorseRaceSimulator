import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) {
        GUI frame = new GUI();

        while(!frame.getRunCode()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
        }

        Horse[] Horses = new Horse[frame.getLanes()];

        for(int i = 0; i < frame.getLanes(); i++) {
            SetHorse Horse = new SetHorse(i + 1);
            while(!Horse.getRunCode()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                }
            }
            Horses[i] = new Horse(Horse.getSymbol(), Horse.getName(), Horse.getConfidence());
        }

        Race race = new Race(frame.getDistance(), Horses);
        race.startRaceGUI();
    }
}