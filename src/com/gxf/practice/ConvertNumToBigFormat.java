package com.gxf.practice;

/**
 * ��һ����λ��ת���ɴ�дģʽ
 * @author GXF
 *
 */
public class ConvertNumToBigFormat {

	public static void main(String[] args) {
		ConvertNumToBigFormat convertNumToBigFormat = new ConvertNumToBigFormat();
		int num = 6231;
		String result = convertNumToBigFormat.converToBigFormat(num);
		System.out.println("result = " + result);
	}
	
	/**
	 * ��һ����λ��ת���ɴ�дģʽ
	 * @param num
	 * @return
	 */
	public String converToBigFormat(int num){
		StringBuilder result = new StringBuilder();
		String oneToTenDic[] = {"", "Ҽ", "��", "��" , "��", "��", "½", "��", "��", "��"};
		String unitDic[] = {"", "ʮ", "��", "ǧ"};
	
		int mod = 1000;
		
		while(num != 0){
			int temp = num / mod;
			if(temp == 0){
				mod /= 10;
				num %= mod;
				continue;
			}//if
			result.append(oneToTenDic[temp]);
			int index = String.valueOf(num).length() - 1;
			result.append(unitDic[index]);
			num %= mod;
			while(mod > num)
				mod /= 10;
		}//while
		
		return result.toString();
	}

}
