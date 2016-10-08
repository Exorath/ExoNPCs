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

package com.exorath.npc.impl;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.Navigator;
import net.citizensnpcs.api.ai.speech.SpeechController;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.BlockBreaker;
import net.citizensnpcs.api.npc.MetadataStore;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

/**
 * Created by toonsev on 10/8/2016.
 */
public class CitizensNPCWrapper implements NPC {
    private NPC npc;
    public CitizensNPCWrapper(NPC npc){
        this.npc = npc;
    }

    public void addTrait(Class<? extends Trait> aClass) {
        npc.addTrait(aClass);
    }

    public void addTrait(Trait trait) {
        npc.addTrait(trait);
    }

    public NPC clone() {
        return npc.clone();
    }

    public MetadataStore data() {
        return npc.data();
    }

    public boolean despawn() {
        return npc.despawn();
    }

    public boolean despawn(DespawnReason despawnReason) {
        return npc.despawn(despawnReason);
    }

    public void destroy() {
        npc.destroy();
    }

    public void faceLocation(Location location) {
        npc.faceLocation(location);
    }

    public BlockBreaker getBlockBreaker(Block block, BlockBreaker.BlockBreakerConfiguration blockBreakerConfiguration) {
        return npc.getBlockBreaker(block, blockBreakerConfiguration);
    }

    public GoalController getDefaultGoalController() {
        return npc.getDefaultGoalController();
    }

    public SpeechController getDefaultSpeechController() {
        return npc.getDefaultSpeechController();
    }

    public Entity getEntity() {
        return npc.getEntity();
    }

    public String getFullName() {
        return npc.getFullName();
    }

    public int getId() {
        return npc.getId();
    }

    public String getName() {
        return npc.getName();
    }

    public Navigator getNavigator() {
        return npc.getNavigator();
    }

    public NPCRegistry getOwningRegistry() {
        return npc.getOwningRegistry();
    }

    public Location getStoredLocation() {
        return npc.getStoredLocation();
    }

    public <T extends Trait> T getTrait(Class<T> aClass) {
        return npc.getTrait(aClass);
    }

    public Iterable<Trait> getTraits() {
        return npc.getTraits();
    }

    public UUID getUniqueId() {
        return npc.getUniqueId();
    }

    public boolean hasTrait(Class<? extends Trait> aClass) {
        return npc.hasTrait(aClass);
    }

    public boolean isFlyable() {
        return npc.isFlyable();
    }

    public boolean isProtected() {
        return npc.isProtected();
    }

    public boolean isSpawned() {
        return npc.isSpawned();
    }

    public void load(DataKey dataKey) {
        npc.load(dataKey);
    }

    public void removeTrait(Class<? extends Trait> aClass) {
        npc.removeTrait(aClass);
    }

    public void save(DataKey dataKey) {
        npc.save(dataKey);
    }

    public void setBukkitEntityType(EntityType entityType) {
        npc.setBukkitEntityType(entityType);
    }

    public void setFlyable(boolean b) {
        npc.setFlyable(b);
    }

    public void setName(String s) {
        npc.setName(s);
    }

    public void setProtected(boolean b) {
        npc.setProtected(b);
    }

    public boolean spawn(Location location) {
        return spawn(location);
    }

    public void teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        teleport(location, teleportCause);
    }
}
