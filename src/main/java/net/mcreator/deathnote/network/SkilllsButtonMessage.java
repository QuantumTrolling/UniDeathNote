
package net.mcreator.deathnote.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.world.inventory.SkilllsMenu;
import net.mcreator.deathnote.procedures.VengefulSpiritGUIShowProcedure;
import net.mcreator.deathnote.procedures.TeleportGUIShowProcedure;
import net.mcreator.deathnote.procedures.SoulSplitGUIShowProcedure;
import net.mcreator.deathnote.procedures.RevivalGUIShowProcedure;
import net.mcreator.deathnote.procedures.ObsessionGUIShowProcedure;
import net.mcreator.deathnote.procedures.ManifestationGUIShowProcedure;
import net.mcreator.deathnote.procedures.MagnetokinesisGUIShowProcedure;
import net.mcreator.deathnote.procedures.LevitationGUIShowProcedure;
import net.mcreator.deathnote.procedures.IntangibilityGUIShowProcedure;
import net.mcreator.deathnote.procedures.IncorporealityGUIShowProcedure;
import net.mcreator.deathnote.procedures.GhostlyHungerGUIShowProcedure;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkilllsButtonMessage {
	private final int buttonID, x, y, z;

	public SkilllsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SkilllsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SkilllsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SkilllsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SkilllsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GhostlyHungerGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			VengefulSpiritGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			MagnetokinesisGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SoulSplitGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ObsessionGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			LevitationGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			TeleportGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			IntangibilityGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ManifestationGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			IncorporealityGUIShowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			RevivalGUIShowProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DeathnoteMod.addNetworkMessage(SkilllsButtonMessage.class, SkilllsButtonMessage::buffer, SkilllsButtonMessage::new, SkilllsButtonMessage::handler);
	}
}
