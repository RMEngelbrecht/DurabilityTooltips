package gg.rme.durabilitytooltips.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ClothConfigScreen {
    public ConfigScreenFactory<Screen> create() {
        return parent -> {
            ModConfig config = ModConfig.getInstance();
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.translatable("title.rmes-durability-tooltips.config"));

            builder.setSavingRunnable(config::saveConfig);

            ConfigCategory general = builder.getOrCreateCategory(Text.translatable("config.rmes-durability-tooltips.general"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            general.addEntry(entryBuilder.startBooleanToggle(
                            Text.translatable("config.rmes-durability-tooltips.general.tooltips_enabled"),
                            config.isTooltipEnabled())
                    .setDefaultValue(true)
                    .setSaveConsumer(config::setTooltipEnabled)
                    .build()
            );

            general.addEntry(entryBuilder.startBooleanToggle(
                            Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_full_durability"),
                            config.isTooltipEnabledWhenFull())
                    .setDefaultValue(false)
                    .setTooltip(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_full_durability.desc"))
                    .setSaveConsumer(config::setTooltipEnabledWhenFull)
                    .build()
            );

            general.addEntry(entryBuilder.startBooleanToggle(
                            Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_no_durability"),
                            config.isTooltipEnabledWhenEmpty())
                    .setDefaultValue(false)
                    .setTooltip(Text.translatable("config.rmes-durability-tooltips.general.enable_tooltip_when_item_has_no_durability.desc"))
                    .setSaveConsumer(config::setTooltipEnabledWhenEmpty)
                    .build()
            );

            general.addEntry(entryBuilder.startStrField(
                            Text.translatable("config.rmes-durability-tooltips.general.tooltip_separator"),
                            config.getTooltipSeparator())
                    .setDefaultValue(" / ")
                    .setTooltip(Text.translatable("config.rmes-durability-tooltips.general.tooltip_separator.desc"))
                    .setSaveConsumer(config::setTooltipSeparator)
                    .build()
            );

            general.addEntry(
                    entryBuilder.startSubCategory(
                            Text.translatable("config.rmes-durability-tooltips.colours"),
                            List.of(
                                    entryBuilder.startTextDescription(Text.translatable("config.rmes-durability-tooltips.colours.desc").formatted(Formatting.GRAY)
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
                                            .append(Text.literal("WHITE ").formatted(Formatting.WHITE))
                                    ).build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.high_durability_colour"),
                                                    config.getTooltipHighColour())
                                            .setDefaultValue("GREEN")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.high_durability_colour.desc"))
                                            .setSaveConsumer(config::setTooltipHighColour)
                                            .build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.medium_durability_colour"),
                                                    config.getTooltipMediumColour())
                                            .setDefaultValue("YELLOW")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.medium_durability_colour.desc"))
                                            .setSaveConsumer(config::setTooltipMediumColour)
                                            .build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.low_durability_colour"),
                                                    config.getTooltipLowColour())
                                            .setDefaultValue("RED")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.low_durability_colour.desc"))
                                            .setSaveConsumer(config::setTooltipLowColour)
                                            .build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.no_durability_colour"),
                                                    config.getTooltipEmptyColour())
                                            .setDefaultValue("DARK_GRAY")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.no_durability_colour.desc"))
                                            .setSaveConsumer(config::setTooltipEmptyColour)
                                            .build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.separator_colour"),
                                                    config.getTooltipSeparatorColour())
                                            .setDefaultValue("GRAY")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.separator_colour.desc").append(config.getTooltipSeparator()))
                                            .setSaveConsumer(config::setTooltipSeparatorColour)
                                            .build(),
                                    entryBuilder.startStrField(
                                                    Text.translatable("config.rmes-durability-tooltips.colours.max_durability_colour"),
                                                    config.getTooltipMaxDurabilityColour())
                                            .setDefaultValue("GRAY")
                                            .setTooltip(Text.translatable("config.rmes-durability-tooltips.colours.max_durability_colour.desc"))
                                            .setSaveConsumer(config::setTooltipMaxDurabilityColour)
                                            .build()
                            )
                    ).build()
            );

            return builder.build();
        };
    }
}