package com.bestlove.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 分辨率太小或者太大都不适合
 * @use java给图片添加水印文字
 * @JDK 1.8.0 </br>
 * @Version 1.0 </br>
 */
public class WaterMarkUtils {
	
	public static void main(String[] args) {
		// 遍历文件夹，获取图片文件，获取其名字和图片类型
		File file = new File("F:/luna/FirstDemo/");//文件夹或文件名
		print(file);
	}
	
	//遍历文件夹，找出文件夹下所有的图片
	public static void print(File file) {
		if (file == null || !file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				//回调
				print(f);
			}
		} else {
			FileInputStream is=null;
			try {
				is = new FileInputStream(file.getAbsoluteFile());
				String type = getTypeByStream(is);
				if ("jpg,png,gif,tif,bmp".indexOf(type) != -1) {
					System.out.println("图片绝对路径：" + file.getAbsolutePath());
					System.out.println("图片类型：" + type);
					new WaterMarkUtils()
							.mark(file.getAbsolutePath(), file.getParent()
									+ File.separator + "new_" + file.getName(),
									Color.RED, "@最爱导航网", type);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				if(is!=null){
					try {
						//关闭流
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	/**
	 * 根据文件流读取图片文件真实类型
	 * 
	 * @param is
	 * @return
	 */
	public static String getTypeByStream(FileInputStream is) {
		byte[] b = new byte[4];
		try {
			is.read(b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String type = bytesToHexString(b).toUpperCase();
		if (type.contains("FFD8FF")) {
			return "jpg";
		} else if (type.contains("89504E47")) {
			return "png";
		} else if (type.contains("47494638")) {
			return "gif";
		} else if (type.contains("49492A00")) {
			return "tif";
		} else if (type.contains("424D")) {
			return "bmp";
		}
		return type;
	}
	
	
	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath
	 *            需要添加水印的图片的路径
	 * @param outImgPath
	 *            添加水印后图片输出路径
	 * @param markContentColor
	 *            水印文字的颜色
	 * @param waterMarkContent
	 *            水印的文字
	 */
	public void mark(String srcImgPath, String outImgPath,
			Color markContentColor, String waterMarkContent, String imageType) {
		try {
			// 读取原图片信息
			File srcImgFile = new File(srcImgPath);
			Image srcImg = ImageIO.read(srcImgFile);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			Font font = new Font("楷体", Font.PLAIN, srcImgHeight / 30);//字体大小依据图片大小而定
			g.setColor(markContentColor); // 根据图片的背景设置水印颜色
			g.setFont(font);
			int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
			int y = srcImgHeight - srcImgHeight / 30;
			g.drawString(waterMarkContent, srcImgHeight / 30, y);//文字放在左下角
			g.dispose();
			// 输出图片
			FileOutputStream outImgStream = new FileOutputStream(outImgPath);
			ImageIO.write(bufImg, imageType, outImgStream);
			outImgStream.flush();
			outImgStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取水印文字总长度
	 * 
	 * @param waterMarkContent
	 *            水印的文字
	 * @param g
	 * @return 水印文字总长度
	 */
	public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
		return g.getFontMetrics(g.getFont()).charsWidth(
				waterMarkContent.toCharArray(), 0, waterMarkContent.length());
	}
}