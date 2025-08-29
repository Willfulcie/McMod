package net.mcreator.test.worldgen.pregen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;

@EventBusSubscriber(modid = CommonConfig.MODID)
public final class PregenBootstrap {
    private static final Logger LOGGER = LogManager.getLogger();
    private PregenBootstrap(){}

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load e) {
        if (!(e.getLevel() instanceof ServerLevel level)) return;
        if (!CommonConfig.PREGEN_ENABLED_DEFAULT.get()) return;

        var data = WrapPregenData.get(level);
        if (data.started) return; // already configured

        if (CommonConfig.PREGEN_USE_FIXED_BOUNDS.get()) {
            int minCX = CommonConfig.PREGEN_MIN_CX.get();
            int maxCX = CommonConfig.PREGEN_MAX_CX.get();
            int minCZ = CommonConfig.PREGEN_MIN_CZ.get();
            int maxCZ = CommonConfig.PREGEN_MAX_CZ.get();

            if (minCX > maxCX) { int t = minCX; minCX = maxCX; maxCX = t; }
            if (minCZ > maxCZ) { int t = minCZ; minCZ = maxCZ; maxCZ = t; }

            data.beginRect(minCX, minCZ, maxCX, maxCZ);
            long total = (long)(maxCX - minCX + 1) * (long)(maxCZ - minCZ + 1);
            LOGGER.info("[Pregen] Fixed bounds set: X:[{}..{}] Z:[{}..{}] total={} chunks", minCX, maxCX, minCZ, maxCZ, total);
        } else {
            int cx = level.getSharedSpawnPos().getX() >> 4;
            int cz = level.getSharedSpawnPos().getZ() >> 4;
            int hx = Math.max(1, CommonConfig.PREGEN_RECT_SIZE_CHUNKS_X.get());
            int hz = Math.max(1, CommonConfig.PREGEN_RECT_SIZE_CHUNKS_Z.get());
            data.beginRect(cx - hx, cz - hz, cx + hx, cz + hz);
            long total = (long)(2*hx + 1) * (long)(2*hz + 1);
            LOGGER.info("[Pregen] Spawn-centered bounds set: center=({}, {}) half=({}, {}) total={} chunks", cx, cz, hx, hz, total);
        }
    }
}