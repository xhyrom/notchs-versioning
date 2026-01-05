package dev.xhyrom.nv.mixin;

import dev.xhyrom.nv.YearHistory;
import net.minecraft.SharedConstants;
import net.minecraft.WorldVersion;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {
    @Shadow @Nullable private static WorldVersion CURRENT_VERSION;

    @Unique
    private static final Pattern VERSION_PATTERN = Pattern.compile("^(\\d+)\\.(\\d+)(.*)$");
    @Unique
    private static final int BASE_OLD_VERSION = 21;

    static {
        SharedConstants.tryDetectVersion();
        WorldVersion original = SharedConstants.getCurrentVersion();

        CURRENT_VERSION = new WorldVersion.Simple(
                original.id(),
                notchs_versioning$convert(original.name()),
                original.dataVersion(),
                original.protocolVersion(),
                original.packVersion(PackType.CLIENT_RESOURCES),
                original.packVersion(PackType.SERVER_DATA),
                original.buildTime(),
                original.stable()
        );
    }

    @Unique
    private static String notchs_versioning$convert(String original) {
        Matcher matcher = VERSION_PATTERN.matcher(original);

        if (matcher.find()) {
            try {
                int year = Integer.parseInt(matcher.group(1));
                int drop = Integer.parseInt(matcher.group(2));
                String suffix = matcher.group(3);

                int newMajor = BASE_OLD_VERSION + YearHistory.getOffsetForYear(year) + drop;
                return "1." + newMajor + (suffix == null ? "" : suffix) + " (" + original + ")";
            } catch (NumberFormatException e) {
                return original;
            }
        }

        return original;
    }
}
