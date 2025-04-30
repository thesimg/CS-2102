import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Make sure to write tests that cause and expect the following exceptions to be thrown:
 * o CandidateNotNominatedException
 *                                 When trying to vote for a candidate that has not been nominated
 * o AlreadyNominatedException
 *                             When trying to nominate a candidate twice
 * o MoreThanOnceException
 *                        When trying to vote for the same candidate in more than a single 1st, 2nd, or 3rd slot in a single vote.
 */


public class Examples {

    @Test
    public void testMFVStrategy() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        I3VoteStrategy strat = new MostFirstVotesStrategy();
        ElectionData election = new ElectionData(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Graham", "Jack");
        election.submitVote("Grace", "Graham", "Jack");
        assertEquals(Optional.of("Grace"), election.calculateWinner());

    }

    @Test
    public void testMFVStrategyEmpty() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        I3VoteStrategy strat = new MostFirstVotesStrategy();
        ElectionData election = new ElectionData(strat);
        election.setStrategy(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Graham", "Jack");
        election.submitVote("Jack", "Graham", "Grace");
        assertEquals(Optional.empty(), election.calculateWinner());

    }

    @Test
    public void testMAStrategy() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        I3VoteStrategy strat = new MostAgreeableStrategy();
        ElectionData election = new ElectionData(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.nominateCandidate("Kate");
        election.nominateCandidate("Tyler");
        election.submitVote("Tyler", "Kate", "Jack");
        election.submitVote("Kate", "Graham", "Grace");
        election.submitVote("Kate", "Graham", "Jack");
        election.submitVote("Kate", "Tyler", "Grace");
        assertEquals(Optional.of("Kate"), election.calculateWinner());

    }

    @Test
    public void testMAStrategyEmpty() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        I3VoteStrategy strat = new MostAgreeableStrategy();
        ElectionData election = new ElectionData(strat);
        election.setStrategy(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Graham", "Jack");
        election.submitVote("Jack", "Grace", "Graham");
        assertEquals(Optional.empty(), election.calculateWinner());
    }

    @Test
    public void testGetCandidates() throws AlreadyNominatedException {
        I3VoteStrategy strat = new MostAgreeableStrategy();
        ElectionData election = new ElectionData(strat);
        Set<String> candidates = new HashSet<>();
        candidates.add("Grace");
        candidates.add("Graham");
        candidates.add("Jack");
        election.setStrategy(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        assertEquals(candidates, election.getCandidates());
    }

    // EXCEPTIONS THROWN

    @Test(expected = AlreadyNominatedException.class)
    public void testAlreadyNominated() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        I3VoteStrategy strat = new MostFirstVotesStrategy();
        ElectionData election = new ElectionData(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Jack", "Graham");
        election.submitVote("Grace", "Graham", "Jack");
        assertEquals(Optional.of("Grace"), election.calculateWinner());
    }

    @Test(expected = MoreThanOnceException.class)
    public void testMoreThanOnce() throws MoreThanOnceException, CandidateNotNominatedException, AlreadyNominatedException {
        I3VoteStrategy strat = new MostFirstVotesStrategy();
        ElectionData election = new ElectionData(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Jack", "Grace");
        election.submitVote("Grace", "Graham", "Jack");
        assertEquals(Optional.of("Grace"), election.calculateWinner());
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testCandidateNotNom() throws MoreThanOnceException, CandidateNotNominatedException, AlreadyNominatedException{
        I3VoteStrategy strat = new MostFirstVotesStrategy();
        ElectionData election = new ElectionData(strat);
        election.nominateCandidate("Grace");
        election.nominateCandidate("Graham");
        election.nominateCandidate("Jack");
        election.submitVote("Grace", "Tyler", "Grace");
        election.submitVote("Grace", "Graham", "Jack");
        assertEquals(Optional.of("Grace"), election.calculateWinner());
    }
}



