package com.example.imageloader.cache;

import java.io.File;

import android.content.Context;

import com.example.imageloader.R;

/**
 * Created by Rajat Sangrame on 21/5/20.
 * http://github.com/rajatsangrame
 */
public class FileCache {

    private File cacheDir;

    public FileCache(Context context) {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir = new File(android.os.Environment.getExternalStorageDirectory(), context.getString(R.string.app_name));
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {
        String filename = String.valueOf(url.hashCode());
        return new File(cacheDir, filename);
    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }
}
