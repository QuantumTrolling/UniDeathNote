
package net.mcreator.deathnote.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.deathnote.entity.UniGhostEntity;
import net.mcreator.deathnote.client.model.ModelUniGhostClone;

public class UniGhostRenderer extends MobRenderer<UniGhostEntity, ModelUniGhostClone<UniGhostEntity>> {
	public UniGhostRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelUniGhostClone(context.bakeLayer(ModelUniGhostClone.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UniGhostEntity entity) {
		return new ResourceLocation("deathnote:textures/entities/uni_games_ghost.png");
	}
}
