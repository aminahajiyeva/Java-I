/**
 * A simple counter that increments within a fixed range. Upon reaching its maxiumum value, the counter rolls over to its minimum value.
 *
 * @author (Amina Hajiyeva, 101303729)
 * @version (March 1 2025)
 */
public class RollOverCounter extends Counter
{
    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to the Counter's minimum, and which counts between
     * the Counter's minimum and the Counter's maximum, inclusive.
     */
    public RollOverCounter()
    {
        super();
    }

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     * 
     * @param minCount The minimum value for the counter.
     * @param maxCount The maximum value for the counter.
     * 
     */
    public RollOverCounter(int minCount, int maxCount)
    {
        super(minCount, maxCount);
    }

    /**
     * Increment this counter by 1. If the counter reaches its maximum value, it rolls over to the counters minimum value.
     */
    public void countUp()
    {
        // If we've reached the maximum count, invoking this
        // method rolls the counter over to its minimum value.
        if (isAtMaximum()) 
        {
            reset();
        } else 
        {
            incrementCount();
        }
    }
}
