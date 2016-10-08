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

import com.exorath.commons.InteractObservable;
import org.bukkit.entity.EntityType;

/**
 * Created by toonsev on 10/7/2016.
 */
public interface EntityNPC extends NPC, Damageable {

    /**
     * Gets the {@link EntityType} of this {@link EntityNPC}
     *
     * @return the {@link EntityType} of this {@link EntityNPC}
     */
    EntityType getEntity();

    /**
     * Gets the name of this {@link EntityNPC}.
     *
     * @return the name of this {@link EntityNPC}
     */
    String getName();

    /**
     * Sets the name of this {@link EntityNPC}.
     * <p>
     * Note that this name will not display as long as the name visibility is false.
     *
     * @param name the name to assign to this {@link EntityNPC}
     */
    void setName(String name);

    /**
     * Sets the visibility of the entities name (false by default)
     *
     * @param visible true to display the name to players, false to hide it from them
     */
    void setNameVisible(boolean visible);

    /**
     * Gets whether or not the name of this {@link EntityNPC} is visible.
     * <p>
     * Returns true by default.
     *
     * @return whether or not the name of this {@link EntityNPC} is visible
     */
    boolean isNameVisible();



    /**
     * Sets the yaw of the {@link EntityNPC}'s head (solely rotates the head left and right)
     *
     * @param yaw the yaw to move the {@link EntityNPC}'s head to
     */
    void setHeadYaw(float yaw);

    /**
     * Sets the yaw of the {@link EntityNPC}'s body (solely rotates the body left and right)
     *
     * @param yaw the yaw to move the {@link EntityNPC}'s body to
     */
    void setBodyYaw(float yaw);


    /**
     * Gets whether or not this entity is muted (true by default).
     * @return true if the entity is muted, false if not
     */
    boolean isSilent();

    /**
     * Mutes/unmutes this entity.
     * @param silent true to mute entity, false to unmute it
     */
    void setSilent(boolean silent);
}
