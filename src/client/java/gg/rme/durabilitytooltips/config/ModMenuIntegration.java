package gg.rme.durabilitytooltips.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModMenuIntegration implements ModMenuApi {
    public static final Logger LOGGER = LogManager.getLogger("RME's Durability Tooltips/Config");

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (!FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return parent -> new InformationScreen(parent, Text.translatable("title.rmes-durability-tooltips.config"));
        }
        return new ClothConfigScreen().create();
    }

}