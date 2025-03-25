public class Movie {
    public String title;
    public int runningTime;
    public String rating;
    public Date openingDate;

    public Movie(String title, int runningTime, String rating, Date openingDate){
        this.title = title;
        this.runningTime = runningTime;
        this.rating = rating;
        this.openingDate = openingDate;

    }

    public boolean literallyForBabies(){
        return this.rating.equals("G") && this.runningTime < 90;
    }

    public String openedEarlier(Movie other){
        if(this.openingDate.isBefore(other.openingDate)){
            return this.title;
        } else if (this.openingDate.isAfter(other.openingDate)){
            return other.title;
        } else {
            return "Twinsies";
        }
    }
}
