package com.gxf.enumtest;

public class RainbowColorTest {
	
	public static void main(String args[]){
		RainbowColor rainbowColors[] = RainbowColor.values();
		for(int i = 0; i < rainbowColors.length; i++){
			System.out.println(rainbowColors[i]);
		}
		
		WeekDay toDay = WeekDay.Mon;

		switch(toDay){
			case Mon:
				System.out.println("今天星期一");
				break;
			case Tue:
				System.out.println("今天星期二");
				break;
			case Wed:
				System.out.println("今天星期三");
				break;
		}
		
		RainbowColor oneColor = RainbowColor.RED;
		
		System.out.println(oneColor.getDefaultColor());
		System.out.println(oneColor.getNums());
	}
}
enum WeekDay{
	Mon, Tue, Wed, Thu, Fri, Sat, Sun
}
