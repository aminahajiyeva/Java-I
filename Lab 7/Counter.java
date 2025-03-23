/**
 * A simple counter that tracks the count between a minimum and maximum value.
 * This counter may be incremented, decremented and/or reset to its default minimum value.
 *
 * @author (Amina Hajiyeva, 101303729)
 * @version (March 1 2025)
 */
public class Counter
{
    /** The current value of this counter. */
    private int count;

    /** The minimum value of this counter. */
    private int minimumCount;

    /** The maximum value of this counter. */
    private int maximumCount;

    /** The default minimum value of this counter. */
    private static final int DEFAULT_MINIMUM = 0;

    /** The default maximum value of this counter. */
    private static final int DEFAULT_MAXIMUM = 999;

    /**
     * Constructs a new Counter whose current count is
     * initialized to DEFAULT_MINIMUM, and which counts between
     * DEFAULT_MINIMUM and DEFAULT_MAXIMUM, inclusive.
     */
    public Counter()
    {
        minimumCount = DEFAULT_MINIMUM;
        maximumCount = DEFAULT_MAXIMUM;
        count = minimumCount;
    }

    /**
     * Constructs a new Counter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     * 
     * @param minCount The minimum value for the counter.
     * @param maxCount The maximum value for the counter.
     */
    public Counter(int minCount, int maxCount)
    {
        minimumCount = minCount;
        maximumCount = maxCount;
        count = minimumCount;
    }

    /**
     * Returns the maximum value of this counter.
     * 
     * @return The maximum count value.
     */
    public int maximumCount()
    {
        return maximumCount;
    }

    /**
     * Returns the minimum value of this counter.
     * 
     * @return The minimum count value.
     */
    public int minimumCount()
    {
        return minimumCount;
    }

    /**
     * Returns this counter's current count.
     * 
     * @return The current count.
     */
    public int count()
    {
        return count;
    }

    /**
     * Returns true if this counter is at its minimum value.
     * 
     * @return True if count is at minimum value, false otherwise.
     */
    public boolean isAtMinimum()
    {
         return (count == minimumCount);
    }

    /**
     * Returns true if this counter is at its maximum value.
     * 
     * @return True if count is at maximum value, false otherwise.
     */
    public boolean isAtMaximum()
    {
        return (count == maximumCount);
    }

    /**
     * Resets this counter to its minimum value.
     */
    public void reset()
    {
        count = minimumCount;
    }
    
    /**
     * Increment this counter by 1.
     */
    public void incrementCount()
    {
        count++;
    }
}
