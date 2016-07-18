package com.au.thread;
import java.util.concurrent.*;

public class Buyers implements Runnable{
	//protected BlockingQueue queue = null;
		protected BlockingQueue Apple = null;
		protected BlockingQueue Orange = null;
		protected BlockingQueue Grape = null;
		protected BlockingQueue Watermelon =null;
		int fruit[] = new int[4];
		boolean needed = false;

		public Buyers(BlockingQueue Apple,BlockingQueue Orange,BlockingQueue Grape,BlockingQueue Watermelon) {
			this.Apple = Apple;
			this.Orange = Orange;
			this.Grape = Grape;
			this.Watermelon = Watermelon;
		}
		public void getFruits(int fruit[]){
			this.fruit[0]=fruit[0];
			this.fruit[1]=fruit[1];
			this.fruit[2]=fruit[2];
			this.fruit[3]=fruit[3];
		}
	public void run() {
		needed = false;
		for(int i=1;i<=fruit[0];i++){
			if(Apple.size()==0){
				
				System.out.println("Wait for the Apple");
				needed = true;
				break;
			}
			else{
				try {
					Apple.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int i=1;i<=fruit[1];i++){
			if(Orange.size()==0){
				needed = true;
				System.out.println("Wait for the Orange");
				break;
			}
			else{
				try {
					Orange.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int i=1;i<=fruit[2];i++){
			if(Grape.size()==0){
				needed = true;
				System.out.println("Wait for the Grape");
				break;
			}
			else{
				try {
					Grape.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int i=1;i<=fruit[3];i++){
			if(Watermelon.size()==0){
				needed = true;
				System.out.println("Wait for the Watermelon");
				break;
			}
			else{
				try {
					Watermelon.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	//	if(needed)
		//	try {
				//Thread.sleep(10000);
		//	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
	}
}
