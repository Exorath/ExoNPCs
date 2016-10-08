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

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by toonsev on 10/8/2016.
 */
public class NPCClickEvent extends Event {
    private static HandlerList handlerList = new HandlerList();

    private NPC clicked;
    private Player clicker;
    private ClickType clickType;

    public NPCClickEvent(NPC clicked, Player clicker, ClickType clickType){
        this.clicked = clicked;
        this.clicker = clicker;
        this.clickType = clickType;
    }

    public Player getClicker() {
        return clicker;
    }

    public NPC getClicked() {
        return clicked;
    }

    public ClickType getClickType() {
        return clickType;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public enum ClickType {
        LEFT,
        RIGHT
    }
}
