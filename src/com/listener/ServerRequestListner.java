package com.listener;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServerRequestListner implements ServletRequestListener{

	static int requestCount;
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request Destroyed "+new Date());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("Request Generated "+new Date());
		requestCount++;
		System.out.println("Request COunter : "+requestCount);
	}
	public static int requestCount() {
		return requestCount;
	}
	
}