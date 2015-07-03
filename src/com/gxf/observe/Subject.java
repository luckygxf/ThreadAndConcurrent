package com.gxf.observe;

/**
 * 通知接口
 * @author GXF
 *
 */
public interface Subject {
	void attach(Observer observer);
	void detach(Observer observer);
	void notifyObserver();
}
