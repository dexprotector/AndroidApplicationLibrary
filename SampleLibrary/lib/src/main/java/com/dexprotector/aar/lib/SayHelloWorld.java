package com.dexprotector.aar.lib;

import android.content.Context;

import java.util.BitSet;

import com.dexprotector.aar.lib.internal.NativeSayHelloWorldImpl;
import com.dexprotector.aar.lib.internal.SayHelloWorldImpl;

public abstract class SayHelloWorld {

    enum ENV_CHECK {
        ROOT(0), DEBUG(1), EMULATOR(2);

        private final int idx;

        ENV_CHECK(final int newIdx) {
            idx = newIdx;
        }

        public int getValue() {
            return idx;
        }
    }

    static BitSet envChecks = new BitSet();


    public static SayHelloWorld init(Context ctx, boolean isNative) {
        doProbe(ctx);
        if (isNative) {
            return new NativeSayHelloWorldImpl(ctx);
        }
        return new SayHelloWorldImpl(ctx);
    }

    public static void doProbe(Context ctx) {
        System.out.println("doProbe" + ctx);
    }

    public static void positiveRootCheck(Object data) {
        System.out.println("positiveRootCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.ROOT.getValue());
    }

    public static void negativeRootCheck(Object data) {
        System.out.println("negativeRootCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.ROOT.getValue());
    }

    public static void positiveDebugCheck(Object data) {
        System.out.println("positiveDebugCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.DEBUG.getValue());
    }

    public static void negativeDebugCheck(Object data) {
        System.out.println("negativeDebugCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.DEBUG.getValue());
    }

    public static void positiveEmulatorCheck(Object data) {
        System.out.println("positiveEmulatorCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.EMULATOR.getValue());
    }

    public static void negativeEmulatorCheck(Object data) {
        System.out.println("negativeEmulatorCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.EMULATOR.getValue());
    }

    public abstract String sayHelloWorld();

    public static String getCheckResults(){
        StringBuilder sb = new StringBuilder();
        sb = sb.append("ROOT: "+envChecks.get(ENV_CHECK.ROOT.getValue()))
        .append("\n")
        .append("DEBUG: "+envChecks.get(ENV_CHECK.DEBUG.getValue()))
        .append("\n")
        .append("EMULATOR: "+envChecks.get(ENV_CHECK.EMULATOR.getValue()));
        return sb.toString();
    }

}
