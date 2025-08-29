package net.mcreator.test.worldgen.pregen;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class CommonConfig {
    private CommonConfig(){}

    public static final String MODID = "test";

    public static final ModConfigSpec SPEC;

    // pregen control
    public static final ModConfigSpec.BooleanValue PREGEN_ENABLED_DEFAULT;
    public static final ModConfigSpec.IntValue PREGEN_BATCH_PER_TICK;

    // --- spawn-centered fallback ---
    public static final ModConfigSpec.IntValue PREGEN_RECT_SIZE_CHUNKS_X;
    public static final ModConfigSpec.IntValue PREGEN_RECT_SIZE_CHUNKS_Z;

    // --- FIXED BOUNDS ---
    public static final ModConfigSpec.BooleanValue PREGEN_USE_FIXED_BOUNDS;
    public static final ModConfigSpec.IntValue PREGEN_MIN_CX;
    public static final ModConfigSpec.IntValue PREGEN_MAX_CX;
    public static final ModConfigSpec.IntValue PREGEN_MIN_CZ;
    public static final ModConfigSpec.IntValue PREGEN_MAX_CZ;

    static {
        ModConfigSpec.Builder b = new ModConfigSpec.Builder();

        PREGEN_ENABLED_DEFAULT = b
                .comment("Start pregen automatically on world load.")
                .define("pregen.enabledDefault", true);

        PREGEN_BATCH_PER_TICK = b
                .comment("How many chunks to process per server tick while pregen runs.")
                .defineInRange("pregen.batchPerTick", 32, 1, 4096);

        // spawn-centered fallback
        PREGEN_RECT_SIZE_CHUNKS_X = b
                .comment("Spawn-centered HALF width in chunks (used when PREGEN_USE_FIXED_BOUNDS = false).")
                .defineInRange("pregen.spawnRectHalfSizeX", 128, 1, 4096);

        PREGEN_RECT_SIZE_CHUNKS_Z = b
                .comment("Spawn-centered HALF height in chunks (used when PREGEN_USE_FIXED_BOUNDS = false).")
                .defineInRange("pregen.spawnRectHalfSizeZ", 128, 1, 4096);

        // fixed bounds
        PREGEN_USE_FIXED_BOUNDS = b
                .comment("If true, pregen uses the fixed rectangle below instead of spawn-centered size.")
                .define("pregen.useFixedBounds", true);

        PREGEN_MIN_CX = b
                .comment("Fixed rectangle: MIN chunk X (inclusive).")
                .defineInRange("pregen.fixed.minCX", -256, -100000, 100000);
        PREGEN_MAX_CX = b
                .comment("Fixed rectangle: MAX chunk X (inclusive).")
                .defineInRange("pregen.fixed.maxCX",   256, -100000, 100000);
        PREGEN_MIN_CZ = b
                .comment("Fixed rectangle: MIN chunk Z (inclusive).")
                .defineInRange("pregen.fixed.minCZ", -256, -100000, 100000);
        PREGEN_MAX_CZ = b
                .comment("Fixed rectangle: MAX chunk Z (inclusive).")
                .defineInRange("pregen.fixed.maxCZ",   256, -100000, 100000);

        SPEC = b.build();
    }

    public static void register(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, SPEC);
    }

    public static void register() {
        ModList.get().getModContainerById(MODID)
                .ifPresent(c -> c.registerConfig(ModConfig.Type.COMMON, SPEC));
    }
}