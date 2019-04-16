package com.dayuanit.car.util;

import java.util.HashMap;

public class UtilsFactory {
    protected static PointFileUtils pointFileUtils = new PointFileUtils();
    protected static PointSQLUtils pointSQLUtils = new PointSQLUtils();

    protected static HashMap<String,Utils> utilsHashMap = new HashMap<>();

    static {
        utilsHashMap.put("file",pointFileUtils);
        utilsHashMap.put("database",pointSQLUtils);
    }

    public Utils getUtiles(String way){

        return utilsHashMap.get(way);
    }
}
