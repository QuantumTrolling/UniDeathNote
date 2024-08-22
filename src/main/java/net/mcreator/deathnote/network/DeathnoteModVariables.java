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

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
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
		DeathnoteMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
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
			clone.IncorporealityIronQuest = original.IncorporealityIronQuest;
			clone.IncorporealityCopperQuest = original.IncorporealityCopperQuest;
			clone.IncorporealityGoldQuest = original.IncorporealityGoldQuest;
			clone.meetGraver = original.meetGraver;
			clone.VengefulSpiritBonesQuest = original.VengefulSpiritBonesQuest;
			clone.VengefulSpiritFleshQuest = original.VengefulSpiritFleshQuest;
			clone.Revival = original.Revival;
			clone.RevivalButton = original.RevivalButton;
			clone.found_soulshard = original.found_soulshard;
			clone.BookTakenFirstTime = original.BookTakenFirstTime;
			clone.Greetings = original.Greetings;
			clone.haveGraverPage = original.haveGraverPage;
			clone.Finiish = original.Finiish;
			clone.IfUniDead = original.IfUniDead;
			clone.firstSpawn = original.firstSpawn;
			clone.GraverTaskZombies = original.GraverTaskZombies;
			clone.GraverTaskSkeletons = original.GraverTaskSkeletons;
			clone.PageDelivered = original.PageDelivered;
			clone.teleported = original.teleported;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "deathnote_worldvars";
		public double ZombieX = 0;
		public double ZombieY = 0;
		public double ZombieZ = 0.0;
		public double TeleportX = 10.0;
		public double TeleportY = 70.0;
		public double TeleportZ = 10.0;
		public ItemStack note = ItemStack.EMPTY;
		public double UndertakerPointX = 0;
		public double UndertakerPointY = 0;
		public double UndertakerPointZ = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			ZombieX = nbt.getDouble("ZombieX");
			ZombieY = nbt.getDouble("ZombieY");
			ZombieZ = nbt.getDouble("ZombieZ");
			TeleportX = nbt.getDouble("TeleportX");
			TeleportY = nbt.getDouble("TeleportY");
			TeleportZ = nbt.getDouble("TeleportZ");
			note = ItemStack.of(nbt.getCompound("note"));
			UndertakerPointX = nbt.getDouble("UndertakerPointX");
			UndertakerPointY = nbt.getDouble("UndertakerPointY");
			UndertakerPointZ = nbt.getDouble("UndertakerPointZ");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("ZombieX", ZombieX);
			nbt.putDouble("ZombieY", ZombieY);
			nbt.putDouble("ZombieZ", ZombieZ);
			nbt.putDouble("TeleportX", TeleportX);
			nbt.putDouble("TeleportY", TeleportY);
			nbt.putDouble("TeleportZ", TeleportZ);
			nbt.put("note", note.save(new CompoundTag()));
			nbt.putDouble("UndertakerPointX", UndertakerPointX);
			nbt.putDouble("UndertakerPointY", UndertakerPointY);
			nbt.putDouble("UndertakerPointZ", UndertakerPointZ);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "deathnote_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				DeathnoteMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
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
		public double Points = 0.0;
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
		public boolean IncorporealityIronQuest = false;
		public boolean IncorporealityCopperQuest = false;
		public boolean IncorporealityGoldQuest = false;
		public boolean meetGraver = false;
		public boolean VengefulSpiritBonesQuest = false;
		public boolean VengefulSpiritFleshQuest = false;
		public boolean Revival = false;
		public boolean RevivalButton = false;
		public boolean found_soulshard = false;
		public boolean BookTakenFirstTime = true;
		public boolean Greetings = false;
		public boolean haveGraverPage = false;
		public boolean Finiish = false;
		public boolean IfUniDead = false;
		public boolean firstSpawn = true;
		public double GraverTaskZombies = 0;
		public double GraverTaskSkeletons = 0;
		public boolean PageDelivered = false;
		public boolean teleported = false;

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
			nbt.putBoolean("IncorporealityIronQuest", IncorporealityIronQuest);
			nbt.putBoolean("IncorporealityCopperQuest", IncorporealityCopperQuest);
			nbt.putBoolean("IncorporealityGoldQuest", IncorporealityGoldQuest);
			nbt.putBoolean("meetGraver", meetGraver);
			nbt.putBoolean("VengefulSpiritBonesQuest", VengefulSpiritBonesQuest);
			nbt.putBoolean("VengefulSpiritFleshQuest", VengefulSpiritFleshQuest);
			nbt.putBoolean("Revival", Revival);
			nbt.putBoolean("RevivalButton", RevivalButton);
			nbt.putBoolean("found_soulshard", found_soulshard);
			nbt.putBoolean("BookTakenFirstTime", BookTakenFirstTime);
			nbt.putBoolean("Greetings", Greetings);
			nbt.putBoolean("haveGraverPage", haveGraverPage);
			nbt.putBoolean("Finiish", Finiish);
			nbt.putBoolean("IfUniDead", IfUniDead);
			nbt.putBoolean("firstSpawn", firstSpawn);
			nbt.putDouble("GraverTaskZombies", GraverTaskZombies);
			nbt.putDouble("GraverTaskSkeletons", GraverTaskSkeletons);
			nbt.putBoolean("PageDelivered", PageDelivered);
			nbt.putBoolean("teleported", teleported);
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
			IncorporealityIronQuest = nbt.getBoolean("IncorporealityIronQuest");
			IncorporealityCopperQuest = nbt.getBoolean("IncorporealityCopperQuest");
			IncorporealityGoldQuest = nbt.getBoolean("IncorporealityGoldQuest");
			meetGraver = nbt.getBoolean("meetGraver");
			VengefulSpiritBonesQuest = nbt.getBoolean("VengefulSpiritBonesQuest");
			VengefulSpiritFleshQuest = nbt.getBoolean("VengefulSpiritFleshQuest");
			Revival = nbt.getBoolean("Revival");
			RevivalButton = nbt.getBoolean("RevivalButton");
			found_soulshard = nbt.getBoolean("found_soulshard");
			BookTakenFirstTime = nbt.getBoolean("BookTakenFirstTime");
			Greetings = nbt.getBoolean("Greetings");
			haveGraverPage = nbt.getBoolean("haveGraverPage");
			Finiish = nbt.getBoolean("Finiish");
			IfUniDead = nbt.getBoolean("IfUniDead");
			firstSpawn = nbt.getBoolean("firstSpawn");
			GraverTaskZombies = nbt.getDouble("GraverTaskZombies");
			GraverTaskSkeletons = nbt.getDouble("GraverTaskSkeletons");
			PageDelivered = nbt.getBoolean("PageDelivered");
			teleported = nbt.getBoolean("teleported");
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
					variables.IncorporealityIronQuest = message.data.IncorporealityIronQuest;
					variables.IncorporealityCopperQuest = message.data.IncorporealityCopperQuest;
					variables.IncorporealityGoldQuest = message.data.IncorporealityGoldQuest;
					variables.meetGraver = message.data.meetGraver;
					variables.VengefulSpiritBonesQuest = message.data.VengefulSpiritBonesQuest;
					variables.VengefulSpiritFleshQuest = message.data.VengefulSpiritFleshQuest;
					variables.Revival = message.data.Revival;
					variables.RevivalButton = message.data.RevivalButton;
					variables.found_soulshard = message.data.found_soulshard;
					variables.BookTakenFirstTime = message.data.BookTakenFirstTime;
					variables.Greetings = message.data.Greetings;
					variables.haveGraverPage = message.data.haveGraverPage;
					variables.Finiish = message.data.Finiish;
					variables.IfUniDead = message.data.IfUniDead;
					variables.firstSpawn = message.data.firstSpawn;
					variables.GraverTaskZombies = message.data.GraverTaskZombies;
					variables.GraverTaskSkeletons = message.data.GraverTaskSkeletons;
					variables.PageDelivered = message.data.PageDelivered;
					variables.teleported = message.data.teleported;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
