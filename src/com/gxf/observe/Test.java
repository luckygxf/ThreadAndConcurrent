package com.gxf.observe;

/**
 * ���Թ۲���ģʽ
 * ���Դ�����
 * @author GXF
 *
 */
public class Test {

	public static void main(String[] args) {
		//������飬����
		Subject xiaoFang = new Secretary();
		//������ͬ��
		Observer xiaoZou = new StockObserver();
		Observer xiaoLiu = new NBAObserver();
		
		//ע�ᵽ��������
		xiaoFang.attach(xiaoLiu);
		xiaoFang.attach(xiaoZou);
		
		//�ϰ������,����Ͻ�֪ͨ���ǣ�������
		xiaoFang.notifyObserver();

	}

}
