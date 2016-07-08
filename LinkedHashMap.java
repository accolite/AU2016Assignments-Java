package com.accolite.mycollections;

import java.util.*;

public class LinkedHashMap {

	public ArrayList<Node> bucket = new ArrayList<Node>();
	public Node head;

	public LinkedHashMap() {

		head = null;
		for (int i = 0; i < 16; i++) {
			bucket.add(null);
		}
	}

	public void put(String key, int value) {
		int flag = 0;
		int hash = key.hashCode() / 268435456;
		Node thisPlace = this.bucket.get(hash);
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		newNode.seqNext = null;

		if (thisPlace == null) {
			bucket.set(hash, newNode);
			newNode.next = null;
			Node first = head;
			if (first == null) {
				newNode.seqPrevious = null;
				first = newNode;
				head = newNode;
			} else {
				while (first.seqNext != null) {
					first = first.seqNext;
				}
				first.seqNext = newNode;
				newNode.seqPrevious = first;
				first = newNode;
			}
		} else {
			Node fromHere = thisPlace;
			while (fromHere.next != null) {
				if (fromHere.key.equals(key)) {
					fromHere.value = value;
					flag = 1;
					break;
				}
				fromHere = fromHere.next;
			}
			if (flag != 1) {
				fromHere.next = newNode;
				newNode.previous = fromHere;
				Node first = head;
				while (first.seqNext != null) {
					first = first.seqNext;
				}
				first.seqNext = newNode;
				newNode.seqPrevious = first;
				first = newNode;
			}
		}
	}

	public void printSequence() {
		Node first = this.head;
		while (first != null) {
			first = first.seqNext;
		}
	}

	public void bucketContents(int index) {
		Node thisBucket = bucket.get(index);
		while (thisBucket != null) {
			thisBucket = thisBucket.next;
		}
	}

	public int get(String key) {
		int hash = key.hashCode() / 268435456;
		System.out.println("hash in get is" + hash);
		Node thisPlace = bucket.get(hash);
		while (thisPlace != null) {
			if (thisPlace.key.equals(key)) {
				return thisPlace.value;
			}
			thisPlace = thisPlace.next;
		}
		return -1;
	}

}
