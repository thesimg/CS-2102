package hw5;
/** A Mutable, simple, gregorian calendar implementation for the green house */
public class GHCalendar implements Comparable<GHCalendar>{
    /** a year as an integer like yyyy. Assumes A.D. */
    private int year;
    /** 1-12 :: Jan-Dec */
    private int month;
    /** day of the month (e.g. 1-31, 1-30, 1-29, 1-28) */
    private int day;

    /**
     * Copy Constructor
     * @param ghCalendar some other calendar
     */
    public GHCalendar(GHCalendar ghCalendar) {
        year = ghCalendar.year;
        month = ghCalendar.month;
        day = ghCalendar.day;
    }
    /**
     * A typical constructor for initializing a calendar by date
     * @param year 0-9999
     * @param month 1-12
     * @param day 1-31
     */
    public GHCalendar(int year, int month, int day) {
        if(month < 1 || month > 12){
            throw new RuntimeException("Month out of range");
        } else if(day < 1 || day > 31){
            throw new RuntimeException("Day out of range");
        } else if(year < 1 || year > 9999){
            throw new RuntimeException("Year out of range");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * A convenience function to construct a calendar from a datestring
     * @param yyyymmdd like "20250410" or "00010101"
     */
    public GHCalendar(String yyyymmdd){
        this(Integer.parseInt(yyyymmdd.substring(0,4)), //yyyy
             Integer.parseInt(yyyymmdd.substring(4,6)), //mm
             Integer.parseInt(yyyymmdd.substring(6,8)));//dd
    }

    /**
     * @return the calendar date in yyyymmdd format
     */
    public String toString(){
        return String.format("%04d%02d%02d",year,month,day);
    }

    /**
     * Adds a single day to the calendar via mutation
     * @return itself for method-chaining
     */
    public GHCalendar addDay() {
        int daysInMonth;
        // 30 days hath september, april, june, and november
        if(month == 4 || month == 6 || month == 9 || month == 11){
            daysInMonth = 30;
        } else if(month == 2 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            daysInMonth = 29; // leap year
        }
        else if(month == 2) { // february
            daysInMonth = 28;
        } else {
            daysInMonth = 31; //and the rest
        }

        // roll-over
        if(day == daysInMonth && month != 12){
            day = 1;
            month++;
        } else if(day == daysInMonth){
            day = 1;
            month = 1;
            year++;
        } else {
            day++;
        }
        return this;
    }

    /**
     * subtracts a single day to the calendar via mutation
     * @return itself for method-chaining
     */
    public GHCalendar minusDay() {
        int daysInMonth;
        if(day != 1){
            day--;
        } else if(month != 1) { // roll under Feb-Dec
            month--;
            // 30 days hath september, april, june, and november
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else if (month == 2 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                day = 29; // leap year
            } else if (month == 2) { // february
                day = 28;
            } else {
                day = 31; //and the rest
            }
        } else { //roll-under jan 1st
            year--;
            month = 12;
            day = 31;
        }

        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GHCalendar otherCal){
            return this.compareTo(otherCal) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return year * month * day * (year ^ month ^ day);
    }

    @Override
    public int compareTo(GHCalendar ghCalendar) {
        int yearDiff = year - ghCalendar.year;
        int monthDiff = month - ghCalendar.month;
        int dayDiff = day - ghCalendar.day;
        if(yearDiff != 0){
            return yearDiff;
        } else if(monthDiff != 0){
            return monthDiff;
        } else {
            return dayDiff;
        }
    }
}
