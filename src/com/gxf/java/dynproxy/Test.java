package com.gxf.java.dynproxy;

/**
 * ≤‚ ‘java∂ØÃ¨¥˙¿Ì
 * @author GXF
 *
 */
public class Test {
	public static void main(String args[]){
		BookFacade target = new BookFacadeImpl();
		BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
		BookFacade proxy = (BookFacade) bookFacadeProxy.getProxy(target);
		proxy.addBook();
	}
}
