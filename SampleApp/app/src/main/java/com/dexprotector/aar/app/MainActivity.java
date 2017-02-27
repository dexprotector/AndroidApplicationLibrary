package com.dexprotector.aar.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.dexprotector.aar.lib.SayHelloWorld;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            log("Calling Java implementation of SayHelloWorld:");
            SayHelloWorld sayHello = SayHelloWorld.init(this, false);
            log(sayHello.sayHelloWorld());
            log("Calling JNI implementation of SayHelloWorld:");
            sayHello = SayHelloWorld.init(this, true);
            log(sayHello.sayHelloWorld());
            log("Environment checks");
            log(SayHelloWorld.getCheckResults());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    void log(String msg) {
        TextView tv = (TextView) findViewById(R.id.text);
        tv.append(msg + "\n");
        System.out.println(msg);
    }

}
