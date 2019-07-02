/*
 * Copyright 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pkware.truth.android.telephony;

import android.telephony.TelephonyManager;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    TelephonyManager.DATA_ACTIVITY_DORMANT,
    TelephonyManager.DATA_ACTIVITY_IN,
    TelephonyManager.DATA_ACTIVITY_INOUT,
    TelephonyManager.DATA_ACTIVITY_NONE,
    TelephonyManager.DATA_ACTIVITY_OUT
})
@Retention(SOURCE)
@interface TelephonyManagerDataActivity {
}
