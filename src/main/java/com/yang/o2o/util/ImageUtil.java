package com.yang.o2o.util;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yang.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	public static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

	/**
	 * 将commonsMultipartFile转换成File类
	 * 
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;

	}

	/**
	 * 处理缩略图，并返回新生成图片的相对值路径
	 * 
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is:" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File("E:/test/测试管理平台/o2o/src/main/resources/watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			// TODO: handle exception
			logger.error(e.toString());
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	/**
	 * 处理详情图，并返回新生成图片的相对路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is:" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(337, 640)
					.watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File("E:/test/测试管理平台/o2o/src/main/resources/watermark.jpg")), 0.25f)
					.outputQuality(0.9f).toFile(dest);
		} catch (IOException e) {
			// TODO: handle exception
			logger.error(e.toString());
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}

	/**
	 * 获取输入文件流的扩展名
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 创建目标路径所涉及的目录
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 生成随机文件名，当前年月日小时分钟秒钟+五伪随机数
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static String getRandomFileName() {
		// 获取随即五位数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;

	}

	public static void main(String[] args) throws IOException {
		String decodeStr = URLDecoder.decode(basePath, "utf-8");
		System.out.println(decodeStr);
		Thumbnails.of(new File("c:/Users/asus/Desktop/test.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(decodeStr + "watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("C:/Users/asus/Desktop/testNREW.jpg");
	}
	/*
	 * public static void main(String[] args) throws IOException { String basePath =
	 * Thread.currentThread().getContextClassLoader().getResource("").getPath();
	 * Thumbnails.of(new File("/Users/asus/Desktop/test.png")).size(200, 200)
	 * .watermark(Positions.BOTTOM_RIGHT,
	 * 
	 * ImageIO.read( new File(basePath + "/watermark.png")), 0.25f)
	 * .outputQuality(0.8f).toFile("/Users/asus/Desktop/testNREW.png");
	 * 
	 * E:\test\测试管理平台\o2o\src\main\resources\watermark.jpg
	 * 
	 * .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath +
	 * "/watermark.jpg")), 0.25f)
	 * 
	 * 
	 * }
	 */
	/**
	 * storePath是文件的路径还是目录的路径，如果是文件路径就删除该文件
	 * 如果是目录路径就删除该目录下所有文件
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for(int i = 0;i <= files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
