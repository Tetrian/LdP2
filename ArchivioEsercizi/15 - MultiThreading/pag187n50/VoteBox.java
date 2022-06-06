// RUBATO INDEGNAMENTE A V. TRAMO

import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Set;
import java.util.HashSet;

public class VoteBox {
    private final int MAX_VOTERS;
    private int totalTrue, totalFalse;
    private Set<Thread> voters;
    
    public VoteBox(int maxVoters) {
        if (maxVoters <= 0)
            throw new IllegalArgumentException();
        MAX_VOTERS = maxVoters;
        voters = new HashSet<>(MAX_VOTERS);
    }

    public synchronized void vote(boolean judgement) {
        Thread voter = Thread.currentThread();
        if (isDone() || !voters.add(voter))
            throw new IllegalStateException();
        if (judgement == true)
          totalTrue++;
        else
          totalFalse++;
        if (voters.size() == MAX_VOTERS)
          notifyAll();
    }
    public synchronized boolean isDone() {
        return voters.size() == MAX_VOTERS;
    }
    public synchronized boolean waitForResult() throws InterruptedException {
        while (!isDone()) {
            wait();
        }
        return totalFalse >= totalTrue ? false : true;
    }
}
