package net.mcreator.test.worldgen.pregen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@EventBusSubscriber(modid = CommonConfig.MODID)
public final class WorldPregen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static int counter = 0;

    private WorldPregen(){}

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post e) {
        MinecraftServer server = e.getServer();
        if (server == null) return;

        ServerLevel level = server.overworld();
        if (level == null) return;

        WrapPregenData data = WrapPregenData.get(level);
        if (!data.started || data.done) return;

        int batch = Math.max(1, CommonConfig.PREGEN_BATCH_PER_TICK.get());
        for (int i = 0; i < batch; i++) {
            int cx = data.curCX;
            int cz = data.curCZ;

            level.getChunk(cx, cz);

            if (++data.curCX > data.maxCX) {
                data.curCX = data.minCX;
                if (++data.curCZ > data.maxCZ) {
                    data.done = true;
                    break;
                }
            }
        }
        data.setDirty();

        // progress log
        if (!data.done) {
            counter += batch;
            if (counter >= 2048) {
                long width = (long)(data.maxCX - data.minCX + 1);
                long doneRows = Math.max(0L, (long)(data.curCZ - data.minCZ));
                long doneInRow = Math.max(0L, (long)(data.curCX - data.minCX));
                long doneCount = doneRows * width + doneInRow;
                long total = width * (long)(data.maxCZ - data.minCZ + 1);
                LOGGER.info("[Pregen] Progress: {}/{} ({}%)", doneCount, total, (int)(doneCount * 100 / Math.max(1,total)));
                counter = 0;
            }
        } else {
            long total = (long)(data.maxCX - data.minCX + 1) * (long)(data.maxCZ - data.minCZ + 1);
            LOGGER.info("[Pregen] Completed! Total {} chunks.", total);
        }
    }
}