package com.gxf.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIOReadFile {

	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/GXF/Desktop/�ҹ���/�澭.txt";
		RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
		
		//Channel
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		int bytesRead = fileChannel.read(byteBuffer);
		
		//��ȡ���ݣ����������̨
		while(bytesRead != -1){
			System.out.println("bytesRead = " + bytesRead);
			
			//����position,limit
			byteBuffer.flip();
			
			//�����̨�����ȡ�����ļ�����
//			while(byteBuffer.hasRemaining()){
//				System.out.print(byteBuffer.getChar());
//			}//while

			byte arrayOfByte[] = byteBuffer.array();
			String readContent = new String(arrayOfByte, Charset.defaultCharset());
			System.out.println("readContent = " + readContent);
			//����
			System.out.println();
			
			//����buffer,�ڶ�ȡ�ļ�����
			byteBuffer.clear();
			bytesRead = fileChannel.read(byteBuffer);
		}//while
		
		randomAccessFile.close();
	}

}
