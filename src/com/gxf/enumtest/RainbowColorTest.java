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
				System.out.println("��������һ");
				break;
			case Tue:
				System.out.println("�������ڶ�");
				break;
			case Wed:
				System.out.println("����������");
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
