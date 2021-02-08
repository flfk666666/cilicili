package com.aaa.config;

import java.net.InetAddress;

public class ipconfig {

    public static String getip(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
        String hostAddress = address.getHostAddress();

        return hostAddress;
    }
}
