package com.example.responseparsinghomework

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MyApplication: Application() {

    companion object {
        val TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    // for Volley
    var requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }
    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue!!.add(request)
    }
}