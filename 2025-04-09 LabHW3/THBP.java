import java.util.List;

/**
 * a batch processing temperature and humidity sensor & processor
 * @author graham simons
 */
public class THBP extends THTemplate {
    public THBP() {}

    /**
     * what happens after each collection
     */
    @Override
    protected void postCollect() {
        // doesn't do anything as collection is happening!
    }

    /**
     * what happens before each query
     */
    @Override
    protected void preQuery() {
        clean();
        parse();
    }
}
