package com.gxf.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class NIOCopyFile {
	public static void main(String args[]) throws IOException{
		String fromFilePath = "C:/Users/GXF/Desktop/�ҹ���/�澭.txt";
		String toFilePath = "C:/Users/GXF/Desktop/�ҹ���/�澭1.txt";
		
		RandomAccessFile fromFile = new RandomAccessFile(fromFilePath, "rw");
		RandomAccessFile toFile = new RandomAccessFile(toFilePath, "rw");
		
		FileChannel fromChannel = fromFile.getChannel();
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);
		
		fromFile.close();
		toFile.close();
		
		System.out.println("Copy Finished!");
	}
}
