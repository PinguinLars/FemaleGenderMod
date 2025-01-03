/*
 * Wildfire's Female Gender Mod is a female gender mod created for Minecraft.
 * Copyright (C) 2023-present WildfireRomeo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.wildfire.events;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.function.Consumer;

/**
 * Event invoked before a player's nametag is rendered above their head
 */
@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface PlayerNametagRenderEvent {
	Event<PlayerNametagRenderEvent> EVENT = EventFactory.createArrayBacked(PlayerNametagRenderEvent.class, listeners -> (state, matrixStack, vertexConsumerProvider, renderHelper) -> {
		for(var listener : listeners) {
			listener.onRenderNameTag(state, matrixStack, vertexConsumerProvider, renderHelper);
		}
	});

	void onRenderNameTag(PlayerEntityRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, Consumer<Text> renderHelper);
}
