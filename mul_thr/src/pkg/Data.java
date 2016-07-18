package pkg;

public class Data {
	int apple;
	int orange;
	int grape;
	int watermelon;
	final int max = 10;
	public synchronized void pro(String str)
	{
		if(str.equals("apple"))
			apple++;
	}

}
