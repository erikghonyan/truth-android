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
package com.pkware.truth.android.util;

import android.annotation.TargetApi;
import android.util.ArrayMap;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for {@link ArrayMap} subjects.
 */
@TargetApi(KITKAT)
public class ArrayMapSubject<K, V> extends Subject {

  @Nullable
  private final ArrayMap<K, V> actual;

  public ArrayMapSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ArrayMap<K, V> actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasKeyAt(int index, K key) {
    check("keyAt(index)")
        .withMessage("key at index %s", index)
        .that(actual.keyAt(index))
        .isEqualTo(key);
  }

  public void hasValueAt(int index, V value) {
    check("valueAt(index)")
        .withMessage("value at index %s", index)
        .that(actual.valueAt(index))
        .isEqualTo(value);
  }
}
