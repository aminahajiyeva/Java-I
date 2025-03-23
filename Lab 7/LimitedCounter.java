/**
 * A simple counter that increments within a fixed range. Upon reaching its maxiumum value, the counter stops incrementing.
 *
 * @author (Amina Hajiyeva, 101303729)
 * @version (March 1 2025)
 */
public class LimitedCounter extends Counter
{
    /**
     * 
     * Constructs a new LimitedCounter whose current count is
     * initialized to the Counter's minimum, and which counts between
     * the Counter's minimum and the Counter's maximum, inclusive.
     *
     */
    public LimitedCounter()
    {
        super();
    }

    /**
     * Constructs a new LimitedCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     * 
     * @param minCount The minimum value for the counter.
     * @param maxCount The maximum value for the counter.
     * 
     */
    public LimitedCounter(int minCount, int maxCount)
    {
        super(minCount, maxCount);
    }

    /**
     * Increment this counter by 1. If counter is at maximum, it does not increment.
     */
    public void countUp()
    {
        // If we've reached the maximum count, invoking this
        // method doesn't change the state of the counter.
        if(!isAtMaximum())
        {
            incrementCount();
        }
    }
}
