package com.ice.wenjuandiaocha.tool;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by ice on 2016/2/22.
 */
public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private static int msgid = 1000;

    private VolleySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

//        mImageLoader = new ImageLoader(mRequestQueue,
//                new ImageLoader.ImageCache() {
//                    private final LruCache<String, Bitmap>
//                            cache = new LruCache<String, Bitmap>(20);
//
//                    @Override
//                    public Bitmap getBitmap(String url) {
//                        return cache.get(url);
//                    }
//
//                    @Override
//                    public void putBitmap(String url, Bitmap bitmap) {
//                        cache.put(url, bitmap);
//                    }
//                });
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }


    public static int getMsgid() {
        return msgid++;
    }


    public void sendSimplePost(String cmd, final String successText, final String failText, String VOLLEY_TAG, final boolean flag) {
        HashMap map = new HashMap<>();
        map.put("type", "cmd");
        map.put("target", ServerConfig.TARGET);
        map.put("uid", ServerConfig.UID);
        map.put("msgid", VolleySingleton.getMsgid());
        map.put("key", ServerConfig.KEY);
        map.put("cmd", cmd);
        JSONObject params = new JSONObject(map);

        Log.d("TAG", params.toString());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, ServerConfig.SERVERURL, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", response.toString());
                try {

                    String resp = response.getString("resp");
                    if (flag) {
                        if (resp.equals("Success")) {
                            Toast.makeText(mCtx, successText, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mCtx, failText, Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        jsonObjectRequest.setTag(VOLLEY_TAG);
        mRequestQueue.add(jsonObjectRequest);
    }
}
