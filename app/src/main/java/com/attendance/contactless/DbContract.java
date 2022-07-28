package com.attendance.contactless;

public class DbContract {
    public static final int SYNC_STATUS_OK = 0;
    public static final int SYNC_STATUS_FAILED = 1;
    public static final String SERVER_URL = "https://codd.cs.gsu.edu/~nnguyen133/phpMyAdmin/login.php";  //This is using GSU server, but sync is iffy works better on local WAMP server
    public static final String NAME = "name";
    public static final String SYNC_STATUS = "syncstatus";

    public DbContract(String name, String sync_status) {
    }
}
