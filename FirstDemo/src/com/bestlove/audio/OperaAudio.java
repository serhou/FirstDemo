package com.bestlove.audio;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class OperaAudio {

	public static void main(String[] args) {
		
		
		//改名
		rename(new File("C:\\Users\\think\\Desktop\\123\\456"));
		//改标签
		print(new File("C:\\Users\\think\\Desktop\\123\\456"));

	}

	private static void rename(File file) {
		if (file == null || !file.exists()) {
			return;
		}

		if (file.isDirectory()) {

			File[] files = file.listFiles();
			for (File f : files) {
				rename(f);
			}
		} else {
			if(file.getName().startsWith("(")){
				//获取序号
				String no = file.getName().substring(1, file.getName().indexOf(") "));
				//处理序号
				System.out.println(no);
				for (int i = 3-no.length(); i > 0 ;i--) {
					no = "0" + no;
				}
				System.out.println(no);
				file.renameTo(new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf(file.getName())) + no + "." + file.getName().substring(file.getName().indexOf(") ")+1).trim()));
			}
		}		
	}

	public static void print(File file) {

		if (file == null || !file.exists()) {
			return;
		}

		if (file.isDirectory()) {

			File[] files = file.listFiles();
			for (File f : files) {
				print(f);
			}
		} else {
				try {
					AudioFile f = AudioFileIO.read(file);
					System.out.println(file.getName().substring(0, file.getName().length()-4));
					Tag tag = f.getTag();
					//设置
					tag.setField(FieldKey.ALBUM, "多情剑客无情剑");
					tag.setField(FieldKey.TITLE, file.getName().substring(0, file.getName().length()-4));
					tag.setField(FieldKey.ARTIST, "think");
					tag.setField(FieldKey.YEAR, "2016");
					f.commit();
				} catch (CannotWriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CannotReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TagException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ReadOnlyFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidAudioFrameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
