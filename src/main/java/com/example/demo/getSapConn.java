package com.example.demo;

import com.sap.conn.jco.ext.DestinationDataProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/30
 */
public class getSapConn {
    static String ABAP_AS_POOLED = "ABAP_PUBLIC_130_SAPJCO_POOL";
    private static void createDataFile(){
        Properties properties = new Properties();
        properties.setProperty(DestinationDataProvider.JCO_ASHOST, "xxx.xxx.x.xxx");
        properties.setProperty(DestinationDataProvider.JCO_SYSNR, "xx"); // 系统编号
        properties.setProperty(DestinationDataProvider.JCO_CLIENT, "xxx"); // 客户端编号
        properties.setProperty(DestinationDataProvider.JCO_USER, "xxxx"); // 用户名
        properties.setProperty(DestinationDataProvider.JCO_PASSWD, "xxxxxx"); // 密码
        properties.setProperty(DestinationDataProvider.JCO_LANG, "ZH");
        properties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "10");
        // JCO_POOL_CAPACITY - 空闲连接数，如果为0，则没有连接池效果，默认为1
        properties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "2");
        createDataFile(ABAP_AS_POOLED, "jcoDestination", properties);
    }

    static void createDataFile(String name, String suffix, Properties properties) {
        File cfg = new File(name + "." + suffix);
        if (!cfg.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(cfg, false);
                properties.store(fos, "for tests only !");
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
