package gg.rme.durabilitytooltips;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.item.TooltipType;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import gg.rme.durabilitytooltips.config.ModConfig;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class DurabilityTooltipsClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("RME's Durability Tooltips");

    public static KeyBinding showDurabilityKey;

    @Override
    public void onInitializeClient() {

        ModConfig.loadConfig();

        ModConfig config = ModConfig.getInstance();

        showDurabilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.rmes-durability-tooltips.show",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_SHIFT,
                "key.categories.inventory"
        ));

        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, TooltipType type, List<Text> lines) -> {

            if (!type.isAdvanced() && config.isTooltipEnabled()) {
                if (!config.isTooltipEnabledOnlyWhileKeyIsPressed()) {
                    if (stack.getMaxDamage() > 0
                            || (config.isTooltipEnabledWhenEmpty() && stack.getMaxDamage() - stack.getDamage() > 0)
                            || (config.isTooltipEnabledWhenFull() && stack.getMaxDamage() > 0)) {
                        lines.add(Text.empty());
                        lines.add(TooltipHandler.getTooltip(stack));
                    }
                } else if (stack.getMaxDamage() > 0 && isKeyBeingPressed(showDurabilityKey)) {
                    lines.add(Text.empty());
                    lines.add(TooltipHandler.getTooltip(stack));
                }
            }

        });

        LOGGER.info("[RME's Durability Tooltips] Mod loaded!");
    }

    private boolean isKeyBeingPressed(KeyBinding keyBinding) {
        if (keyBinding == null) return false;

        int keyCode = KeyBindingHelper.getBoundKeyOf(keyBinding).getCode();
        if (keyCode == GLFW.GLFW_KEY_UNKNOWN) return false;
        
        long handle = net.minecraft.client.MinecraftClient.getInstance().getWindow().getHandle();

        if (keyBinding.getDefaultKey().getCategory() == InputUtil.Type.KEYSYM) {
            return GLFW.glfwGetKey(handle, keyCode) == GLFW.GLFW_PRESS;
        }

        return false;
    }
}
