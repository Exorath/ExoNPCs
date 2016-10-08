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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by toonsev on 10/8/2016.
 */
public class SimpleNPCRegistryTest {
    private SimpleRegistry simpleRegistry;

    @Before
    public void setup(){
        simpleRegistry = spy(new SimpleRegistry() {
            @Override
            public NPC getEntityNPC(EntityType entityType, Location location) {
                return new NPCMockBuilder().withLocation(location).build();
            }
        });
    }

    @Test
    public void spawnEntityCallsGetEntityNPCWithSameTypeAndLocationTest(){
        EntityType type = EntityType.ZOMBIE;
        Location location = new Location(null, 0, 0, 0);
        simpleRegistry.spawnEntity(type, location);
        verify(simpleRegistry, times(1)).getEntityNPC(eq(type), eq(location));
    }


    @Test
    public void getNPCsEmptyByDefaultTest(){
        assertEquals(0, simpleRegistry.getNPCs().size());
    }

    @Test
    public void getNPCsContainsOneNPCWhenSpawnEntityCalledTest(){
        EntityType type = EntityType.ZOMBIE;
        Location location = new Location(null, 0, 0, 0);
        simpleRegistry.spawnEntity(type, location);
        assertEquals(1, simpleRegistry.getNPCs().size());
    }

    @Test
    public void getNPCsContainsTwoNPCsWhenSpawnEntityCalledTwiceTest(){
        EntityType type = EntityType.ZOMBIE;
        Location location = new Location(null, 0, 0, 0);
        simpleRegistry.spawnEntity(type, location);
        simpleRegistry.spawnEntity(type, location);
        assertEquals(2, simpleRegistry.getNPCs().size());
    }

    @Test
    public void getNPCsContainsOneWhenSpawnEntityCalledTwiceAndOneNPCDespawnsTest(){
        EntityType type = EntityType.ZOMBIE;
        Location location = new Location(null, 0, 0, 0);
        NPC npc = simpleRegistry.spawnEntity(type, location);
        simpleRegistry.spawnEntity(type, location);
        npc.despawn();
        assertEquals(1, simpleRegistry.getNPCs().size());
    }

    @Test
    public void getNPCsContainsOneWhenSpawnEntityCalledTwiceAndBothNPCDespawnTest(){
        EntityType type = EntityType.ZOMBIE;
        Location location = new Location(null, 0, 0, 0);
        NPC npc = simpleRegistry.spawnEntity(type, location);
        NPC npc2 = simpleRegistry.spawnEntity(type, location);
        npc.despawn();
        npc2.despawn();
        assertEquals(0, simpleRegistry.getNPCs().size());
    }
}
