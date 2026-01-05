package dev.xhyrom.nv.fabric;

import dev.xhyrom.nv.NotchsVersioning;
import net.fabricmc.api.ModInitializer;

public class NotchsVersioningFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NotchsVersioning.init();
    }
}
