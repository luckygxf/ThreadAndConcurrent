package com.gxf.observe;

/**
 * ֪ͨ�ӿ�
 * @author GXF
 *
 */
public interface Subject {
	void attach(Observer observer);
	void detach(Observer observer);
	void notifyObserver();
}
