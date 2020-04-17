<?xml version="1.0" encoding="UTF-8"?>
 <configuration>
     <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter" />
    <conversionRule conversionWord="wex" converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter" />
    <conversionRule conversionWord="wEx" converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter" />
    <property name="CONSOLE_LOG_PATTERN" value="${r'${CONSOLE_LOG_PATTERN:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}'}"/>
    <property name="FILE_LOG_PATTERN" value="${r'${FILE_LOG_PATTERN:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}'}"/>
    <property name="appName" value="${artifactId}"/>
    <!-- 测试环境+开发环境. 多个使用逗号隔开. -->
    <springProfile name="dev">
    	<!--输出到控制台-->
        <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <pattern>${r'${CONSOLE_LOG_PATTERN}'}</pattern>
            </encoder>
        </appender>
        <!--按天生成日志-->
        <appender name="logFile"  class="ch.qos.logback.core.rolling.RollingFileAppender">
            <Prudent>true</Prudent>
            <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
                <FileNamePattern>
                    D:/${artifactId}log/${r'${appName}'}-dev-%d{yyyy-MM-dd}.%i.log
                </FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>15</MaxHistory>
                <maxFileSize>10MB</maxFileSize>
            </rollingPolicy>
            <encoder>
                <pattern>${r'${FILE_LOG_PATTERN}'}</pattern>
            </encoder>
        </appender>
        <logger name="org.springframework.boot" level="debug" additivity="false">
            <appender-ref ref="console"/>
            <appender-ref ref="logFile" />
        </logger>
        <logger name="root" level="info" additivity="false">
            <appender-ref ref="console"/>
            <appender-ref ref="logFile" />
        </logger>
    </springProfile>
    <springProfile name="prod">
        <!--按天生成日志-->
        <appender name="logFile"  class="ch.qos.logback.core.rolling.RollingFileAppender">
            <Prudent>true</Prudent>
            <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
                <FileNamePattern>
                    /usr/${artifactId}log/${r'${appName}'}-prod-%d{yyyy-MM-dd}.%i.log
                </FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>15</MaxHistory>
                <maxFileSize>10MB</maxFileSize>
            </rollingPolicy>
            <encoder>
                <pattern>${r'${FILE_LOG_PATTERN}'}</pattern>
            </encoder>
        </appender>

        <logger name="root" level="error" additivity="false">
            <appender-ref ref="logFile" />
        </logger>

        <logger name="org.springframework.boot" level="error" additivity="false">
            <appender-ref ref="logFile" />
        </logger>
    </springProfile>
</configuration>