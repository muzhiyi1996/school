package com.yang.o2o.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");
	
	public static String getImgBasePath() {
		String oString = System.getProperty("os.name");
		String basePath = "";
		if(oString.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image";
		}else {
			basePath = "/home/yangshengbei/image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/"+ shopId +"/";
		return imagePath.replace("/", seperator);
	}
}
