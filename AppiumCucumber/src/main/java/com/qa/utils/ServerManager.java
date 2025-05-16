package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void starServer() throws Exception {
        //utils.log().info("starting appium server");
        AppiumDriverLocalService server = GetAppiumService();
        server.start();
        if(!server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!");
        }

        ServerManager.server.set(server);
        //utils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault(){
        return AppiumDriverLocalService.buildDefaultService();
    }
    public AppiumDriverLocalService GetAppiumService() throws  Exception{
        GlobalParams params = new GlobalParams();
        HashMap<String,String> environment = new HashMap<>();
        environment.put("PATH", "/Users/miguel.fernandes/Library/Android/sdk/platform-tools:/Users/miguel.fernandes/Library/Android/sdk/cmdline-tools:/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home/bin:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/appleinternal/bin:/Library/Apple/usr/bin:/opt/puppetlabs/bin");
        environment.put("ANDROID_HOME", "/Users/miguel.fernandes/Library/Android/sdk");
        environment.put("JAVA_HOME","/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home");
        AppiumDriverLocalService teste=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4724)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .withCapabilities(new CapabilitiesManager().getCaps()));
                //.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                //.withEnvironment(environment)
                //.withLogFile(new File(params.getPlatformName() + "-"
                  //      + params.getDeviceName() + File.separator +"Server.log")));

        return teste;
    }
}
