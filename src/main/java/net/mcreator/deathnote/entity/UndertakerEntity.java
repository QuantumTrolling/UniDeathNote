
package net.mcreator.deathnote.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.deathnote.procedures.UndertakerRightClickedOnEntityProcedure;
import net.mcreator.deathnote.procedures.UndertakerOnEntityTickUpdateProcedure;
import net.mcreator.deathnote.procedures.CheckIfPlayerNearProcedure;
import net.mcreator.deathnote.init.DeathnoteModEntities;

public class UndertakerEntity extends Monster {
	public UndertakerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DeathnoteModEntities.UNDERTAKER.get(), world);
	}

	public UndertakerEntity(EntityType<UndertakerEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(2, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.6) {
			@Override
			public boolean canUse() {
				double x = UndertakerEntity.this.getX();
				double y = UndertakerEntity.this.getY();
				double z = UndertakerEntity.this.getZ();
				Entity entity = UndertakerEntity.this;
				Level world = UndertakerEntity.this.level();
				return super.canUse() && CheckIfPlayerNearProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = UndertakerEntity.this.getX();
				double y = UndertakerEntity.this.getY();
				double z = UndertakerEntity.this.getZ();
				Entity entity = UndertakerEntity.this;
				Level world = UndertakerEntity.this.level();
				return super.canContinueToUse() && CheckIfPlayerNearProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = UndertakerEntity.this.getX();
				double y = UndertakerEntity.this.getY();
				double z = UndertakerEntity.this.getZ();
				Entity entity = UndertakerEntity.this;
				Level world = UndertakerEntity.this.level();
				return super.canUse() && CheckIfPlayerNearProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = UndertakerEntity.this.getX();
				double y = UndertakerEntity.this.getY();
				double z = UndertakerEntity.this.getZ();
				Entity entity = UndertakerEntity.this;
				Level world = UndertakerEntity.this.level();
				return super.canContinueToUse() && CheckIfPlayerNearProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		UndertakerRightClickedOnEntityProcedure.execute(world, entity, sourceentity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		UndertakerOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
