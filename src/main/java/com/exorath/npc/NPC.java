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

package com.exorath.npc;

import com.exorath.commons.LocationObservable;
import org.bukkit.Location;
import org.bukkit.util.Vector;


/**
 * An NPC is a moveable object in an {@link org.bukkit.World}.
 * <p>
 * Note that the {@link NPC} may be teleported to a different {@link org.bukkit.World}.
 * Created by toonsev on 10/6/2016.
 */
public interface NPC extends LocationObservable {


    /**
     * Gets the {@link Location} of the {@link NPC}.
     *
     * @return the {@link Location} of the {@link NPC}
     */
    Location getLocation();


    /**
     * Sets the yaw of the {@link NPC}.
     * <p>
     * Yaw is the rotation over the vertical axis (when you turn your head left or right).
     */
    void setYaw(float yaw);


    /**
     * Sets the pitch of the {@link NPC}
     * <p>
     * Pitch is the rotation over the horizontal x-axis (when you look up and down)
     *
     * @param pitch
     */
    void setPitch(float pitch);

    /**
     * Rotates the {@link NPC} to look towards the specific {@link Vector} position.
     *
     * @param vector the position to rotate towards
     */
    void lookAt(Vector vector);

    /**
     * Teleports this {@link NPC} to a specific {@link Location}
     *
     * @param location location to teleport {@link NPC} to
     */
    void setLocation(Location location);

    /**
     * Despawns the {@link NPC}.
     */
    void despawn();
}
