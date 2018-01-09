package cn.com.sysa.droidmvp.util;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

import cn.com.sysa.droidmvp.base.BaseApplication;

/**
 * 文件操作工具类
 * Created by LewJun on 2018/01/09.
 */
public class FileUtil {
    /**
     * @return 有效的下载路径
     */
    public static String getDownloadPath() {
        String ret = BaseApplication.getContext().getCacheDir().getPath();
        // 判断sd卡是否可用，并判断剩余空间是否大于100M
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File path = Environment.getExternalStorageDirectory();
            StatFs statFs = new StatFs(path.getPath());
            //获取单个数据块的大小(Byte)
            long blockSize = statFs.getBlockSize();
            //空闲的数据块的数量
            long freeBlocks = statFs.getAvailableBlocks();
            //返回SD卡空闲大小
            //return freeBlocks * blockSize;  //单位Byte
            //return (freeBlocks * blockSize)/1024;   //单位KB
//            return (freeBlocks * blockSize)/1024 /1024; //单位MB
            long free = (freeBlocks * blockSize) / 1024 / 1024;
            if (free >= 100) { // 如果大于100M
                ret = Environment.getDataDirectory().getPath();
            }
        }
        return ret;
    }
}
