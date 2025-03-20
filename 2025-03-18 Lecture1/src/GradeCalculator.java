public class GradeCalculator {

    /* LECTURE INSTRUCTIONS:
     * - Given Example: quizPercentage()
     * - Given: Write test cases for quizPercentage()
     * - YOU DO: Given javadocs and stub, write test cases for hwPercentage()
     * - I DO: Implement hwPercentage()
     * - WE Do: Document and finish fuzzyLetterGrade
     * - YOU DO: Write javadocs, write stub, test cases, and implement labPercentage
     */

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
     * Computes the percentage of the current HW scores (each hw is worth 60 points)
     * @param hwPoints     the total number of hw points earned so far
     * @param hwsAttempted the number of hws attempted
     * @return the average on a scale of 0.0 to 1.0 (greater than 1.0 is extra credit)
     */
    public double hwPercentage(int hwPoints, int hwsAttempted){
        double pointsPerHW = 60.0;
//        return hwsAttempted > 0 ? hwPoints / (pointsPerHW * hwsAttempted) : 0;
        if (hwsAttempted > 0) {
            return hwPoints / (pointsPerHW * hwsAttempted);
        } else {
            return 0;
        }
    }

    public String fuzzyLetterGrade(int quiz1, int quiz2, int quiz3, int quiz4, int hwPoints, int hwsAttempted){
        double avg = (quizPercentage(quiz1, quiz2, quiz3, quiz4) + hwPercentage(hwPoints, hwsAttempted)) / 2;
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










}
