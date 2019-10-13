package edu.nhs.wsaams.commons;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

public class Utility {
    private static String applicationName = "wsaams";
    private static String version = "0.01v";

    public static String getCurrrentTimeStamp() {
        return new Timestamp(new Date().getTime()).toString();
    }

    public static String getApplication() {
        return applicationName + "-" + version;
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "UnknownHostException Occured";
        }
    }
}
