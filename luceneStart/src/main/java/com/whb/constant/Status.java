package com.whb.constant;

import java.util.concurrent.TimeUnit;

/**
 * 状态枚举
 */
public abstract class Status {
    /**
     * 过期时间相关枚举
     */
    public static enum ExpireEnum{
        //未读消息的有效期为30天
        UNREAD_MSG(30l, TimeUnit.DAYS);
        //过期时间
        private long time;
        //时间单位
        private TimeUnit timeUnit;

        ExpireEnum(long time,TimeUnit timeUnit){
            this.time = time;
            this.timeUnit = timeUnit;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
        }
    }

}
