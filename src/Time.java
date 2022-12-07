/**
 * The Time class represents a clock with a certain amount of hours, minutes and seconds that have passed
 */
public class Time {
    private int sec;
    private int min;
    private int hours;


    /**
     * constructor for the Time class. This creates a new instance of the Time class using the parameters below
     * @param h   represents the amount of hours that has passed
     * @param m   represents the amount of minutes that have passed
     * @param s   represent the amount of seconds that have passed
     */
    public Time(int h, int m, int s) {
        hours = h;
        min = m;
        sec = s;
    }

    /**
     * tick method for the Time class. This method will return void and increases the time by one tick or one second
     * also checks to see if the time would be out of format (for instance having seconds = 61)
     */
    public void tick() {
        sec++;

        if (sec == 60) {
            sec = 0;
            min++;
            if (min == 60) {
                min = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }


    /**
     * add method for the Time class. This method will take the time object that it is called on, and add the time given by the
     * Time object in the parameter
     * also takes into account formatting for the time
     *
     * @param time   represents the second clocks time that would be added to the first
     */
    public void add(Time time) {
        hours = this.hours + time.hours;
        min = this.min + time.min;
        sec = this.sec + time.sec;

        if (sec >= 60) {
            sec %= 60;
            min++;
        }
        if (min >= 60) {
            min %= 60;
            hours++;
        } if (hours >= 24) {
            hours %= 24;
        }
    }


    /**
     * toString method for the Time class. This method will return a String displaying the clocks current time in
     * a specified format
     * @return returns a String of the Clocks time properly formatted (HH:MM:SS)
     */
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

        final String COLON = ":";

        return h + COLON + m + COLON + s;
    }

    /**
     * private isLessThan10 method for the Time class. This method returns a boolean and is used to see if the inputted number
     * is less than 10 so that it can later be padded with a 0 in front when being formatted by the toString method
     *
     * @param num represents the number that is being tested for whether it is less than 10
     * @return a boolean representing if num is less than 10
     */
    private boolean isLessThan10(int num) {
        return num < 10;
    }
}