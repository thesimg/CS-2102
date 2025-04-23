package hw3;

/** An implementation that processes data immediately after it is collected */
public class THRTP extends THTemplate {
    @Override
    protected void postCollect() {
        this.clean();
        this.parse();
    }

    @Override
    protected void preQuery() {

    }
}
