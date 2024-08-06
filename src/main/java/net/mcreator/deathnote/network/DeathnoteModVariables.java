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
			clone.Magnetokinesis = original.Magnetokinesis;
			clone.MagnetokinesisButton = original.MagnetokinesisButton;
			clone.MagnetokinesisLevel = original.MagnetokinesisLevel;
			clone.MagnetokinesisDebuff = original.MagnetokinesisDebuff;
			clone.MagnetokinesisCD = original.MagnetokinesisCD;
			clone.incorporeality = original.incorporeality;
			clone.incorporealityButton = original.incorporealityButton;
			clone.incorporealityBuff = original.incorporealityBuff;
			clone.incorporealityDebuff = original.incorporealityDebuff;
			clone.incorporealityLevel = original.incorporealityLevel;
			clone.SoulSplit = original.SoulSplit;
			clone.SoulSplitButton = original.SoulSplitButton;
			clone.SoulSplitLevel = original.SoulSplitLevel;
			clone.SoulSplitCD = original.SoulSplitCD;
			clone.Obsession = original.Obsession;
			clone.ObsessionButton = original.ObsessionButton;
			clone.ObsessionLevel = original.ObsessionLevel;
			clone.Levitation = original.Levitation;
			clone.LevitationButton = original.LevitationButton;
			clone.LevitationLevel = original.LevitationLevel;
			clone.LevitationCD = original.LevitationCD;
			clone.Points = original.Points;
			clone.Teleport = original.Teleport;
			clone.TeleportButton = original.TeleportButton;
			clone.TeleportLevel = original.TeleportLevel;
			clone.TeleportCD = original.TeleportCD;
			clone.Intangibility = original.Intangibility;
			clone.IntangibilityButton = original.IntangibilityButton;
			clone.IntangibilityLevel = original.IntangibilityLevel;
			clone.IntangibilityDebuff = original.IntangibilityDebuff;
			clone.Manifestation = original.Manifestation;
			clone.ManifestationButton = original.ManifestationButton;
			clone.ManifestationLevel = original.ManifestationLevel;
			clone.ManifestationCD = original.ManifestationCD;
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
		public boolean Magnetokinesis = false;
		public boolean MagnetokinesisButton = false;
		public double MagnetokinesisLevel = 0;
		public double MagnetokinesisDebuff = 10.0;
		public boolean MagnetokinesisCD = false;
		public boolean incorporeality = false;
		public boolean incorporealityButton = false;
		public double incorporealityBuff = 10.0;
		public double incorporealityDebuff = 10.0;
		public double incorporealityLevel = 0;
		public boolean SoulSplit = false;
		public boolean SoulSplitButton = false;
		public double SoulSplitLevel = 0;
		public boolean SoulSplitCD = false;
		public boolean Obsession = false;
		public boolean ObsessionButton = false;
		public double ObsessionLevel = 0;
		public boolean Levitation = false;
		public boolean LevitationButton = false;
		public double LevitationLevel = 0;
		public boolean LevitationCD = false;
		public double Points = 10.0;
		public boolean Teleport = false;
		public boolean TeleportButton = false;
		public double TeleportLevel = 0;
		public boolean TeleportCD = false;
		public boolean Intangibility = false;
		public boolean IntangibilityButton = false;
		public double IntangibilityLevel = 0;
		public boolean IntangibilityDebuff = false;
		public boolean Manifestation = false;
		public boolean ManifestationButton = false;
		public double ManifestationLevel = 0;
		public boolean ManifestationCD = false;

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
			nbt.putBoolean("Magnetokinesis", Magnetokinesis);
			nbt.putBoolean("MagnetokinesisButton", MagnetokinesisButton);
			nbt.putDouble("MagnetokinesisLevel", MagnetokinesisLevel);
			nbt.putDouble("MagnetokinesisDebuff", MagnetokinesisDebuff);
			nbt.putBoolean("MagnetokinesisCD", MagnetokinesisCD);
			nbt.putBoolean("incorporeality", incorporeality);
			nbt.putBoolean("incorporealityButton", incorporealityButton);
			nbt.putDouble("incorporealityBuff", incorporealityBuff);
			nbt.putDouble("incorporealityDebuff", incorporealityDebuff);
			nbt.putDouble("incorporealityLevel", incorporealityLevel);
			nbt.putBoolean("SoulSplit", SoulSplit);
			nbt.putBoolean("SoulSplitButton", SoulSplitButton);
			nbt.putDouble("SoulSplitLevel", SoulSplitLevel);
			nbt.putBoolean("SoulSplitCD", SoulSplitCD);
			nbt.putBoolean("Obsession", Obsession);
			nbt.putBoolean("ObsessionButton", ObsessionButton);
			nbt.putDouble("ObsessionLevel", ObsessionLevel);
			nbt.putBoolean("Levitation", Levitation);
			nbt.putBoolean("LevitationButton", LevitationButton);
			nbt.putDouble("LevitationLevel", LevitationLevel);
			nbt.putBoolean("LevitationCD", LevitationCD);
			nbt.putDouble("Points", Points);
			nbt.putBoolean("Teleport", Teleport);
			nbt.putBoolean("TeleportButton", TeleportButton);
			nbt.putDouble("TeleportLevel", TeleportLevel);
			nbt.putBoolean("TeleportCD", TeleportCD);
			nbt.putBoolean("Intangibility", Intangibility);
			nbt.putBoolean("IntangibilityButton", IntangibilityButton);
			nbt.putDouble("IntangibilityLevel", IntangibilityLevel);
			nbt.putBoolean("IntangibilityDebuff", IntangibilityDebuff);
			nbt.putBoolean("Manifestation", Manifestation);
			nbt.putBoolean("ManifestationButton", ManifestationButton);
			nbt.putDouble("ManifestationLevel", ManifestationLevel);
			nbt.putBoolean("ManifestationCD", ManifestationCD);
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
			Magnetokinesis = nbt.getBoolean("Magnetokinesis");
			MagnetokinesisButton = nbt.getBoolean("MagnetokinesisButton");
			MagnetokinesisLevel = nbt.getDouble("MagnetokinesisLevel");
			MagnetokinesisDebuff = nbt.getDouble("MagnetokinesisDebuff");
			MagnetokinesisCD = nbt.getBoolean("MagnetokinesisCD");
			incorporeality = nbt.getBoolean("incorporeality");
			incorporealityButton = nbt.getBoolean("incorporealityButton");
			incorporealityBuff = nbt.getDouble("incorporealityBuff");
			incorporealityDebuff = nbt.getDouble("incorporealityDebuff");
			incorporealityLevel = nbt.getDouble("incorporealityLevel");
			SoulSplit = nbt.getBoolean("SoulSplit");
			SoulSplitButton = nbt.getBoolean("SoulSplitButton");
			SoulSplitLevel = nbt.getDouble("SoulSplitLevel");
			SoulSplitCD = nbt.getBoolean("SoulSplitCD");
			Obsession = nbt.getBoolean("Obsession");
			ObsessionButton = nbt.getBoolean("ObsessionButton");
			ObsessionLevel = nbt.getDouble("ObsessionLevel");
			Levitation = nbt.getBoolean("Levitation");
			LevitationButton = nbt.getBoolean("LevitationButton");
			LevitationLevel = nbt.getDouble("LevitationLevel");
			LevitationCD = nbt.getBoolean("LevitationCD");
			Points = nbt.getDouble("Points");
			Teleport = nbt.getBoolean("Teleport");
			TeleportButton = nbt.getBoolean("TeleportButton");
			TeleportLevel = nbt.getDouble("TeleportLevel");
			TeleportCD = nbt.getBoolean("TeleportCD");
			Intangibility = nbt.getBoolean("Intangibility");
			IntangibilityButton = nbt.getBoolean("IntangibilityButton");
			IntangibilityLevel = nbt.getDouble("IntangibilityLevel");
			IntangibilityDebuff = nbt.getBoolean("IntangibilityDebuff");
			Manifestation = nbt.getBoolean("Manifestation");
			ManifestationButton = nbt.getBoolean("ManifestationButton");
			ManifestationLevel = nbt.getDouble("ManifestationLevel");
			ManifestationCD = nbt.getBoolean("ManifestationCD");
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
					variables.Magnetokinesis = message.data.Magnetokinesis;
					variables.MagnetokinesisButton = message.data.MagnetokinesisButton;
					variables.MagnetokinesisLevel = message.data.MagnetokinesisLevel;
					variables.MagnetokinesisDebuff = message.data.MagnetokinesisDebuff;
					variables.MagnetokinesisCD = message.data.MagnetokinesisCD;
					variables.incorporeality = message.data.incorporeality;
					variables.incorporealityButton = message.data.incorporealityButton;
					variables.incorporealityBuff = message.data.incorporealityBuff;
					variables.incorporealityDebuff = message.data.incorporealityDebuff;
					variables.incorporealityLevel = message.data.incorporealityLevel;
					variables.SoulSplit = message.data.SoulSplit;
					variables.SoulSplitButton = message.data.SoulSplitButton;
					variables.SoulSplitLevel = message.data.SoulSplitLevel;
					variables.SoulSplitCD = message.data.SoulSplitCD;
					variables.Obsession = message.data.Obsession;
					variables.ObsessionButton = message.data.ObsessionButton;
					variables.ObsessionLevel = message.data.ObsessionLevel;
					variables.Levitation = message.data.Levitation;
					variables.LevitationButton = message.data.LevitationButton;
					variables.LevitationLevel = message.data.LevitationLevel;
					variables.LevitationCD = message.data.LevitationCD;
					variables.Points = message.data.Points;
					variables.Teleport = message.data.Teleport;
					variables.TeleportButton = message.data.TeleportButton;
					variables.TeleportLevel = message.data.TeleportLevel;
					variables.TeleportCD = message.data.TeleportCD;
					variables.Intangibility = message.data.Intangibility;
					variables.IntangibilityButton = message.data.IntangibilityButton;
					variables.IntangibilityLevel = message.data.IntangibilityLevel;
					variables.IntangibilityDebuff = message.data.IntangibilityDebuff;
					variables.Manifestation = message.data.Manifestation;
					variables.ManifestationButton = message.data.ManifestationButton;
					variables.ManifestationLevel = message.data.ManifestationLevel;
					variables.ManifestationCD = message.data.ManifestationCD;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
