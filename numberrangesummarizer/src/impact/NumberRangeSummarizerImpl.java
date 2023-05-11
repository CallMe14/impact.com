package impact;


import java.util.*;

import numberrangesummarizer.NumberRangeSummarizer;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
    	List<Integer> numbers = new ArrayList<>();
    	if(input != ""){
    		 // Split the input string by comma delimiter
    		
    		 String[] numArray = input.split(",");
    		 
    		// Convert each string number to integer and collect them into a list
    		 
    	        for (String num : numArray) {
    	            int number = Integer.parseInt(num.trim());
    	            numbers.add(number);
    	        }

    	}
       
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<String> ranges = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>(input);

        if (numbers.isEmpty()) {
            return "";
        }

        int startRange = numbers.get(0);
        int prevNum = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) - prevNum > 1) {
            	 // Add the range to the list
                addRange(startRange, prevNum, ranges);
                startRange = numbers.get(i);
            }
            prevNum = numbers.get(i);
        }
        // Add the last range into the list
        addRange(startRange, prevNum, ranges);

     // Join the ranges using the comma delimiter
        return String.join(",", ranges);
    }

    private void addRange(int start, int end, List<String> ranges) {
        if (start == end) {
        	// Add single number to the list
            ranges.add(Integer.toString(start));
        } else {
        	// Add range of numbers to the list
            ranges.add(start + "-" + end);
        }
    }

    public static void main(String[] args) {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();

        // Test case 1: Empty input
        String input1 = "";
        Collection<Integer> numbers1 = summarizer.collect(input1);
        String result1 = summarizer.summarizeCollection(numbers1);
        System.out.println("Test case 1: " + result1); // Expected output: ""

        // Test case 2: Single numbers
        String input2 = "1,3,5,7";
        Collection<Integer> numbers2 = summarizer.collect(input2);
        String result2 = summarizer.summarizeCollection(numbers2);
        System.out.println("Test case 2: " + result2); // Expected output: "1,3,5,7"

        // Test case 3: Sequential numbers
        String input3 = "1,2,3,4,5,6";
        Collection<Integer> numbers3 = summarizer.collect(input3);
        String result3 = summarizer.summarizeCollection(numbers3);
        System.out.println("Test case 3: " + result3); // Expected output: "1-6"

        // Test case 4: Sequential and non-sequential numbers
        String input4 = "1,3,6,7,8,10";
        Collection<Integer> numbers4 = summarizer.collect(input4);
        String result4 = summarizer.summarizeCollection(numbers4);
        System.out.println("Test case 4: " + result4); // Expected output: "1,3,6-8,10"
        //Test case 5: Sample input
        String input5 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers5 = summarizer.collect(input5);
        String result5 = summarizer.summarizeCollection(numbers5);
        System.out.println("Test case 5: " + result5); // Expected output
        
    }
}
