/*
 * Copyright 2013 Square, Inc.
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
package com.pkware.truth.android.preferences;

import android.preference.TwoStatePreference;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractTwoStatePreferenceSubject<S extends AbstractTwoStatePreferenceSubject<S, T>, T extends TwoStatePreference>
    extends AbstractPreferenceSubject<S, T> {
  protected AbstractTwoStatePreferenceSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public S hasSummaryOff(CharSequence summary) {
    assertThat(actual().getSummaryOff())
        .named("off summary")
        .isEqualTo(summary);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSummaryOff(@StringRes int resId) {
    return hasSummaryOff(actual().getContext().getString(resId));
  }

  public S hasSummaryOn(CharSequence summary) {
    assertThat(actual().getSummaryOn())
        .named("on summary")
        .isEqualTo(summary);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSummaryOn(@StringRes int resId) {
    return hasSummaryOn(actual().getContext().getString(resId));
  }

  public S isChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
