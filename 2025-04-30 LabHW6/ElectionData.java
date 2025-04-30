import java.util.HashMap;
import java.util.Set;
import java.util.Optional;
public class ElectionData {
    HashMap<String, Votes> votes;
    I3VoteStrategy strategy;

    public ElectionData(I3VoteStrategy strategy){
        this.strategy = strategy;
    }
    public Set<String> getCandidates(){
        throw new RuntimeException("REPLACE ME!");
    }
    public void nominateCandidate(String person) throws AlreadyNominatedException{
        throw new RuntimeException("REPLACE ME!");
    }
    public void submitVote(String first, String second, String third)
            throws CandidateNotNominatedException, MoreThanOnceException {
        throw new RuntimeException("REPLACE ME!");
    }
    public Optional<String> calculateWinner(){
        throw new RuntimeException("REPLACE ME!");
    }
    public void setStrategy(I3VoteStrategy strategy){
        throw new RuntimeException("REPLACE ME!");
    }
}