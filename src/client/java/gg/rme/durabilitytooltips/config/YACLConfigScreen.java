package gg.rme.durabilitytooltips.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class YACLConfigScreen {
    public ConfigScreenFactory<Screen> create() {
        return parent -> {
            ModConfig config = ModConfig.getInstance();

            Option<Boolean> tooltipsEnabled = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.tooltips_enabled"))
                    .binding(true, config::isTooltipEnabled, config::setTooltipEnabled)
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> tooltipEnabledWhenFull = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_full_durability"))
                    .binding(false, config::isTooltipEnabledWhenFull, config::setTooltipEnabledWhenFull)
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> tooltipEnabledWhenEmpty = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_no_durability"))
                    .binding(false, config::isTooltipEnabledWhenEmpty, config::setTooltipEnabledWhenEmpty)
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<String> tooltipSeparator = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.tooltip_separator"))
                    .binding(" / ", config::getTooltipSeparator, config::setTooltipSeparator)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> highDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.high_durability_colour"))
                    .binding("GREEN", config::getTooltipHighColour, config::setTooltipHighColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> mediumDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.medium_durability_colour"))
                    .binding("YELLOW", config::getTooltipMediumColour, config::setTooltipMediumColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> lowDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.low_durability_colour"))
                    .binding("RED", config::getTooltipLowColour, config::setTooltipLowColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> noDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.no_durability_colour"))
                    .binding("DARK_GRAY", config::getTooltipEmptyColour, config::setTooltipEmptyColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> separatorColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.separator_colour"))
                    .description(OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.separator_colour.tooltip")))
                    .binding("GRAY", config::getTooltipSeparatorColour, config::setTooltipSeparatorColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> maxDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.max_durability_colour"))
                    .binding("GRAY", config::getTooltipMaxDurabilityColour, config::setTooltipMaxDurabilityColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Text colourDescriptionText = Text.translatable("config.rmes-durability-tooltips.colours.desc")
                    .setStyle(Style.EMPTY.withFormatting(Formatting.GRAY))
                    .append(Text.literal("BLACK")).setStyle(Style.EMPTY.withFormatting(Formatting.BLACK))
                    .append(Text.literal("DARK_BLUE ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_BLUE)))
                    .append(Text.literal("DARK_GREEN ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_GREEN)))
                    .append(Text.literal("DARK_AQUA ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_AQUA)))
                    .append(Text.literal("DARK_RED ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_RED)))
                    .append(Text.literal("DARK_PURPLE ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_PURPLE)))
                    .append(Text.literal("GOLD ").setStyle(Style.EMPTY.withFormatting(Formatting.GOLD)))
                    .append(Text.literal("GRAY ").setStyle(Style.EMPTY.withFormatting(Formatting.GRAY)))
                    .append(Text.literal("DARK_GRAY ").setStyle(Style.EMPTY.withFormatting(Formatting.DARK_GRAY)))
                    .append(Text.literal("BLUE ").setStyle(Style.EMPTY.withFormatting(Formatting.BLUE)))
                    .append(Text.literal("GREEN ").setStyle(Style.EMPTY.withFormatting(Formatting.GREEN)))
                    .append(Text.literal("AQUA ").setStyle(Style.EMPTY.withFormatting(Formatting.AQUA)))
                    .append(Text.literal("RED ").setStyle(Style.EMPTY.withFormatting(Formatting.RED)))
                    .append(Text.literal("LIGHT_PURPLE ").setStyle(Style.EMPTY.withFormatting(Formatting.LIGHT_PURPLE)))
                    .append(Text.literal("YELLOW ").setStyle(Style.EMPTY.withFormatting(Formatting.YELLOW)))
                    .append(Text.literal("WHITE ").setStyle(Style.EMPTY.withFormatting(Formatting.WHITE)));

            return YetAnotherConfigLib.createBuilder().
                    title(Text.translatable("title.rmes-durability-tooltips.config"))
                    .save(config::saveConfig)
                    .category(ConfigCategory.createBuilder()
                            .name(Text.translatable("config.rmes-durability-tooltips.general"))
                            .group(OptionGroup.createBuilder()
                                    .name(Text.translatable("config.rmes-durability-tooltips.general"))
                                    .option(tooltipsEnabled)
                                    .option(tooltipEnabledWhenFull)
                                    .option(tooltipEnabledWhenEmpty)
                                    .option(tooltipSeparator)
                                    .build())
                            .group(OptionGroup.createBuilder()
                                    .name(Text.translatable("config.rmes-durability-tooltips.colours"))
                                    .option(highDurabilityColour)
                                    .option(mediumDurabilityColour)
                                    .option(lowDurabilityColour)
                                    .option(noDurabilityColour)
                                    .option(separatorColour)
                                    .option(maxDurabilityColour)
                                    .build())
                            .build())
                    .build().generateScreen(parent);
        };
    }
}
