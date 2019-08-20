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
package com.pkware.truth.android.animation;

import android.animation.ObjectAnimator;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ObjectAnimator} subjects.
 */
public final class ObjectAnimatorSubject extends AbstractValueAnimatorSubject<ObjectAnimatorSubject, ObjectAnimator> {
  public ObjectAnimatorSubject(FailureMetadata failureMetadata, ObjectAnimator subject) {
    super(failureMetadata, subject);
  }

  public ObjectAnimatorSubject hasPropertyName(String name) {
    assertThat(actual().getPropertyName())
        .named("property name")
        .isEqualTo(name);
    return this;
  }

  public ObjectAnimatorSubject hasTarget(Object target) {
    assertThat(actual().getTarget())
        .named("target")
        .isSameAs(target);
    return this;
  }
}
