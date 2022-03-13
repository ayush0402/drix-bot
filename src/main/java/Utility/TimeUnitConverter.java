package Utility;

public class TimeUnitConverter {
    // TODO: Fix time conversion.
    public static String convert(long durationInSeconds){
        long minutes = durationInSeconds/(long)60;
        long seconds = durationInSeconds - (minutes*60);

        return minutes + ":" + seconds;
    }
}
