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
package com.pkware.truth.android.mediarouter.v7.media;

import android.support.v7.media.MediaSessionStatus;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.support.v7.media.MediaSessionStatus.SESSION_STATE_ACTIVE;
import static android.support.v7.media.MediaSessionStatus.SESSION_STATE_ENDED;
import static android.support.v7.media.MediaSessionStatus.SESSION_STATE_INVALIDATED;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link MediaSessionStatus} subjects.
 */
public class MediaSessionStatusSubject
    extends Subject<MediaSessionStatusSubject, MediaSessionStatus> {
  protected MediaSessionStatusSubject(FailureStrategy failureStrategy, MediaSessionStatus subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MediaSessionStatusSubject, MediaSessionStatus> type() {
    return new SubjectFactory<MediaSessionStatusSubject, MediaSessionStatus>() {
      @Override
      public MediaSessionStatusSubject getSubject(FailureStrategy fs, MediaSessionStatus that) {
        return new MediaSessionStatusSubject(fs, that);
      }
    };
  }

  public static String sessionStateToString(@MediaSessionStatusState int state) {
    return buildNamedValueString(state)
        .value(SESSION_STATE_ACTIVE, "active")
        .value(SESSION_STATE_ENDED, "ended")
        .value(SESSION_STATE_INVALIDATED, "invalidated")
        .get();
  }

  public MediaSessionStatusSubject hasSessionState(@MediaSessionStatusState int state) {
    int actualState = getSubject().getSessionState();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected session state <%s> but was <%s>.",
            sessionStateToString(state), sessionStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public MediaSessionStatusSubject hasTimestamp(long timestamp) {
    assertThat(getSubject().getTimestamp())
        .named("timestamp")
        .isEqualTo(timestamp);
    return this;
  }

  public MediaSessionStatusSubject hasQueuePaused() {
    assertThat(getSubject().isQueuePaused())
        .named("is queue paused")
        .isTrue();
    return this;
  }

  public MediaSessionStatusSubject doesNotHaveQueuePaused() {
    assertThat(getSubject().isQueuePaused())
        .named("is queue paused")
        .isFalse();
    return this;
  }
}
