public class Time {
    private int sec;
    private int min;
    private int hours;

    private final String COLON = ":";

    public Time(int h, int m, int s) {
        hours = h;
        min = m;
        sec = s;
    }

    public void tick() {
        sec++;

        if (sec > 60) {
            sec = 0;
            min++;
            if (min > 60) {
                min = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    public String toString() {
        String h = ""; String m = ""; String s = "";

        if (isLessThan10(hours)) {
            h += "0" + hours;
        } else {
            h = hours + "";
        }

        if (isLessThan10(min)) {
            m += "0" + min;
        } else {
            m = min + "";
        }

        if (isLessThan10(sec)) {
            s += "0" + sec;
        } else {
            s = sec + "";
        }

        return h + COLON + m + COLON + s;
    }

    private boolean isLessThan10(int num) {
        return num < 10;
    }

}
