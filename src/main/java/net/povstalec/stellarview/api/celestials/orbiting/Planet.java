package net.povstalec.stellarview.api.celestials.orbiting;

import java.util.Optional;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.povstalec.stellarview.StellarView;
import net.povstalec.stellarview.api.sky_effects.MeteorShower;
import net.povstalec.stellarview.api.sky_effects.ShootingStar;
import net.povstalec.stellarview.client.render.level.misc.StellarViewFogEffects;
import net.povstalec.stellarview.client.render.level.misc.StellarViewSkyEffects;
import net.povstalec.stellarview.common.config.OverworldConfig;

public class Planet extends OrbitingCelestialObject
{
	public static final ResourceLocation MERCURY_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/mercury.png");
	public static final ResourceLocation MERCURY_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/mercury_halo.png");
	
	public static final ResourceLocation VENUS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/venus.png");
	public static final ResourceLocation VENUS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/venus_halo.png");

	
	public static final ResourceLocation EARTH_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/earth.png");
	public static final ResourceLocation EARTH_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/earth_halo.png");

	public static final ResourceLocation DEFAULT_MOON_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/moon_phases.png");
	public static final ResourceLocation DEFAULT_MOON_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/moon_halo_phases.png");

	
	public static final ResourceLocation MARS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/mars.png");
	public static final ResourceLocation MARS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/mars_halo.png");


	public static final ResourceLocation VESTA_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/vesta.png");
	public static final ResourceLocation VESTA_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/vesta_halo.png");

	public static final ResourceLocation CERES_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ceres.png");
	public static final ResourceLocation CERES_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ceres_halo.png");


	public static final ResourceLocation JUPITER_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/jupiter.png");
	public static final ResourceLocation JUPITER_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/jupiter_halo.png");

	public static final ResourceLocation IO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/io_phases.png");
	public static final ResourceLocation IO_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/io_halo_phases.png");

	public static final ResourceLocation EUROPA_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/europa_phases.png");
	public static final ResourceLocation EUROPA_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/europa_halo_phases.png");

	public static final ResourceLocation CALLISTO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/callisto_phases.png");
	public static final ResourceLocation CALLISTO_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/callisto_halo_phases.png");

	public static final ResourceLocation GANYMEDE_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ganymede_phases.png");
	public static final ResourceLocation GANYMEDE_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ganymede_halo_phases.png");

	
	public static final ResourceLocation SATURN_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/saturn.png");
	public static final ResourceLocation SATURN_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/saturn_halo.png");

	public static final ResourceLocation ENCELADUS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/enceladus_phases.png");
	public static final ResourceLocation ENCELADUS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/enceladus_halo_phases.png");

	public static final ResourceLocation TETHYS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/tethys_phases.png");
	public static final ResourceLocation TETHYS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/tethys_halo_phases.png");

	public static final ResourceLocation DIONE_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/dione_phases.png");
	public static final ResourceLocation DIONE_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/dione_halo_phases.png");

	public static final ResourceLocation RHEA_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/rhea_phases.png");
	public static final ResourceLocation RHEA_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/rhea_halo_phases.png");

	public static final ResourceLocation TITAN_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/titan_phases.png");
	public static final ResourceLocation TITAN_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/titan_halo_phases.png");

	public static final ResourceLocation IAPETUS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/iapetus_phases.png");
	public static final ResourceLocation IAPETUS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/iapetus_halo_phases.png");

	
	public static final ResourceLocation URANUS_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/uranus.png");
	public static final ResourceLocation URANUS_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/uranus_halo.png");

	public static final ResourceLocation ARIEL_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ariel_phases.png");
	public static final ResourceLocation ARIEL_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/ariel_halo_phases.png");

	public static final ResourceLocation UMBRIEL_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/umbriel_phases.png");
	public static final ResourceLocation UMBRIEL_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/umbriel_halo_phases.png");

	public static final ResourceLocation TITANIA_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/titania_phases.png");
	public static final ResourceLocation TITANIA_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/titania_halo_phases.png");

	public static final ResourceLocation OBERON_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/oberon_phases.png");
	public static final ResourceLocation OBERON_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/oberon_halo_phases.png");

	
	public static final ResourceLocation NEPTUNE_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/neptune.png");
	public static final ResourceLocation NEPTUNE_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/neptune_halo.png");

	public static final ResourceLocation TRITON_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/triton_phases.png");
	public static final ResourceLocation TRITON_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/triton_halo_phases.png");


	public static final ResourceLocation PLUTO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/pluto_phases.png");
	public static final ResourceLocation PLUTO_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/pluto_halo_phases.png");

	public static final ResourceLocation CHARON_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/charon_phases.png");
	public static final ResourceLocation CHARON_HALO_TEXTURE = new ResourceLocation(StellarView.MODID, "textures/environment/planet_phases/charon_halo_phases.png");
	
	private static final int TICKS_PER_DAY = 24000;
	
	public static final int EARTH_DAY_LENGTH = TICKS_PER_DAY;
	
	private Optional<Integer> rotationPeriod = Optional.empty();
	private Optional<Atmosphere> atmosphere = Optional.empty();
	
	public Planet(ResourceLocation texture, float size)
	{
		this(texture, size, 0);
	}
	
	public Planet(ResourceLocation texture, float size, int rotationPeriod)
	{
		super(texture, size);
		if(rotationPeriod > 0)
			this.rotationPeriod = Optional.of(rotationPeriod);
	}

	@Override
	protected float[] getUV(ClientLevel level, Camera camera, float partialTicks)
	{
		//Exists to disable phases. Will do more work later. -NW
		return new float[] {0.0F, 0.0F, 0.25F, 0.5F};
	}
	
	public Planet addAtmosphere(Atmosphere atmosphere)
	{
		this.atmosphere = Optional.of(atmosphere);
		
		return this;
	}
	
	public Optional<Integer> getRotationPeriod()
	{
		return this.rotationPeriod;
	}
	
	@Override
	public void renderLocalSky(ClientLevel level, Camera camera, float partialTicks,
			PoseStack stack, Matrix4f projectionMatrix, Runnable setupFog, BufferBuilder bufferbuilder)
	{
		if(atmosphere.isPresent())
			this.atmosphere.get().renderAtmosphere(level, camera, partialTicks, stack, bufferbuilder);
		
		//TODO Make this adjustable to other planets
		Vector3f skyAxisRotation;
		if(rotationPeriod.isPresent())
		{
			double zPos = camera.getEntity().getPosition(partialTicks).z();
			float zRotation = 2 * (float) Math.toDegrees(Math.atan(zPos / (10000 * OverworldConfig.overworld_z_rotation_multiplier.get())));
			
			float defaultYRotation = 360 * level.getTimeOfDay(partialTicks);
			float subtractedYRotation = getAngularVelocity(level, partialTicks) > 0 ?  getAngularVelocity(level, partialTicks) * ((float) level.getDayTime() / TICKS_PER_DAY) : 0;
			
			skyAxisRotation = new Vector3f(180 + defaultYRotation + subtractedYRotation, -90.0F, zRotation);
		}
		else
			skyAxisRotation = new Vector3f(0, 0, 0);
		
		this.renderFrom(this, new Vector3f(0, 0, 0), level, camera, partialTicks, stack, projectionMatrix, setupFog, bufferbuilder, skyAxisRotation, new Vector3f(0, 0, 0));
	}
	
	public static class Atmosphere implements StellarViewSkyEffects, StellarViewFogEffects
	{
		protected Optional<ShootingStar> shootingStar = Optional.empty();
		protected Optional<MeteorShower> meteorShower = Optional.empty();
		
		public Atmosphere(ShootingStar shootingStar, MeteorShower meteorShower)
		{
			this.shootingStar = Optional.of(shootingStar);
			this.meteorShower = Optional.of(meteorShower);
		}
		
		public Atmosphere(){}
		
		public void renderAtmosphere(ClientLevel level, Camera camera, float partialTicks, PoseStack stack, BufferBuilder bufferbuilder)
		{
			this.renderSkyEvents(level, camera, partialTicks, stack, bufferbuilder);
		}
		
		protected void renderSkyEvents(ClientLevel level, Camera camera, float partialTicks, PoseStack stack, BufferBuilder bufferbuilder)
		{
			if(shootingStar.isPresent())
				this.shootingStar.get().render(level, camera, partialTicks, stack, bufferbuilder);
			
			if(meteorShower.isPresent())
				this.meteorShower.get().render(level, camera, partialTicks, stack, bufferbuilder);
		}
	}
}
