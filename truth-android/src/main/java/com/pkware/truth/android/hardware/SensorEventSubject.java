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
package com.pkware.truth.android.hardware;

import android.hardware.SensorEvent;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SensorEvent} subjects.
 */
public class SensorEventSubject extends Subject<SensorEventSubject, SensorEvent> {
  protected SensorEventSubject(FailureStrategy failureStrategy, SensorEvent subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SensorEventSubject, SensorEvent> type() {
    return new SubjectFactory<SensorEventSubject, SensorEvent>() {
      @Override
      public SensorEventSubject getSubject(FailureStrategy fs, SensorEvent that) {
        return new SensorEventSubject(fs, that);
      }
    };
  }

  public SensorEventSubject hasAccuracy(int accuracy) {
    assertThat(getSubject().accuracy)
        .named("accuracy")
        .isEqualTo(accuracy);
    return this;
  }

  public SensorEventSubject hasTimestamp(long timestamp) {
    assertThat(getSubject().timestamp)
        .named("timestamp")
        .isEqualTo(timestamp);
    return this;
  }

  public SensorEventSubject hasValues(float[] values, float tolerance) {
    assertThat(getSubject().values)
        .named("values")
        .hasValuesWithin(tolerance)
        .of(values);
    return this;
  }
}
