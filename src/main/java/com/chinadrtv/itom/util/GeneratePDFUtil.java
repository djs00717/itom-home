package com.chinadrtv.itom.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;


/**
 * 流转成byte,用于生成pdf
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-15 下午2:41:24
 */
public class GeneratePDFUtil {
	public static byte[] generatePdf(Blob blob) throws Exception {
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int rc = 0; 
		while ((rc = inputStream.read(buff, 0, 1024)) > 0) { 
			outputStream.write(buff, 0, rc); 
		} 
		byte[] bytes = outputStream.toByteArray();
		return bytes;
	}
	public static ByteArrayOutputStream generatePdfStream(Blob blob) throws Exception {
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int rc = 0; 
		while ((rc = inputStream.read(buff, 0, 1024)) > 0) { 
			outputStream.write(buff, 0, rc); 
		} 
		return outputStream;
	}
	
}
