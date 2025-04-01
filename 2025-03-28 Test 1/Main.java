public class Main {
    public static void main(String[] args) {

    }

    /** computes the ratio of two numbers
     * @param n some number
     * @param m some other number
     * @return the ratio as a number between 0.0 and 1.0 or 1.0 if n is bigger than m
     */
    public double computeRatio(double n, double m) {
        double ratio = n / m;
        if(ratio > 1.0){
            ratio = 1.0;
        }
        return ratio;
    }
}
