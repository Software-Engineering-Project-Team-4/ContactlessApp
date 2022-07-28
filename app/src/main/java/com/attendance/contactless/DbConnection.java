package com.attendance.contactless;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DbConnection {

    private static DbConnection mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private DbConnection(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }
    private RequestQueue getRequestQueue(){
        if(requestQueue==null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        return requestQueue;
    }
    public static synchronized DbConnection getInstance(Object context){
        if(mInstance==null){
            mInstance = new DbConnection ((Context) context);
        }
        return mInstance;
    }
    public<T> void addToRequestQue(Request<T> request){
        getRequestQueue().add(request);
    }
}
