/**
 * an auditor to count errors before processing (before cleaning)
 * @author graham simons
 */
public class THBPAuditor extends THBP {
    private int errorCount = 0;

    /**
     * counts error entries before cleaning and parsing
     */
    @Override
    protected void preQuery() {
        for (String s : sensorData) {
            if (s.equals("Err")) {
                errorCount++;
            }
        }
        super.preQuery();
    }

    /**
     * @return the number of error tokens seen so far
     */
    public int getErrorCount() {
        preQuery(); // ensures parsing occurs and errors are counted
        return errorCount;
    }
}
