package net.mcreator.test;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import net.mcreator.test.worldgen.pregen.CommonConfig;

/**
 * If MCreator already generates a main class, just copy the CommonConfig.register(...) line into its constructor.
 */
@Mod(CommonConfig.MODID)
public final class ExampleModMain {
    public ExampleModMain(IEventBus modBus, ModContainer container) {
        // Preferred registration
        CommonConfig.register(container);

        // If you cannot get ModContainer in your generated main, you can instead call:
        // CommonConfig.register();
    }
}
