package com.accolite.assignmnet;

public class Buffer {

	int billThreadPosition;
	int avgThreadPosition;
	int bufferIndex;
	int billCounter;
	int avgCounter;
	int ownerCounter;
	int capacity;
	Object billAmounts[];
	int avgBillAmounts[];

	Buffer(int capacity) {
		this.capacity = capacity;
		billThreadPosition = 0;
		avgThreadPosition = 0;
		bufferIndex = -1;
		billCounter = 0;
		avgCounter = 0;
		ownerCounter = 0;
		billAmounts = new Object[capacity];
		avgBillAmounts = new int[10];
	}

	public synchronized Object getBillAmounts() {
		Object object = null;
		if (Thread.currentThread().getName().equals("Thread-0")) {
			while (billCounter == 0) {
				try {
					wait(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object = billAmounts[billThreadPosition];
			billThreadPosition++;
			billCounter--;
			notifyAll();
			return object;
		}
		if (Thread.currentThread().getName().equals("Thread-1")) {
			while (avgCounter == 0) {
				try {
					wait(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object = billAmounts[AvgBillAmountThread.order];
			avgThreadPosition++;
			avgCounter--;
			return object;
		}
		return object;
	}

	public synchronized void setBillAmounts(Object billAmount) {
		while (bufferIndex == capacity - 1) {
			try {
				wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		billAmounts[++bufferIndex] = billAmount;
		billCounter++;
		avgCounter++;
		notifyAll();
	}

	public synchronized void setAvgBillAmount(Object billamount) {
		while (ownerCounter == 9) {
			try {
				wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		avgBillAmounts[ownerCounter] = (int) billamount;
		ownerCounter++;
	}

	public synchronized Object getAvgBillAmount() {
		while (ownerCounter == 0) {
			try {
				wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return avgBillAmounts[--ownerCounter];
	}
}
