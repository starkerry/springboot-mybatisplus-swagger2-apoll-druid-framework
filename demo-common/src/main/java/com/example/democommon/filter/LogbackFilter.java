package com.example.democommon.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
public class LogbackFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        String className = getClassName(event.getLoggerName());
        if(className.contains("Application")){
            return FilterReply.DENY;
        }else{
            return FilterReply.ACCEPT;
        }

    }

    public String getClassName(String className){
        className = className.substring(className.lastIndexOf(".")+1);
        return className;
    }
}
