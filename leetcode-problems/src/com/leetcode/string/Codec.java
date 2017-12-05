package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Codec {
	
	public static void main (String [] args) {
		
		List<String> input = new ArrayList<String>();
		input.add("test");
		input.add("encode");
		
		System.out.println("Encode : " + new Codec().encode(input));
		
		System.out.println("Decode : " + new Codec().decode("4/test6/encode"));
		
	}
	
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

}
