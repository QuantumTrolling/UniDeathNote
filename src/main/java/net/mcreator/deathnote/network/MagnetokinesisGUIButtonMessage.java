
package net.mcreator.deathnote.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.world.inventory.MagnetokinesisGUIMenu;
import net.mcreator.deathnote.procedures.MagnetokinesisProcedure;
import net.mcreator.deathnote.procedures.MagnetokinesisPowerUpProcedure;
import net.mcreator.deathnote.procedures.MagnetokinesisLoweringProcedure;
import net.mcreator.deathnote.procedures.MagnetokinesisDeclineProcedure;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagnetokinesisGUIButtonMessage {
	private final int buttonID, x, y, z;

	public MagnetokinesisGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MagnetokinesisGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MagnetokinesisGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MagnetokinesisGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = MagnetokinesisGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MagnetokinesisPowerUpProcedure.execute(entity);
		}
		if (buttonID == 1) {

			MagnetokinesisLoweringProcedure.execute(entity);
		}
		if (buttonID == 2) {

			MagnetokinesisProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MagnetokinesisDeclineProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DeathnoteMod.addNetworkMessage(MagnetokinesisGUIButtonMessage.class, MagnetokinesisGUIButtonMessage::buffer, MagnetokinesisGUIButtonMessage::new, MagnetokinesisGUIButtonMessage::handler);
	}
}
