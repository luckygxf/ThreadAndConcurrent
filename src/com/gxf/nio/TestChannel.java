package com.gxf.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ≤‚ ‘Õ®µ¿≥Ã–Ú
 * @author Administrator
 *
 */
public class TestChannel {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\Workspace_android\\ThreadAndConcurrent\\Files\\Test.txt";
		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		int bytesRead = inChannel.read(buf);
		
		while(bytesRead != -1){
			System.out.println("Read : " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println((char) buf.get());
				
			}//while
			buf.clear();
			bytesRead = inChannel.read(buf);
		}//while
		
		aFile.close();
	}

}
