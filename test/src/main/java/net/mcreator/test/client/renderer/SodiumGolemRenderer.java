package net.mcreator.test.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import net.mcreator.test.procedures.SodiumGolemWALKProcedure;
import net.mcreator.test.entity.SodiumGolemEntity;
import net.mcreator.test.client.model.animations.nagolemAnimation;
import net.mcreator.test.client.model.Modelnagolem;

public class SodiumGolemRenderer extends MobRenderer<SodiumGolemEntity, LivingEntityRenderState, Modelnagolem> {
	private SodiumGolemEntity entity = null;

	public SodiumGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelnagolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(SodiumGolemEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("test:textures/entities/na.png");
	}

	private static final class AnimatedModel extends Modelnagolem {
		private SodiumGolemEntity entity = null;
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;
		private final KeyframeAnimation keyframeAnimation2;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = nagolemAnimation.stand.bake(root);
			this.keyframeAnimation1 = nagolemAnimation.walk.bake(root);
			this.keyframeAnimation2 = nagolemAnimation.attack.bake(root);
		}

		public void setEntity(SodiumGolemEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(entity.animationState0, state.ageInTicks, 1f);
			if (SodiumGolemWALKProcedure.execute(entity))
				this.keyframeAnimation1.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 0.5f, 0.6f);
			this.keyframeAnimation2.apply(entity.animationState2, state.ageInTicks, 2f);
			super.setupAnim(state);
		}
	}
}