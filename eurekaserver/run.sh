#!/bin/bash
echo "export LANG=en_US.UTF-8" >> /etc/profile
source /etc/profile
SPRINT_BOOT_WORKSPACE="/data"
if [  "$ACTIVE" ]; then
        export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=$ACTIVE"
else
        export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=test"
fi

JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -XX:NewRatio=2 -XX:MaxGCPauseMillis=200 -verbose:gc -Xloggc:$LOG_HOME/gc.log "

if [ -n "$XMX" ]; then
    JAVA_MEM_OPTS="  -Xmx$XMX -Xms$XMS "
else
    JAVA_MEM_OPTS="  -Xmx2g -Xms2g "
fi


echo -e "Starting the Server ...\c"
mkdir -p $LOG_HOME
echo "" >>$LOG_HOME/gc.log
java $JAVA_OPTS $JAVA_MEM_OPTS -jar /data/$JOB --server.port=$PORT