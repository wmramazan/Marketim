package com.example.marketim.util

import android.util.Log
import timber.log.Timber

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG)
            return

        // FirebaseCrash.report(message);
        // FirebaseCrash.report(new Exception(message));
    }

}