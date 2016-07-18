package com.au.thread;
import java.util.concurrent.*;

public class Farmers implements Runnable{
	//protected BlockingQueue queue = null;
	protected BlockingQueue Apple = null;
	protected BlockingQueue Orange = null;
	protected BlockingQueue Grape = null;
	protected BlockingQueue Watermelon =null;
	int fruit[] = new int[4];
	//boolean needed = false;
	public Farmers(BlockingQueue Apple,BlockingQueue Orange,BlockingQueue Grape,BlockingQueue Watermelon) {
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
		for(int i=1;i<=fruit[0];i++){
			if(Apple.size()==9){
				System.out.println("Apple is overflowed");
				break;
			}
			else{
				Apple.add(i);
			}
		}
		for(int i=1;i<=fruit[1];i++){
			if(Orange.size()==9){
				System.out.println("Orange is overflowed");
				break;
			}
			else{
				Orange.add(i);
			}
		}
		for(int i=1;i<=fruit[2];i++){
			if(Grape.size()==9){
				System.out.println("Grape is overflowed");
				break;
			}
			else{
				Grape.add(i);
			}
		}
		for(int i=1;i<=fruit[3];i++){
			if(Watermelon.size()==9){
				System.out.println("Watermelon is overflowed");
				break;
			}
			else{
				Watermelon.add(i);
			}
		}
		
	}
		
}
