package com.lasa11.headshots;

import com.lasa11.headshots.EntityHeadPos.HeadPosition;
import com.lasa11.headshots.EntityHeadPos.HeadPosition.Position;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HitHandler 
{
	@SubscribeEvent
	public void onHit(LivingHurtEvent e)
	{
		if(e.source.isProjectile())
		{
			Entity en = e.source.getSourceOfDamage();
			if (e.entity instanceof EntityLiving&&en instanceof IProjectile||Headshots.EntityBullet.isInstance(en))
			{
				
				Position p=HeadPosition.get(e.entity);
				boolean b=true;
				if(!(p==null))b = HeadPosition.getHeadPos(e.entity).get();
				double y=0;
				double x=0;
				if(!(p==null))x=p.x();
				if(!(p==null))y=p.y();
				
				if(!(p==null))
				{
				if(b&&e.entity.posY+e.entity.getEyeHeight()-0.4F<en.posY && en.posY<e.entity.posY+e.entity.getEyeHeight()+0.4F)
				{
					e.ammount=e.ammount*5;
					((EntityLiving) e.entityLiving).setCustomNameTag("HEADSHOT!");
					((EntityLiving) e.entityLiving).setAlwaysRenderNameTag(true);
				}
				
				if(!b&&e.entity.posY+y-0.4F<en.posY && en.posY<e.entity.posY+y+0.4F&&e.entity.posX+x-0.4F<x && x<e.entity.posX+x+0.4F)
				{
					e.ammount=e.ammount*5;
					((EntityLiving) e.entityLiving).setCustomNameTag("HEADSHOT!");
					((EntityLiving) e.entityLiving).setAlwaysRenderNameTag(true);
				}
				}
			}
		}
	}
	
}
