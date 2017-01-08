package tff.agventure;

import java.io.Serializable;

public class TimeOfOperation implements Serializable {
    private String mDay;
    private String mHour;

    public TimeOfOperation(String day, String hour) {
        mDay = day;
        mHour = hour;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String hour) {
        mHour = hour;
    }
}
