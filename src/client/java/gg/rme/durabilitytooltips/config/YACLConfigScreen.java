package gg.rme.durabilitytooltips.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class YACLConfigScreen {
    public ConfigScreenFactory<Screen> create() {
        return parent -> {
            ModConfig config = ModConfig.getInstance();

            Text colourDescriptionText = Text.translatable("config.rmes-durability-tooltips.colours.desc").formatted(Formatting.WHITE)
                    .append(Text.literal("BLACK ").formatted(Formatting.BLACK))
                    .append(Text.literal("DARK_BLUE ").formatted(Formatting.DARK_BLUE))
                    .append(Text.literal("DARK_GREEN ").formatted(Formatting.DARK_GREEN))
                    .append(Text.literal("DARK_AQUA ").formatted(Formatting.DARK_AQUA))
                    .append(Text.literal("DARK_RED ").formatted(Formatting.DARK_RED))
                    .append(Text.literal("DARK_PURPLE ").formatted(Formatting.DARK_PURPLE))
                    .append(Text.literal("GOLD ").formatted(Formatting.GOLD))
                    .append(Text.literal("GRAY ").formatted(Formatting.GRAY))
                    .append(Text.literal("DARK_GRAY ").formatted(Formatting.DARK_GRAY))
                    .append(Text.literal("BLUE ").formatted(Formatting.BLUE))
                    .append(Text.literal("GREEN ").formatted(Formatting.GREEN))
                    .append(Text.literal("AQUA ").formatted(Formatting.AQUA))
                    .append(Text.literal("RED ").formatted(Formatting.RED))
                    .append(Text.literal("LIGHT_PURPLE ").formatted(Formatting.LIGHT_PURPLE))
                    .append(Text.literal("YELLOW ").formatted(Formatting.YELLOW))
                    .append(Text.literal("WHITE ").formatted(Formatting.WHITE));


            Option<Boolean> tooltipsEnabled = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.tooltips_enabled"))
                    .binding(true, config::isTooltipEnabled, config::setTooltipEnabled)
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> tooltipEnabledWhenFull = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_full_durability"))
                    .description(OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_full_durability.desc")))
                    .binding(false, config::isTooltipEnabledWhenFull, config::setTooltipEnabledWhenFull)
                    .controller(TickBoxControllerBuilder::create)
                    .build();

            Option<Boolean> tooltipEnabledWhenEmpty = Option.<Boolean>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_no_durability"))
                    .description(OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_no_durability.desc")))
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
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.high_durability_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("GREEN", config::getTooltipHighColour, config::setTooltipHighColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> mediumDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.medium_durability_colour"))
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.medium_durability_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("YELLOW", config::getTooltipMediumColour, config::setTooltipMediumColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> lowDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.low_durability_colour"))
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.low_durability_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("RED", config::getTooltipLowColour, config::setTooltipLowColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> noDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.no_durability_colour"))
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.no_durability_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("DARK_GRAY", config::getTooltipEmptyColour, config::setTooltipEmptyColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> separatorColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.separator_colour"))
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.separator_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("GRAY", config::getTooltipSeparatorColour, config::setTooltipSeparatorColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            Option<String> maxDurabilityColour = Option.<String>createBuilder()
                    .name(Text.translatable("config.rmes-durability-tooltips.colours.max_durability_colour"))
                    .description(
                            OptionDescription.of(Text.translatable("config.rmes-durability-tooltips.colours.max_durability_colour.desc")
                                    .append(Text.literal("\n\n"))
                                    .append(colourDescriptionText))
                    )
                    .binding("GRAY", config::getTooltipMaxDurabilityColour, config::setTooltipMaxDurabilityColour)
                    .controller(StringControllerBuilder::create)
                    .build();

            return YetAnotherConfigLib.createBuilder().
                    title(Text.translatable("title.rmes-durability-tooltips.config"))
                    .save(config::saveConfig)
                    .category(ConfigCategory.createBuilder()
                            .name(Text.translatable("title.rmes-durability-tooltips.config"))
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
