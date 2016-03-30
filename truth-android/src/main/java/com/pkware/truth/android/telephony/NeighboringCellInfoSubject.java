/*
 * Copyright 2016 PKWARE, Inc.
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

import android.telephony.NeighboringCellInfo;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.telephony.TelephonyManagerSubject.networkTypeToString;

/**
 * Propositions for {@link NeighboringCellInfo} subjects.
 */
public class NeighboringCellInfoSubject extends Subject<NeighboringCellInfoSubject, NeighboringCellInfo> {
  protected NeighboringCellInfoSubject(FailureStrategy failureStrategy, NeighboringCellInfo subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<NeighboringCellInfoSubject, NeighboringCellInfo> type() {
    return new SubjectFactory<NeighboringCellInfoSubject, NeighboringCellInfo>() {
      @Override
      public NeighboringCellInfoSubject getSubject(FailureStrategy fs, NeighboringCellInfo that) {
        return new NeighboringCellInfoSubject(fs, that);
      }
    };
  }

  public NeighboringCellInfoSubject hasCid(int cid) {
    assertThat(getSubject().getCid())
        .named("CID")
        .isEqualTo(cid);
    return this;
  }

  public NeighboringCellInfoSubject hasLac(int lac) {
    assertThat(getSubject().getLac())
        .named("LAC")
        .isEqualTo(lac);
    return this;
  }

  public NeighboringCellInfoSubject hasNetworkType(@TelephonyManagerNetworkType int networkType) {
    int actualNetworkType = getSubject().getNetworkType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected network type <%s> but was <%s>.",
            networkTypeToString(networkType), networkTypeToString(actualNetworkType))
        .that(actualNetworkType)
        .isEqualTo(networkType);
    return this;
  }

  public NeighboringCellInfoSubject hasPsc(int psc) {
    assertThat(getSubject().getPsc())
        .named("PSC")
        .isEqualTo(psc);
    return this;
  }

  public NeighboringCellInfoSubject hasRssi(int rssi) {
    assertThat(getSubject().getRssi())
        .named("RSSI")
        .isEqualTo(rssi);
    return this;
  }
}
