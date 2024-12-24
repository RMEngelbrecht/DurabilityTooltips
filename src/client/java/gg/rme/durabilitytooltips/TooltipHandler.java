package gg.rme.durabilitytooltips;

import gg.rme.durabilitytooltips.config.ModConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TooltipHandler {

    private static Formatting getFormattingFromString(String colour) {
        try {
            return Formatting.valueOf(colour.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Formatting.WHITE;
        }
    }

    private static Formatting getFormattingForTooltip(int maxDurability, int currentDurability){

        ModConfig config = ModConfig.getInstance();

        if(maxDurability * 0.66f <= currentDurability){
            return getFormattingFromString(config.getTooltipHighColour());
        } else if(maxDurability * 0.33f <= currentDurability){
            return getFormattingFromString(config.getTooltipMediumColour());
        } else if (currentDurability > 0) {
            return getFormattingFromString(config.getTooltipLowColour());
        }
        return getFormattingFromString(config.getTooltipEmptyColour());
    }

    public static Text getTooltip(ItemStack stack){

        ModConfig config = ModConfig.getInstance();

        int maxDurability = stack.getMaxDamage();
        int currentDurability = maxDurability - stack.getDamage();

        MutableText currentDurabilityText = Text.literal(String.valueOf(currentDurability))
                .formatted(getFormattingForTooltip(maxDurability, currentDurability));
        MutableText slashText = Text.literal(config.getTooltipSeparator())
                .formatted(getFormattingFromString(config.getTooltipSeparatorColour()));
        MutableText maxDurabilityText = Text.literal(String.valueOf(maxDurability))
                .formatted(getFormattingFromString(config.getTooltipMaxDurabilityColour()));

        return currentDurabilityText.append(slashText).append(maxDurabilityText);
    }
}
