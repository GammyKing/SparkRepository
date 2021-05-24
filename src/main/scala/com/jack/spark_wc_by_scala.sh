#!/bin/bash

# 配置成YARN配置文件存放目录
export HADOOP_CONF_DIR=<"hadoop conf的目录">
# spark-submit的目录
/usr/bin/spark-submit \
# 提交包中的类名
--class com.jack.SaprkWorkCount4Scala \
# 本地运行方式
--master local \
# 驱动器的内存
--driver-memory 512m \
# 执行器数量
--num-executors 2 \
# 输入要执行的jar包的位置
/home/xiehuazhen/sparkDemo/FirstSpark4Scala-assembly-0.1.0-SNAPSHOT.jar
# args(0)的参数传入
/home/xiehuazhen/sparkDemo/input.txt