package com.lasa11.headshots;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;


public class EntityHeadPos 
{

	public enum HeadPosition
	{
		HUMANMONSTER(),
		ANIMAL(0.7D, 0.9D),
		HORSE(2.0D, 0.0D);
		
		private final double posY;
		private final double posX;
		
		private final boolean defaultPos;
		
		HeadPosition(double y, double x)
		{
			posY=y;
			posX=x;
			defaultPos=false;
		}
		
		HeadPosition(){posY=0; posX=0; defaultPos=true;}
		
		public static HeadPosition getHeadPos(Entity e)
		{
			if(e instanceof EntityAnimal)
			{
				if (e instanceof EntityHorse) return HeadPosition.HORSE;
				
				if (e instanceof EntityChicken||e instanceof EntityBat||e instanceof EntityWaterMob|| e instanceof EntityWolf) return null;
				
				
				
				else return null;
			}
			else if(e instanceof EntityMob)
			{
				if(e instanceof EntityCaveSpider||e instanceof EntitySpider||e instanceof EntitySilverfish||e instanceof EntitySlime||e instanceof EntityMagmaCube||e instanceof EntityGhast||e instanceof EntityIronGolem)return null;
				else return HeadPosition.HUMANMONSTER;
			}
			else if(e instanceof EntityPlayer||e instanceof EntityPlayerMP)return HeadPosition.HUMANMONSTER;
			else if(e instanceof EntityVillager)return HeadPosition.HUMANMONSTER;
			else return null;
		}
		
		public static Position get(Entity e)
		{
			HeadPosition h = HeadPosition.getHeadPos(e);
			if(!(h==null))return new Position(h.posX, h.posY);
			return null;
		}
		
		public boolean get()
		{
			return defaultPos;
		}
		
		
		static class Position
		{
			private final double x;
			private final double y;
			Position(double posX, double posY)
			{
				x=posX;
				y=posY;
			}
			public double x(){return x;}
			public double y(){return y;}
		}
	}
}
