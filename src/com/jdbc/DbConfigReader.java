package com.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfigReader {
	
	private Properties prop;

	public DbConfigReader() {
		this.read();
	}

	/**
	 * 读取配置文件
	 */
	private void read(){
		// A.
		prop = new Properties();
		
		// B.1
		InputStream is = DbConfigReader.class.getResourceAsStream("/dbConfig.properties");
		
		// B.2
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据键取值
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		return prop.getProperty(key);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DbConfigReader d = new DbConfigReader();
		//d.read();	
		System.out.println(d.getValue("driver"));
	}

}
