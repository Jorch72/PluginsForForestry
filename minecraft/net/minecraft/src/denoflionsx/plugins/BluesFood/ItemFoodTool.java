package net.minecraft.src.denoflionsx.plugins.BluesFood;

import net.minecraft.src.*;
import net.minecraft.src.denoflionsx.core.core;
import net.minecraft.src.denoflionsx.denLib.denLib;
import net.minecraft.src.forge.ITextureProvider;

public class ItemFoodTool extends Item implements ITextureProvider {

    protected int maxDamage;
    protected int pew;
    protected String name;
    protected int texture;

    public ItemFoodTool(int par1, int texture, int pew, int maxDamage, String name) {
        super(par1);
        this.maxDamage = maxDamage;
        this.pew = pew;
        this.name = name;
        this.texture = texture;
        if (core.isClient()) {
            ModLoader.addLocalization("item." + denLib.toLowerCaseNoSpaces(name) + ".name", name);
        }
        this.setMaxStackSize(1);
    }

    @Override
    public int getIconFromDamage(int par1) {
        return this.texture;
    }

    @Override
    public int getDamageVsEntity(Entity par1Entity) {
        return this.maxDamage;
    }

    @Override
    public String getItemNameIS(ItemStack par1ItemStack) {
        return "item." + denLib.toLowerCaseNoSpaces(name);
    }

    @Override
    public int getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public String getTextureFile() {
        return ItemFoods.spritesheet;
    }
}
