package dev.xhyrom.nv.neoforge;

import dev.xhyrom.nv.NotchsVersioning;
import net.neoforged.fml.common.Mod;

@Mod(NotchsVersioning.ID)
public class NotchsVersioningNeoForge {
    public NotchsVersioningNeoForge() {
        NotchsVersioning.init();
    }
}
