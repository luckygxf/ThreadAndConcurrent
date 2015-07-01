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
		String filePath = "C:/Users/GXF/Desktop/找工作/面经.txt";
		RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
		
		//Channel
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		int bytesRead = fileChannel.read(byteBuffer);
		
		//读取数据，输出到控制台
		while(bytesRead != -1){
			System.out.println("bytesRead = " + bytesRead);
			
			//设置position,limit
			byteBuffer.flip();
			
			//向控制台输出读取到的文件内容
//			while(byteBuffer.hasRemaining()){
//				System.out.print(byteBuffer.getChar());
//			}//while

			byte arrayOfByte[] = byteBuffer.array();
			String readContent = new String(arrayOfByte, Charset.defaultCharset());
			System.out.println("readContent = " + readContent);
			//换行
			System.out.println();
			
			//重置buffer,在读取文件内容
			byteBuffer.clear();
			bytesRead = fileChannel.read(byteBuffer);
		}//while
		
		randomAccessFile.close();
	}

}
