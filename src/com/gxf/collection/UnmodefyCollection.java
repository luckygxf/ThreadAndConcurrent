package com.gxf.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UnmodefyCollection {
	static class Person{
		private Set<String> booksOfRead = new HashSet<String>();
		
		public void addBook(String book){
			booksOfRead.add(book);
		}
		
		public void showBooksOfRead(){
			Iterator<String> iterator = booksOfRead.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
		
		public void removeBook(String book){
			if(!booksOfRead.contains(book))
				return;
			booksOfRead.remove(book);
		}
		
		/**
		 * ����ֻ�����ϵĸ���
		 * @return
		 */
		public Set<String> getBooksOfRead(){
			return Collections.unmodifiableSet(booksOfRead);
		}
		
	}//person
	
	public static void main(String args[]){
		Person xiaoFang = new Person();
		xiaoFang.addBook("Design of pattern");
		xiaoFang.addBook("MySQL");
		
		xiaoFang.showBooksOfRead();
		
		Set<String> booksOfRead = xiaoFang.getBooksOfRead();
		//��ֻ��������������ݻ��׳��쳣
		booksOfRead.add("OS");
	}
}
