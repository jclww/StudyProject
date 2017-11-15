package com.lww.myLog.log.serializer;

/**
 * Created by Lww on 2017/11/9.
 */
public abstract class BasicDataSerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        return this.getBasicDataTypeString(object);
    }

    public abstract StringBuffer getBasicDataTypeString(Object object);
}
