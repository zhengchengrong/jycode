package com.jy.downloaderlib.model;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

/**
 * Created by long on 2016/5/26.
 * 文件工具类
 */
public class FileUtils {

    private FileUtils() {
        throw new RuntimeException("FileUtils cannot be initialized!");
    }

    /**
     * 获取随机存取文件
     * @param path  文件路径
     * @param loadBytes 文件已下载大小
     * @param totalBytes    文件总大小
     * @return  文件
     * @throws IOException
     */
    public static RandomAccessFile getRandomAccessFile(String path, int loadBytes, int totalBytes) throws IOException {
        if (TextUtils.isEmpty(path)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(path); // 找到该文件
            if (file.exists() && file.isDirectory()) { // 如果文件是目录，抛出异常
                throw new RuntimeException(
                        formatString("found invalid internal destination path[%s]," +
                                " & path is directory[%B]", path, file.isDirectory()));
        }
        if (!file.exists()) { // 如果文件不存在  创建
            if (!file.createNewFile()) { // 如果不能创建 抛出异常
                throw new IOException(formatString("create new file error %s",
                        file.getAbsolutePath()));
            }
        }
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw"); // 创建一个文件随机存取类
        if (totalBytes > 0) { //如果下载的文件有内容
            final long breakpointBytes = accessFile.length();//得到已经下载文件的长度
            final long requiredSpaceBytes = totalBytes - breakpointBytes; //用整个文件的长度 -  已经下载的长度 = 剩余需要多少空间
            final long freeSpaceBytes = getFreeSpaceBytes(path); //  得到剩余的内存空间大小
            if (freeSpaceBytes < requiredSpaceBytes) { // 如果剩余的内存空间大小小于 文件需要的空间大小，则抛出内存不足异常
                accessFile.close();
                // throw a out of space exception.
                throw new RuntimeException( // 内存不足的异常。
                        formatString("The file is too large to store, breakpoint in bytes: " +
                        " %d, required space in bytes: %d, but free space in bytes: " +
                        "%d", breakpointBytes, requiredSpaceBytes, freeSpaceBytes));
            } else {
                // pre allocate.
                accessFile.setLength(totalBytes); // 设置文件的大小
            }
        }
        if (loadBytes > 0) { //如果已经加载了数据，从loadBytes的位置开始写入
            accessFile.seek(loadBytes);
        }
        return accessFile;
    }

    /**
     * 格式化字符串
     * @param msg   格式数据
     * @param args  参数
     * @return  格式化字符串
     */
    public static String formatString(final String msg, Object... args) {
        return String.format(Locale.ENGLISH, msg, args);
    }

    /**
     * 获取空闲的空间大小
     * @param path  文件路径
     * @return  空间大小
     */
    public static long getFreeSpaceBytes(final String path) {
        long freeSpaceBytes;
        final StatFs statFs = new StatFs(path);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            freeSpaceBytes = statFs.getAvailableBytes();
        } else {
            //noinspection deprecation
            freeSpaceBytes = statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
        }

        return freeSpaceBytes;
    }
}
