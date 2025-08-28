// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.12.6
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * 
 * @author Author
 */
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class nagolemAnimation {
    public static final AnimationDefinition flower = AnimationDefinition.Builder.withLength(0.0F).looping()
            .addAnimation("arm0",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F,
                            KeyframeAnimations.degreeVec(-46.05F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();

    public static final AnimationDefinition stand = AnimationDefinition.Builder.withLength(0.0F).looping()
            .addAnimation("arm0",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F,
                            KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();

    public static final AnimationDefinition walk = AnimationDefinition.Builder.withLength(0.0F).looping()
            .addAnimation("body",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.5928F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.5928F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm0",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(-30.6187F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.6187F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg0",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0178F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F,
                    KeyframeAnimations.degreeVec(-10.0178F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();

    public static final AnimationDefinition attack = AnimationDefinition.Builder.withLength(1.25F).looping()
            .addAnimation("arm0",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(302.5F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
