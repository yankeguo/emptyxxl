package com.yankeguo.emptyxxl;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.executor.impl.XxlJobSimpleExecutor;

class EmptyXxl {

    private static final String[] PROPERTIES_FILE_NAMES = {
            "xxl-job-executor.properties",
            "application.properties",
            Paths.get("config", "xxl-job-executor.properties").toString(),
            Paths.get("config", "application.properties").toString(),
    };

    private static Logger logger = LoggerFactory.getLogger(EmptyXxl.class);

    public static Properties loadProperties() {
        Properties props = new Properties();
        try {
            for (String fileName : PROPERTIES_FILE_NAMES) {
                try (FileInputStream fis = new FileInputStream(fileName);
                        InputStreamReader isr = new InputStreamReader(fis)) {
                    props.load(isr);
                }
            }
        } catch (Exception e) {
        }
        props.putAll(System.getProperties());
        return props;
    }

    public static XxlJobSimpleExecutor createExecutor(Properties props) {
        XxlJobSimpleExecutor exec = new XxlJobSimpleExecutor();
        exec.setAdminAddresses(props.getProperty("xxl.job.admin.addresses"));
        exec.setAccessToken(props.getProperty("xxl.job.accessToken"));
        exec.setAppname(props.getProperty("xxl.job.executor.appname"));
        exec.setAddress(props.getProperty("xxl.job.executor.address"));
        exec.setIp(props.getProperty("xxl.job.executor.ip"));
        exec.setPort(Integer.valueOf(props.getProperty("xxl.job.executor.port")));
        exec.setLogPath(props.getProperty("xxl.job.executor.logpath"));
        exec.setLogRetentionDays(Integer.valueOf(props.getProperty("xxl.job.executor.logretentiondays")));
        return exec;
    }

    private XxlJobExecutor executor = null;

    public void start() throws Exception {
        if (this.executor != null) {
            throw new IllegalStateException("Executor already started");
        }
        logger.info("Starting executor");
        this.executor = createExecutor(loadProperties());
        this.executor.start();
    }

    public void stop() {
        if (this.executor != null) {
            logger.info("Stopping executor");
            this.executor.destroy();
            this.executor = null;
        }
    }

    public static void main(String[] args) throws Exception {
        EmptyXxl instance = new EmptyXxl();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            instance.stop();
        }));

        instance.start();

        while (true) {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}