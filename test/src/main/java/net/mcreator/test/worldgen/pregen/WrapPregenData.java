package net.mcreator.test.worldgen.pregen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;

public final class WrapPregenData extends SavedData {
    public boolean started;
    public boolean done;
    public int minCX, maxCX, minCZ, maxCZ;
    public int curCX, curCZ;

    public WrapPregenData() {
        this.started = false;
        this.done = false;
        this.minCX = this.minCZ = 0;
        this.maxCX = this.maxCZ = -1;
        this.curCX = this.curCZ = 0;
    }

    private static final Codec<WrapPregenData> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.BOOL.fieldOf("started").forGetter(d -> d.started),
            Codec.BOOL.fieldOf("done").forGetter(d -> d.done),
            Codec.INT.fieldOf("minCX").forGetter(d -> d.minCX),
            Codec.INT.fieldOf("maxCX").forGetter(d -> d.maxCX),
            Codec.INT.fieldOf("minCZ").forGetter(d -> d.minCZ),
            Codec.INT.fieldOf("maxCZ").forGetter(d -> d.maxCZ),
            Codec.INT.fieldOf("curCX").forGetter(d -> d.curCX),
            Codec.INT.fieldOf("curCZ").forGetter(d -> d.curCZ)
    ).apply(i, (started, done, minCX, maxCX, minCZ, maxCZ, curCX, curCZ) -> {
        var d = new WrapPregenData();
        d.started = started;
        d.done = done;
        d.minCX = minCX;
        d.maxCX = maxCX;
        d.minCZ = minCZ;
        d.maxCZ = maxCZ;
        d.curCX = curCX;
        d.curCZ = curCZ;
        return d;
    }));

    public static final SavedDataType<WrapPregenData> ID =
            new SavedDataType<>("wrap_pregen", WrapPregenData::new, CODEC);

    public static WrapPregenData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(ID);
    }

    public void beginRect(int minCX, int minCZ, int maxCX, int maxCZ) {
        this.started = true;
        this.done = false;
        this.minCX = minCX;
        this.minCZ = minCZ;
        this.maxCX = maxCX;
        this.maxCZ = maxCZ;
        this.curCX = minCX;
        this.curCZ = minCZ;
        this.setDirty();
    }
}