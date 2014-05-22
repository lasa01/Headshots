package com.lasa11.headshots;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
				if(e.entity.posY+e.entity.getEyeHeight()-0.4F<en.posY && en.posY<e.entity.posY+e.entity.getEyeHeight()+0.4F)
				{
					e.ammount=e.ammount*5;
					if(!(e.entity instanceof EntityPlayer) && !(e.entity instanceof EntityPlayerMP))
					{
						((EntityLiving) e.entityLiving).setCustomNameTag("HEADSHOT!");
						((EntityLiving) e.entityLiving).setAlwaysRenderNameTag(true);
					}
				}
				
			}
		}
	}
	
}
