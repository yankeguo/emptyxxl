# emptyxxl

A empty xxl-job executor for Shell or other GLUE actions

## Configuration

Put a configuration file `xxl-job-executor.properties` in the same directory as the jar file.

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

## Credits

GUO YANKE, MIT License
