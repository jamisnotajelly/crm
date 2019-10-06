import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO

def appenderList = []
def consoleAppender = false
def rollingAppender = false
def WEBAPP_DIR

if (hostname =~ /local/) {
    appenderList.add("CONSOLE")
    consoleAppender = true
} else {
    def catalinaBase = System.properties['catalina.base']
    if (catalinaBase != null) {
        appenderList.add("ROLLING")
        rollingAppender = true;
        WEBAPP_DIR = catalinaBase
    }
}

if (consoleAppender) {
    appender("CONSOLE", ConsoleAppender) {
        encoder(PatternLayoutEncoder) {
            pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
        }
    }
}
if (rollingAppender) {
    appender("ROLLING", RollingFileAppender) {
        encoder(PatternLayoutEncoder) {
            Pattern = "%d %level %thread %mdc %logger - %m%n"
        }
        rollingPolicy(TimeBasedRollingPolicy) {
            FileNamePattern = "${WEBAPP_DIR}/log/crm-%d{yyyy-MM-dd}.zip"
        }
    }
}
root(INFO, appenderList)
logger("org.hibernate", DEBUG)
logger("org.testcontainers", DEBUG)
