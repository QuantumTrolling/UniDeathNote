package net.mcreator.deathnote.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.deathnote.DeathnoteMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeathnoteModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DeathnoteMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.GhostlyHunger = original.GhostlyHunger;
			clone.GhostlyHungerButton = original.GhostlyHungerButton;
			clone.VengefulSpirit = original.VengefulSpirit;
			clone.VengefulspiritButton = original.VengefulspiritButton;
			clone.foodLevel = original.foodLevel;
			clone.GhotlyHungerLevel = original.GhotlyHungerLevel;
			clone.NimberofEffect = original.NimberofEffect;
			clone.VengefulSpiritLevel = original.VengefulSpiritLevel;
			clone.SpiritDebuff = original.SpiritDebuff;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("deathnote", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean GhostlyHunger = false;
		public boolean GhostlyHungerButton = false;
		public boolean VengefulSpirit = false;
		public boolean VengefulspiritButton = false;
		public double foodLevel = 0;
		public double GhotlyHungerLevel = 0;
		public double NimberofEffect = 0;
		public double VengefulSpiritLevel = 0;
		public double SpiritDebuff = 10.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("GhostlyHunger", GhostlyHunger);
			nbt.putBoolean("GhostlyHungerButton", GhostlyHungerButton);
			nbt.putBoolean("VengefulSpirit", VengefulSpirit);
			nbt.putBoolean("VengefulspiritButton", VengefulspiritButton);
			nbt.putDouble("foodLevel", foodLevel);
			nbt.putDouble("GhotlyHungerLevel", GhotlyHungerLevel);
			nbt.putDouble("NimberofEffect", NimberofEffect);
			nbt.putDouble("VengefulSpiritLevel", VengefulSpiritLevel);
			nbt.putDouble("SpiritDebuff", SpiritDebuff);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			GhostlyHunger = nbt.getBoolean("GhostlyHunger");
			GhostlyHungerButton = nbt.getBoolean("GhostlyHungerButton");
			VengefulSpirit = nbt.getBoolean("VengefulSpirit");
			VengefulspiritButton = nbt.getBoolean("VengefulspiritButton");
			foodLevel = nbt.getDouble("foodLevel");
			GhotlyHungerLevel = nbt.getDouble("GhotlyHungerLevel");
			NimberofEffect = nbt.getDouble("NimberofEffect");
			VengefulSpiritLevel = nbt.getDouble("VengefulSpiritLevel");
			SpiritDebuff = nbt.getDouble("SpiritDebuff");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.GhostlyHunger = message.data.GhostlyHunger;
					variables.GhostlyHungerButton = message.data.GhostlyHungerButton;
					variables.VengefulSpirit = message.data.VengefulSpirit;
					variables.VengefulspiritButton = message.data.VengefulspiritButton;
					variables.foodLevel = message.data.foodLevel;
					variables.GhotlyHungerLevel = message.data.GhotlyHungerLevel;
					variables.NimberofEffect = message.data.NimberofEffect;
					variables.VengefulSpiritLevel = message.data.VengefulSpiritLevel;
					variables.SpiritDebuff = message.data.SpiritDebuff;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
