package com.lasa11.headshots;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;



public class HitHandler 
{
	@SubscribeEvent
	public void onHit(LivingHurtEvent e)
	{
		if(e.entity instanceof EntityPlayer)return;
		if(e.source.isProjectile())
		{
			Entity en = e.source.getSourceOfDamage();
			if (e.entity instanceof EntityLiving&&en instanceof IProjectile||Headshots.EntityBullet.isInstance(en))
			{
				
				if(e.entity.posY+e.entity.getEyeHeight()-0.4F<en.posY && en.posY<e.entity.posY+e.entity.getEyeHeight()+0.4F&&!isBadEntity(e.entity))
				{
					System.out.println("DEBUG "+e.entity.toString());
					e.ammount=e.ammount*5;
					((EntityLiving) e.entityLiving).setCustomNameTag("HEADSHOT!");
					((EntityLiving) e.entityLiving).setAlwaysRenderNameTag(true);
				}
				
			}
		}
	}
	
	private boolean isBadEntity(Entity e)
	{
		if(e instanceof EntityVillager)return false;
		if(e instanceof EntityAnimal)return true;
		if(e instanceof EntityWaterMob)return true;
		if(e instanceof EntitySlime || e instanceof EntityMagmaCube)return true;
		if(e instanceof EntityDragon|| e instanceof EntityWither)return true; 
		return false;
	}
	
}
