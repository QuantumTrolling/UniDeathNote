
package net.mcreator.deathnote.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.deathnote.entity.CursedGhostEntity;
import net.mcreator.deathnote.client.model.Modelenemy_ghost;

public class CursedGhostRenderer extends MobRenderer<CursedGhostEntity, Modelenemy_ghost<CursedGhostEntity>> {
	public CursedGhostRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelenemy_ghost(context.bakeLayer(Modelenemy_ghost.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CursedGhostEntity entity) {
		return new ResourceLocation("deathnote:textures/entities/ghost.png");
	}
}
