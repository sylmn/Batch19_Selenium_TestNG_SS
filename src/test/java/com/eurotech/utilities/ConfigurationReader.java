package com.eurotech.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * Bu class configuration.properties dosyasında bulunan verileri okumaya yarar.
     */

    private static Properties properties;  //preperties'leri içinde key/value formatında saklayan yapı.

    static {
        try {
            // bilgilerin saklandığı dosyanın yolu
            String path = "configuration.properties";

            //burdaki dosyaları java için oku
            /**
             * FileInputStream -> Javaya dışarıdan veri almak için kullanılır
             * FileOutputStream - > Javadan dışaruya veri vermek için kullanılır.
             */
            FileInputStream input = new FileInputStream(path);

            //key/value yapısında bilgi tutan properties objemi instantiate edeyim
            properties = new Properties();

            //FIS ile okunan bilgileri properties'e yükleyelim.
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
