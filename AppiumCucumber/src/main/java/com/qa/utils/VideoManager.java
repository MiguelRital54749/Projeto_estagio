package com.qa.utils;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;

public class VideoManager {
    TestUtils utils = new TestUtils();

    public void startRecording() throws Exception {
        ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws Exception {
        GlobalParams parms = new GlobalParams();
        String media =((CanRecordScreen)new DriverManager().getDriver()).stopRecordingScreen();
        String dirPath = parms.getPlatformName() + "_"
                + parms.getDeviceName() + File.separator + "Videos";

        File videoDir = new File(dirPath);

        synchronized (videoDir){
            if(!videoDir.exists()){
                videoDir.mkdir();
            }
            FileOutputStream stream = null;
            try{
                stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
                stream.write(Base64.decodeBase64(media));
                stream.close();
            }catch(Exception e){
                System.out.println(("error"));
            }finally {
                if(stream != null){
                    stream.close();
                }
            }
        }

    }
}
