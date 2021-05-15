package com.mindia.almacen.utils;


public class QrId {
	public final int id;
	public final String value;
	
	public QrId(String qr) {
		String[] ident = qr.split("-");
		
		this.value = ident[0];
		this.id = Integer.parseInt(ident[1]);
	}
}
