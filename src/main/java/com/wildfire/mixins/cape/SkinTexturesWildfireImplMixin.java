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

package com.wildfire.mixins.cape;


import com.wildfire.main.cape.SkinTexturesWildfire;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SkinTextures.class)
@Implements(@Interface(iface = SkinTexturesWildfire.class, prefix = "wildfiregender$", unique = true))
public abstract class SkinTexturesWildfireImplMixin {
    private @Unique @Nullable Identifier wildfiregender$overriddenCapeTexture = null;

    public void wildfiregender$overrideCapeTexture(@Nullable Identifier texture) {
        this.wildfiregender$overriddenCapeTexture = texture;
    }

    public @Nullable Identifier wildfiregender$getOverriddenCapeTexture() {
        return wildfiregender$overriddenCapeTexture;
    }
}