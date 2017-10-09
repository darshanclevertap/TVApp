/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.app.darshan.tvapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.exceptions.CleverTapMetaDataNotFoundException;
import com.clevertap.android.sdk.exceptions.CleverTapPermissionsNotSatisfied;

/*
 * MainActivity class that loads MainFragment
 */
public class TVMainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    public static CleverTapAPI cleverTapAPI;
    private static String TAG = "TVApp";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvmain);
        try {
            //CleverTapAPI.setDebugLevel(1277182231);
            CleverTapAPI.setDebugLevel(3);
            cleverTapAPI = CleverTapAPI.getInstance(getApplicationContext());
            //MyApplication.startTimer();
            // cleverTapAPI.data.pushFcmRegistrationId(FirebaseInstanceId.getInstance().getToken(),true);

        } catch (CleverTapMetaDataNotFoundException e) {
            // thrown if you haven't specified your CleverTap Account ID or Token in your AndroidManifest.xml
            Log.e(TAG,e.toString());
        } catch (CleverTapPermissionsNotSatisfied e) {
            // thrown if you haven’t requested the required permissions in your AndroidManifest.xml
            Log.e(TAG,e.toString());
        }
    }
}
