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

package com.exorath.npc.impl.citizens;

import com.exorath.npc.api.EntityNPC;
import com.exorath.npc.api.NPCClickEvent;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.util.Vector;

/**
 * Created by toonsev on 10/7/2016.
 */
public class CitizensEntityNPC implements EntityNPC, Listener {
    private net.citizensnpcs.api.npc.NPC npc;

    private PublishSubject<Void> despawnCompletableSubject = PublishSubject.create();
    private PublishSubject<NPCClickEvent> observableClick = PublishSubject.create();
    private PublishSubject<Location> observableLocation = PublishSubject.create();

    public CitizensEntityNPC(EntityType type, Location location){
        npc = CitizensAPI.getNPCRegistry().createNPC(type, "");
        npc.spawn(location);

        completeOnDespawn(observableLocation);
        completeOnDespawn(observableClick);

        setSilent(true);

        setName("");
        setNameVisible(false);

    }

    @Override
    public Observable<NPCClickEvent> getClickObservable() {
        return observableClick;
    }

    @Override
    public void emitClick(NPCClickEvent clickEvent) {
        if(clickEvent.getClicked() != this)
            return;
        observableClick.onNext(clickEvent);
    }

    private void completeOnDespawn(PublishSubject subject){
        getDespawnCompletable().subscribe(() -> subject.onComplete());
    }

    public EntityType getEntity() {
        return npc.getEntity() != null ? npc.getEntity().getType() : EntityType.UNKNOWN;
    }

    public String getName() {
        return npc.getName();
    }

    public void setName(String name) {
        npc.setName(name);
    }

    public void setNameVisible(boolean visible) {
        if(npc.getEntity() != null)
        npc.getEntity().setCustomNameVisible(visible);
    }

    public boolean isNameVisible() {
        if(npc.getEntity() == null)
            return false;
        return npc.getEntity().isCustomNameVisible();
    }

    public void setHeadYaw(float yaw) {
        //unimplemented
    }

    public void setBodyYaw(float yaw) {
        //unimplemented
    }

    public void setInvulnerable(boolean invincible) {
        npc.setProtected(invincible);
    }

    public boolean isInvulnerable() {
        return npc.isProtected();
    }

    public Location getLocation() {
        return npc.getStoredLocation();
    }

    public void setYaw(float yaw) {
        //todo: implementation
    }

    public void setPitch(float pitch) {
        //todo: implementation
    }

    public void lookAt(Vector vector) {
        if(getLocation() == null)
            return;
        npc.faceLocation(new Location(getLocation().getWorld(), vector.getX(), vector.getY(), vector.getZ()));
    }

    public void setLocation(Location location) {
        npc.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
        observableLocation.onNext(location);
    }

    public void despawn() {
        npc.despawn();
        despawnCompletableSubject.onComplete();

    }

    @Override
    public Completable getDespawnCompletable() {
        return despawnCompletableSubject.toCompletable();
    }

    public boolean isDespawned() {
        return !npc.isSpawned();
    }

    public Observable<Location> getObservableLocation() {
        return observableLocation;
    }

    @Override
    public boolean isSilent() {
        return npc.data().get(NPC.SILENT_METADATA);
    }

    @Override
    public void setSilent(boolean silent) {
        npc.data().set(NPC.SILENT_METADATA, silent);
    }
}
