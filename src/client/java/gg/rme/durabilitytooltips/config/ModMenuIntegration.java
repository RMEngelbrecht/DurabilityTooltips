package gg.rme.durabilitytooltips.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (FabricLoader.getInstance().isModLoaded("yet_another_config_lib_v3")) {
            return new YACLConfigScreen().create();
        } else if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return new ClothConfigScreen().create();
        }

        return parent -> new InformationScreen(parent, Text.translatable("title.rmes-durability-tooltips.config"));
    }

}