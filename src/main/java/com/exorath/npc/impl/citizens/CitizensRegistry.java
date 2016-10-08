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


import com.exorath.npc.api.NPC;
import com.exorath.npc.api.NPCClickEvent;
import com.exorath.npc.api.SimpleRegistry;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;


/**
 * Created by toonsev on 10/8/2016.
 */
public class CitizensRegistry extends SimpleRegistry implements Listener {
    private Plugin plugin;

    private HashMap<net.citizensnpcs.api.npc.NPC, NPC> npcsByCitizens = new HashMap<>();

    public CitizensRegistry(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onLeftClick(NPCLeftClickEvent event) {
        NPC npc = npcsByCitizens.get(event.getNPC());
        if(npc == null)
            return;
        NPCClickEvent npcClickEvent = new NPCClickEvent(npc, event.getClicker(), NPCClickEvent.ClickType.LEFT);
    }


    @EventHandler
    public void onRightClick(NPCRightClickEvent event) {
        NPC npc = npcsByCitizens.get(event.getNPC());
        if(npc == null)
            return;
        NPCClickEvent npcClickEvent = new NPCClickEvent(npc, event.getClicker(), NPCClickEvent.ClickType.RIGHT);
    }

    public NPC getEntityNPC(EntityType entityType, Location location) {
        return new CitizensEntityNPC(entityType, location);
    }

}
