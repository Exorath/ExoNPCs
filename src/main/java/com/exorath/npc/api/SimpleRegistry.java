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

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by toonsev on 10/8/2016.
 */
public abstract class SimpleRegistry implements NPCRegistry {

    private Set<NPC> npcs = new HashSet<>();

    public abstract NPC getEntityNPC(EntityType entityType, Location location);

    @Override
    public NPC spawnEntity(EntityType entityType, Location location) {
        NPC npc = getEntityNPC(entityType, location);
        registerNPC(npc);
        return npc;
    }

    private void registerNPC(NPC npc) {
        npcs.add(npc);
        npc.getDespawnCompletable().subscribe(() -> npcs.remove(npc));
    }

    @Override
    public Set<NPC> getNPCs() {
        return npcs;
    }
}
