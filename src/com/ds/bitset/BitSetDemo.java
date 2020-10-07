package com.ds.bitset;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		
		//Creating two BitSet's b1 and b2 of size 6
		BitSet b1 = new BitSet(6);
		BitSet b2 = new BitSet(6);
		
		//Setting 2nd and 5th bit of b1
		b1.set(2);
		b1.set(5);
		
		//Setting 0th, 2nd and 4th bit of b2
		b2.set(0);
		b2.set(2);
		b2.set(4);
		
		System.out.print("\nBitSet b1 -> " + b1);
		System.out.print("\nBitSet b2 -> " + b2);
		
		//b1 AND b2. Changes in b2
		b2.and(b1);
		System.out.print("\nAfter ANDing BitSet b2 -> " + b2);
		
		
		//b1 OR b2. Newly generated b2 is used. Changes in b2
		b2.or(b1);
		System.out.print("\nAfter ORing BitSet b2 -> " + b2);
		
		//b1 XOR b2. Newly generated b2 is used. Changes in b2
		b2.xor(b1);
		System.out.print("\nAfter XORing BitSet b2 -> " + b2);		
	}

}
