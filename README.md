# emptyxxl

A empty xxl-job executor for Shell or other GLUE actions

## Configuration

Put a configuration file `xxl-job-executor.properties` in the current working directory.

```properties
xxl.job.admin.addresses=http://localhost:8080/xxl-job-admin
xxl.job.accessToken=hello
xxl.job.executor.appname=emptyxxl
xxl.job.executor.address=10.10.1.1
xxl.job.executor.ip=0.0.0.0
xxl.job.executor.port=9999
xxl.job.executor.logpath=/data/applogs/emptyxxl
xxl.job.executor.logretentiondays=3
```

You can also supply with java system properties.

```shell
java -Dxxl.job.admin.addresses=http://localhost:8080/xxl-job-admin \
     -Dxxl.job.accessToken=hello \
     -Dxxl.job.executor.appname=emptyxxl \
     -Dxxl.job.executor.address=0.0.0.0 \
     ... \
     -jar emptyxxl.jar
```

## Credits

GUO YANKE, MIT License
