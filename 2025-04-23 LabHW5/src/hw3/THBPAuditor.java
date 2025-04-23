package hw3;

/** Extends BP to also count how many errors are encountered */
public class THBPAuditor extends THBP {

    /** The number of errors processed so far */
    protected int errors = 0;

    /**
     * Remove dates and errors, but count the errors along the way.
     */
    protected void clean(){
        for(String s : this.sensorData){
            if(s.equals("Err")){
                errors++;
            }
        }
        super.clean();
    }

    /**
     * @return the number of times "Err" has appeared in the data
     */
    protected int getErrorCount(){
        return errors;
    }
}
