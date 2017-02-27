package com.dexprotector.aar.lib.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dexprotector.aar.lib.SayHelloWorld;

public class SayHelloWorldImpl extends SayHelloWorld {

    String world = null;

    public SayHelloWorldImpl(Context ctx) {
        Resources resources = ctx.getResources();
        AssetManager assetManager = resources.getAssets();
        try {
            InputStream inputStream = assetManager.open("test.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            world = properties.getProperty("world");
            inputStream.close();
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String sayHelloWorld() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append(world);
        sb.append(" !");
       return sb.toString();
    }
}
