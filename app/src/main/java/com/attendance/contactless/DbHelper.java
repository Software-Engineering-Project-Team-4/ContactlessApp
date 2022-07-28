package com.attendance.contactless;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DbHelper<RecyclerAdapter> {
    EditText Name;

    public DbHelper(DbHelper<RecyclerAdapter> recyclerAdapterDbHelper) {
    }

    private void readFromLocalStorage(){
    ArraySet<Object> arrayList = null;
    arrayList.clear();
        DbHelper dbHelper = new DbHelper(DbHelper.this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = dbHelper.readFromLocalDatabase(database);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DbContract.NAME));
            @SuppressLint("Range") String sync_status = cursor.getString(cursor.getColumnIndex(DbContract.SYNC_STATUS));
            arrayList.add(new Context() {
                @Override
                public AssetManager getAssets() {
                    return null;
                }

                @Override
                public Resources getResources() {
                    return null;
                }

                @Override
                public PackageManager getPackageManager() {
                    return null;
                }

                @Override
                public ContentResolver getContentResolver() {
                    return null;
                }

                @Override
                public Looper getMainLooper() {
                    return null;
                }

                @Override
                public Context getApplicationContext() {
                    return null;
                }

                @Override
                public void setTheme(int i) {

                }

                @Override
                public Resources.Theme getTheme() {
                    return null;
                }

                @Override
                public ClassLoader getClassLoader() {
                    return null;
                }

                @Override
                public String getPackageName() {
                    return null;
                }

                @Override
                public ApplicationInfo getApplicationInfo() {
                    return null;
                }

                @Override
                public String getPackageResourcePath() {
                    return null;
                }

                @Override
                public String getPackageCodePath() {
                    return null;
                }

                @Override
                public SharedPreferences getSharedPreferences(String s, int i) {
                    return null;
                }

                @Override
                public boolean moveSharedPreferencesFrom(Context context, String s) {
                    return false;
                }

                @Override
                public boolean deleteSharedPreferences(String s) {
                    return false;
                }

                @Override
                public FileInputStream openFileInput(String s) throws FileNotFoundException {
                    return null;
                }

                @Override
                public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
                    return null;
                }

                @Override
                public boolean deleteFile(String s) {
                    return false;
                }

                @Override
                public File getFileStreamPath(String s) {
                    return null;
                }

                @Override
                public File getDataDir() {
                    return null;
                }

                @Override
                public File getFilesDir() {
                    return null;
                }

                @Override
                public File getNoBackupFilesDir() {
                    return null;
                }

                @Nullable
                @Override
                public File getExternalFilesDir(@Nullable String s) {
                    return null;
                }

                @Override
                public File[] getExternalFilesDirs(String s) {
                    return new File[0];
                }

                @Override
                public File getObbDir() {
                    return null;
                }

                @Override
                public File[] getObbDirs() {
                    return new File[0];
                }

                @Override
                public File getCacheDir() {
                    return null;
                }

                @Override
                public File getCodeCacheDir() {
                    return null;
                }

                @Nullable
                @Override
                public File getExternalCacheDir() {
                    return null;
                }

                @Override
                public File[] getExternalCacheDirs() {
                    return new File[0];
                }

                @Override
                public File[] getExternalMediaDirs() {
                    return new File[0];
                }

                @Override
                public String[] fileList() {
                    return new String[0];
                }

                @Override
                public File getDir(String s, int i) {
                    return null;
                }

                @Override
                public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory) {
                    return null;
                }

                @Override
                public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory, @Nullable DatabaseErrorHandler databaseErrorHandler) {
                    return null;
                }

                @Override
                public boolean moveDatabaseFrom(Context context, String s) {
                    return false;
                }

                @Override
                public boolean deleteDatabase(String s) {
                    return false;
                }

                @Override
                public File getDatabasePath(String s) {
                    return null;
                }

                @Override
                public String[] databaseList() {
                    return new String[0];
                }

                @Override
                public Drawable getWallpaper() {
                    return null;
                }

                @Override
                public Drawable peekWallpaper() {
                    return null;
                }

                @Override
                public int getWallpaperDesiredMinimumWidth() {
                    return 0;
                }

                @Override
                public int getWallpaperDesiredMinimumHeight() {
                    return 0;
                }

                @Override
                public void setWallpaper(Bitmap bitmap) throws IOException {

                }

                @Override
                public void setWallpaper(InputStream inputStream) throws IOException {

                }

                @Override
                public void clearWallpaper() throws IOException {

                }

                @Override
                public void startActivity(Intent intent) {

                }

                @Override
                public void startActivity(Intent intent, @Nullable Bundle bundle) {

                }

                @Override
                public void startActivities(Intent[] intents) {

                }

                @Override
                public void startActivities(Intent[] intents, Bundle bundle) {

                }

                @Override
                public void startIntentSender(IntentSender intentSender, @Nullable Intent intent, int i, int i1, int i2) throws IntentSender.SendIntentException {

                }

                @Override
                public void startIntentSender(IntentSender intentSender, @Nullable Intent intent, int i, int i1, int i2, @Nullable Bundle bundle) throws IntentSender.SendIntentException {

                }

                @Override
                public void sendBroadcast(Intent intent) {

                }

                @Override
                public void sendBroadcast(Intent intent, @Nullable String s) {

                }

                @Override
                public void sendOrderedBroadcast(Intent intent, @Nullable String s) {

                }

                @Override
                public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String s, @Nullable BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s1, @Nullable Bundle bundle) {

                }

                @Override
                public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {

                }

                @Override
                public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, @Nullable String s) {

                }

                @Override
                public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, @Nullable String s, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s1, @Nullable Bundle bundle) {

                }

                @Override
                public void sendStickyBroadcast(Intent intent) {

                }

                @Override
                public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s, @Nullable Bundle bundle) {

                }

                @Override
                public void removeStickyBroadcast(Intent intent) {

                }

                @Override
                public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {

                }

                @Override
                public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i, @Nullable String s, @Nullable Bundle bundle) {

                }

                @Override
                public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {

                }

                @Nullable
                @Override
                public Intent registerReceiver(@Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
                    return null;
                }

                @Nullable
                @Override
                public Intent registerReceiver(@Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
                    return null;
                }

                @Nullable
                @Override
                public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable String s, @Nullable Handler handler) {
                    return null;
                }

                @Nullable
                @Override
                public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable String s, @Nullable Handler handler, int i) {
                    return null;
                }

                @Override
                public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {

                }

                @Nullable
                @Override
                public ComponentName startService(Intent intent) {
                    return null;
                }

                @Nullable
                @Override
                public ComponentName startForegroundService(Intent intent) {
                    return null;
                }

                @Override
                public boolean stopService(Intent intent) {
                    return false;
                }

                @Override
                public boolean bindService(Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
                    return false;
                }

                @Override
                public void unbindService(@NonNull ServiceConnection serviceConnection) {

                }

                @Override
                public boolean startInstrumentation(@NonNull ComponentName componentName, @Nullable String s, @Nullable Bundle bundle) {
                    return false;
                }

                @Override
                public Object getSystemService(@NonNull String s) {
                    return null;
                }

                @Nullable
                @Override
                public String getSystemServiceName(@NonNull Class<?> aClass) {
                    return null;
                }

                @Override
                public int checkPermission(@NonNull String s, int i, int i1) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkCallingPermission(@NonNull String s) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkCallingOrSelfPermission(@NonNull String s) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkSelfPermission(@NonNull String s) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public void enforcePermission(@NonNull String s, int i, int i1, @Nullable String s1) {

                }

                @Override
                public void enforceCallingPermission(@NonNull String s, @Nullable String s1) {

                }

                @Override
                public void enforceCallingOrSelfPermission(@NonNull String s, @Nullable String s1) {

                }

                @Override
                public void grantUriPermission(String s, Uri uri, int i) {

                }

                @Override
                public void revokeUriPermission(Uri uri, int i) {

                }

                @Override
                public void revokeUriPermission(String s, Uri uri, int i) {

                }

                @Override
                public int checkUriPermission(Uri uri, int i, int i1, int i2) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkCallingUriPermission(Uri uri, int i) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkCallingOrSelfUriPermission(Uri uri, int i) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public int checkUriPermission(@Nullable Uri uri, @Nullable String s, @Nullable String s1, int i, int i1, int i2) {
                    return PackageManager.PERMISSION_GRANTED;
                }

                @Override
                public void enforceUriPermission(Uri uri, int i, int i1, int i2, String s) {

                }

                @Override
                public void enforceCallingUriPermission(Uri uri, int i, String s) {

                }

                @Override
                public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s) {

                }

                @Override
                public void enforceUriPermission(@Nullable Uri uri, @Nullable String s, @Nullable String s1, int i, int i1, int i2, @Nullable String s2) {

                }

                @Override
                public Context createPackageContext(String s, int i) throws PackageManager.NameNotFoundException {
                    return null;
                }

                @Override
                public Context createContextForSplit(String s) throws PackageManager.NameNotFoundException {
                    return null;
                }

                @Override
                public Context createConfigurationContext(@NonNull Configuration configuration) {
                    return null;
                }

                @Override
                public Context createDisplayContext(@NonNull Display display) {
                    return null;
                }

                @Override
                public Context createDeviceProtectedStorageContext() {
                    return null;
                }

                @Override
                public boolean isDeviceProtectedStorage() {
                    return false;
                }
            });
        }
    ArrayAdapter<Object> adapter = null;
    adapter.notifyDataSetChanged();
        cursor.close();
        dbHelper.close();
}

    private void close() {
    }

    private Cursor readFromLocalDatabase(SQLiteDatabase database) {
        return null;
    }

    private SQLiteDatabase getReadableDatabase() {
        return null;
    }

    private <MySingleton> void saveToAppServer(String name){

                if(checkNetworkConnection()){
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String Response = jsonObject.getString("response");
                                        if(Response.equals("OK")) {
                                            saveToLocalStorage(name,DbContract.SYNC_STATUS_OK);
                                        }
                                        else{
                                           saveToLocalStorage(name,DbContract.SYNC_STATUS_FAILED);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            saveToLocalStorage(name,DbContract.SYNC_STATUS_FAILED);
                        }
                }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                           Map<String, String> params = new HashMap<>();
                           params.put("name",name);
                            return params;
                        }
                    };
                DbConnection.getInstance(DbHelper.this);
                }
        else{
            saveToLocalStorage(name,DbContract.SYNC_STATUS_FAILED);
                }

    }
    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && ((NetworkInfo) networkInfo).isConnected());
    }

    private Object getSystemService(String connectivityService) {
        return null;
    }

    private void saveToLocalStorage(String name, int sync){
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase database = dbHelper.getWriteableDatabase();
        dbHelper.saveToLocalDatabase(name,sync,database);
        readFromLocalStorage();
        dbHelper.close();
    }

    private void saveToLocalDatabase(String name, int sync, SQLiteDatabase database) {
    }

    private SQLiteDatabase getWriteableDatabase() {
        return null;
    }
}
