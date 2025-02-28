
package net.mcreator.deathnote.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.deathnote.world.inventory.VengefulSpiritGUIMenu;
import net.mcreator.deathnote.procedures.VengefulSpiritProcedure;
import net.mcreator.deathnote.procedures.VengefulSpiritPowerUpProcedure;
import net.mcreator.deathnote.procedures.VengefulSpiritLoweringProcedure;
import net.mcreator.deathnote.procedures.VengefulSpiritDeclineProcedure;
import net.mcreator.deathnote.DeathnoteMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VengefulSpiritGUIButtonMessage {
	private final int buttonID, x, y, z;

	public VengefulSpiritGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public VengefulSpiritGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(VengefulSpiritGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(VengefulSpiritGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = VengefulSpiritGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			VengefulSpiritPowerUpProcedure.execute(entity);
		}
		if (buttonID == 1) {

			VengefulSpiritLoweringProcedure.execute(entity);
		}
		if (buttonID == 2) {

			VengefulSpiritProcedure.execute(entity);
		}
		if (buttonID == 3) {

			VengefulSpiritDeclineProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DeathnoteMod.addNetworkMessage(VengefulSpiritGUIButtonMessage.class, VengefulSpiritGUIButtonMessage::buffer, VengefulSpiritGUIButtonMessage::new, VengefulSpiritGUIButtonMessage::handler);
	}
}
