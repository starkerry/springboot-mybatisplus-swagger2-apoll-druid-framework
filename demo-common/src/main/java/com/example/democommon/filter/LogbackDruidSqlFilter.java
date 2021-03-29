package com.example.democommon.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import cn.hutool.core.util.StrUtil;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
public class LogbackDruidSqlFilter extends Filter<ILoggingEvent>{
    @Override
    public FilterReply decide(ILoggingEvent e) {
        if(StrUtil.contains(e.getMessage(), "executed") && !StrUtil.contains(e.getMessage(), "millis")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }
}
