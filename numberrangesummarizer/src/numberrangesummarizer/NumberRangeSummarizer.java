package numberrangesummarizer;

import java.util.Collection;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *  
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */
public interface NumberRangeSummarizer {

    //collect the input
    Collection<Integer> collect(String input);

    //get the summarized string
    String summarizeCollection(Collection<Integer> input);

}



/*In this updated implementation, the input string "1,3,6,7,8,12,13,14,15,21,22,23,24,31" 
 *is split into an array of strings numArray using the comma as the delimiter. Then, each
 *string in numArray is converted to an integer and added to the NumberRangeList instance
 *using the addNumber method. Finally, the resulting comma-delimited list is printed to the console.
*/





