package com.safziy.service.test;

import java.io.File;

import com.safziy.service.listener.InitListener;

public class RemoteTest {
	public static void main(String[] args) {
		InitListener.UPLOAD_FILE_PATH = "/data/safziy-service/upload_file_temp/";
		File file = new File(InitListener.UPLOAD_FILE_PATH);
		if(!file.exists()){
			file.mkdirs();
		}
		System.out.println(InitListener.UPLOAD_FILE_PATH);
	}
}
