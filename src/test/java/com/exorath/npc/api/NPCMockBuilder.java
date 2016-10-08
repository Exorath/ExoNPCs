/*
 * Copyright 2016 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.exorath.npc.api;


import io.reactivex.Completable;
import io.reactivex.subjects.PublishSubject;
import org.bukkit.Location;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by toonsev on 10/8/2016.
 */
public class NPCMockBuilder {
    private NPC mockedNPC;

    private PublishSubject<Void> despawnCompletable = PublishSubject.create();

    public NPCMockBuilder() {
        this.mockedNPC = mock(NPC.class);
        withLocation(mock(Location.class));
        withDespawnCompleteable(despawnCompletable);
    }

    public NPCMockBuilder withLocation(Location location) {
        when(mockedNPC.getLocation()).thenReturn(location);
        return this;
    }

    public NPCMockBuilder withDespawnCompleteable(PublishSubject<Void> despawnCompletable) {
        when(mockedNPC.getDespawnCompletable()).thenReturn(despawnCompletable.toCompletable());
        Mockito.doAnswer(invocation -> {
            despawnCompletable.onComplete();
            return null;
        }).when(mockedNPC).despawn();
        return this;
    }

    public NPC build() {
        return mockedNPC;
    }
}
