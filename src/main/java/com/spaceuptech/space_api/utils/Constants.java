package com.spaceuptech.space_api.utils;

public class Constants {
    public static final String ALL = "all";
    public static final String ONE = "one";
    public static final String UPSERT = "upsert";
    public static final String CREATE = "create";
    public static final String DELETE = "delete";
    public static final String UPDATE = "update";
    public static final String COUNT = "count";
    public static final String DISTINCT = "distinct";

    public static final String TYPE_SERVICE_REGISTER = "service-register";
    public static final String TYPE_SERVICE_UNREGISTER = "service-unregister";
    public static final String TYPE_SERVICE_REQUEST = "service-request";

    public static final String TYPE_REALTIME_SUBSCRIBE = "realtime-subscribe";
    public static final String TYPE_REALTIME_UNSUBSCRIBE = "realtime-unsubscribe";
    public static final String TYPE_REALTIME_FEED = "realtime-feed";

    public static final String MONGO = "mongo";
    public static final String MYSQL = "sql-mysql";
    public static final String POSTGRES = "sql-postgres";

    public static final String TYPE_DELETE = "delete";
    public static final String TYPE_UPDATE = "update";
    public static final String TYPE_INSERT = "insert";
    public static final String TYPE_INITIAL = "initial";

    public static final int PAYLOAD_SIZE = 256 * 1024; // 256 kB
}
