package com.safziy.service.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DeCodeTest {
	public static void main(String[] args) {
		try {
			String str = URLDecoder
					.decode("{ Key-\u003esafziy:DCParamStr-\u003einstall_key\u003dE59AE64D-C290-4EAB-A430-D1C1504F9AE3\u0026mac\u003d020000000000\u0026udid\u003d06C9584A-B8FD-4990-9170-7484BB01DCB3\u0026gameversion\u003d1.4.20\u0026clienttype\u003diPhone8_1\u0026clientversion\u003d9.1\u0026channel_id\u003dFJM_TEST_CCCCC\u0026networktype\u003dWIFI\u0026clientpixel\u003d1334*750\u0026serial_number\u003d\u0026android_id\u003d\u0026google_aid\u003d\u0026location\u003dcn\u0026src\u003dapple\u0026equipment\u003dnocrack\u0026carrier\u003d中国电信\u0026idfa\u003d02ACBB9F-8E41-4915-AC60-2FA0295CDC1D\u0026simulator\u003d0\u0026WifiMac\u003da46c2a681aef\u0026BootTime\u003d0\u0026unique_key\u003dlangyabang_ioscn_prod:Pwd-\u003emysafziy:PlatformId-\u003e100 }",
							"UTF-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
