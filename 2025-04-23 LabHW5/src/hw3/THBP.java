package hw3;

/** An implementation of THTemplate that processes data before each query */
public class THBP extends THTemplate {
    @Override
    protected void postCollect() {

    }

    @Override
    protected void preQuery() {
        this.clean();
        this.parse();
    }
}
