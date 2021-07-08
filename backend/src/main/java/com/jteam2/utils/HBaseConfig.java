package com.jteam2.utils;

import com.jteam2.service.HBaseService;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HBaseConfig {
    /** Create config */
    @Bean
    public HBaseService getHbaseService() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        return new HBaseService(conf);
    }
}
