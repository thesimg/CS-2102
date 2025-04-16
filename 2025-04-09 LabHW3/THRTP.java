import java.util.List;

/**
 * a real-time temperature and humidity sensor & processor
 * @author graham simons
 */
public class THRTP extends THTemplate {
    public THRTP() {}

    /**
     * what happens after each collection
     */
    @Override
    protected void postCollect() {
        clean();
        parse();
    }

    /**
     * what happens before each query
     */
    @Override
    protected void preQuery() {
        // doesn't do anything on each query!
    }
}
