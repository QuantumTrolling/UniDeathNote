
package net.mcreator.deathnote.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.deathnote.entity.UndertakerEntity;
import net.mcreator.deathnote.client.model.Modelundertaker;

public class UndertakerRenderer extends MobRenderer<UndertakerEntity, Modelundertaker<UndertakerEntity>> {
	public UndertakerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelundertaker(context.bakeLayer(Modelundertaker.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UndertakerEntity entity) {
		return new ResourceLocation("deathnote:textures/entities/graver.png");
	}
}
