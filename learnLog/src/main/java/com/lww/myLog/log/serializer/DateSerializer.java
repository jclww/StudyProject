package com.lww.myLog.log.serializer;

import java.util.Date;

/**
 * Created by Lww on 2017/11/10.
 */
public class DateSerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        Date date = (Date) object;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(date.getTime());
        return stringBuffer;
    }
}
