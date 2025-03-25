public class Date {
    public int year;
    public byte month;
    public byte day;

    public Date(int year, byte month, byte day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    protected boolean isBefore(Date other){
        if(this.year < other.year || this.month < other.month || this.day < other.day)
            return true;
        else
            return false;
    }

    protected boolean isAfter(Date other){
        return "";
    }

}
