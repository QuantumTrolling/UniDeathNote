
package net.mcreator.deathnote.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.world.inventory.IncorporealityGUIMenu;
import net.mcreator.deathnote.procedures.IncorporealityProcedure;
import net.mcreator.deathnote.procedures.IncorporealityPowerUpProcedure;
import net.mcreator.deathnote.procedures.IncorporealityLoweringProcedure;
import net.mcreator.deathnote.procedures.IncirporealityDeclineProcedure;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IncorporealityGUIButtonMessage {
	private final int buttonID, x, y, z;

	public IncorporealityGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public IncorporealityGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(IncorporealityGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(IncorporealityGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = IncorporealityGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			IncorporealityProcedure.execute(entity);
		}
		if (buttonID == 1) {

			IncorporealityPowerUpProcedure.execute(entity);
		}
		if (buttonID == 2) {

			IncorporealityLoweringProcedure.execute(entity);
		}
		if (buttonID == 3) {

			IncirporealityDeclineProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DeathnoteMod.addNetworkMessage(IncorporealityGUIButtonMessage.class, IncorporealityGUIButtonMessage::buffer, IncorporealityGUIButtonMessage::new, IncorporealityGUIButtonMessage::handler);
	}
}
