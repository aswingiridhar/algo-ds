package com.leetcode.string;

public class IPAddressToLong {
	
	public static void main(String []args) {
		System.out.println("IP to Long : " + ipToLong("192.10.40.3"));
	}
	
	public static long ipToLong(String ipAddress) {

		String[] ipAddressInArray = ipAddress.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);

		}

		return result;
	}

}
