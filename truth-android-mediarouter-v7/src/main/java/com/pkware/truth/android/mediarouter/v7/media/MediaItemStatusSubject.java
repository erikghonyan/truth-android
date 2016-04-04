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

import android.support.v7.media.MediaItemStatus;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_BUFFERING;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_CANCELED;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_ERROR;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_FINISHED;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_INVALIDATED;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_PAUSED;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_PENDING;
import static android.support.v7.media.MediaItemStatus.PLAYBACK_STATE_PLAYING;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link MediaItemStatus} subjects.
 */
public class MediaItemStatusSubject extends Subject<MediaItemStatusSubject, MediaItemStatus> {
  protected MediaItemStatusSubject(FailureStrategy failureStrategy, MediaItemStatus subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MediaItemStatusSubject, MediaItemStatus> type() {
    return new SubjectFactory<MediaItemStatusSubject, MediaItemStatus>() {
      @Override
      public MediaItemStatusSubject getSubject(FailureStrategy fs, MediaItemStatus that) {
        return new MediaItemStatusSubject(fs, that);
      }
    };
  }

  public static String playbackStateToString(@MediaItemStatusPlaybackState int playbackState) {
    return buildNamedValueString(playbackState)
        .value(PLAYBACK_STATE_BUFFERING, "buffering")
        .value(PLAYBACK_STATE_CANCELED, "canceled")
        .value(PLAYBACK_STATE_ERROR, "error")
        .value(PLAYBACK_STATE_FINISHED, "finished")
        .value(PLAYBACK_STATE_INVALIDATED, "invalidated")
        .value(PLAYBACK_STATE_PAUSED, "paused")
        .value(PLAYBACK_STATE_PENDING, "pending")
        .value(PLAYBACK_STATE_PLAYING, "playing")
        .get();
  }

  public MediaItemStatusSubject hasContentDuration(long duration) {
    assertThat(getSubject().getContentDuration())
        .named("content duration")
        .isEqualTo(duration);
    return this;
  }

  public MediaItemStatusSubject hasContentPosition(long position) {
    assertThat(getSubject().getContentPosition())
        .named("content positions")
        .isEqualTo(position);
    return this;
  }

  public MediaItemStatusSubject hasPlaybackState(@MediaItemStatusPlaybackState int state) {
    int actualState = getSubject().getPlaybackState();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected playback state <%s> but was <%s>.",
            playbackStateToString(state), playbackStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public MediaItemStatusSubject hasTimestamp(long timestamp) {
    assertThat(getSubject().getTimestamp())
        .named("timestamp")
        .isEqualTo(timestamp);
    return this;
  }
}
