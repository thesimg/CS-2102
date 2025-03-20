public class GradeCalculatorAnswer {


    /**
     * calculates the quiz average across all 4 quizzes (not including dropped)
     * @param quiz1
     * @param quiz2
     * @param quiz3
     * @param quiz4
     * @return the % on a scale of 0.0 to 1.0
     */
    public double quizPercentage(int quiz1, int quiz2, int quiz3, int quiz4){
        double pointsPerQuiz = 50.0;
        return (quiz1 + quiz2 + quiz3 + quiz4) / (4 * pointsPerQuiz);
    }

    /**
     * Computes the percentage of the current HW scores (each HW is worth 60 points)
     * @param hwPoints     the total number of hw points earned so far
     * @param hwsAttempted the number of hws attempted
     * @return the average on a scale of 0.0 to 1.0 (greater than 1.0 is extra credit)
     */
    public double hwPercentage(int hwPoints, int hwsAttempted){
        double pointsPerHW = 60.0;
        return hwsAttempted > 0 ? hwPoints / (pointsPerHW * hwsAttempted) : 0;
    }

    /**
     * Computes a estimted letter grade given quiz scores and hws attempted
     * @param quiz1
     * @param quiz2
     * @param quiz3
     * @param quiz4
     * @param hwPoints
     * @param hwsAttempted
     * @return a string representing the letter grade
     */
    public String fuzzyLetterGrade(int quiz1, int quiz2, int quiz3, int quiz4, int hwPoints, int hwsAttempted){
        double avg = (this.quizPercentage(quiz1, quiz2, quiz3, quiz4) + this.hwPercentage(hwPoints, hwsAttempted)) / 2.0;
        String myGrade = "My grade is:";
        if(avg >= .90){
            return myGrade + " " + "A";
        } else if (avg >= .80){
            return myGrade.concat(" ").concat("B");
        } else if(avg >= .70){
            return String.format("%s %s",myGrade, "C");
        } else {
            return myGrade + " NR";
        }

    }

    /**
     * The percentage of current Lab scores
     * @param labPoints the total number of lab points earned
     * @param labsAttempted the number of labs submitted to gradescope (max 10 points each)
     * @param labsAttended the number of labs extra credit is earned for attending (3 points each)
     * @return the average on a scale of 0.0 to 1.0 (greater than 1.0 is extra credit)
     */
    public double labPercentage(int labPoints, int labsAttempted, int labsAttended){
        double pointsPerLab = 10.0;
        double attendanceEC = 3.0;
        return labsAttempted > 0 ? (labPoints + (labsAttended * attendanceEC)) / (pointsPerLab * labsAttempted) : 0;
    }

    /* Version with IF-ELSE statement & single return
   public double labPercentage(int labPoints, int labsAttempted, int labsAttended){
        double pointsPerLab = 10.0;
        double attendanceEC = 3.0;
        double answer = 0.0;
        if(labsAttempted > 0) {
          answer = (labPoints + (labsAttended * attendanceEC)) / (pointsPerLab * labsAttempted);
        }
        else{
          answer = 0.0;
        }
        return answer;
    }
     */


   /* Version with IF-style "guard" and multiple returns
   public double labPercentage(int labPoints, int labsAttempted, int labsAttended){
        if(labsAttempted == 0) { return 0.0; } //guard to avoid divide-by-zero
        double pointsPerLab = 10.0;
        double attendanceEC = 3.0;
        return (labPoints + (labsAttended * attendanceEC)) / (pointsPerLab * labsAttempted);
    }
     */








}
