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
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by toonsev on 10/8/2016.
 */
public class NPCClickEventTest {
    private NPC clicked;
    private Player clicker;
    private NPCClickEvent.ClickType clickType;
    private NPCClickEvent clickEvent;

    @Before
    public void setup(){
        clicked = mock(NPC.class);
        clicker = mock(Player.class);
        clickType = NPCClickEvent.ClickType.LEFT;
        clickEvent = new NPCClickEvent(clicked, clicker, clickType);
    }

    @Test
    public void getClickedEqualsClickedTest(){
        assertEquals(clicked, clickEvent.getClicked());
    }

    @Test
    public void getClickerEqualsClickerTest(){
        assertEquals(clicker, clickEvent.getClicker());
    }

    @Test
    public void getClickTypeEqualsClickTypeTest(){
        assertEquals(clickType, clickEvent.getClickType());
    }
}
