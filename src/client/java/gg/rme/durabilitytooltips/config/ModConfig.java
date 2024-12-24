package gg.rme.durabilitytooltips.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    private static ModConfig INSTANCE;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE_NAME = "rmes-durability-tooltips.json";

    public static final Logger LOGGER = LogManager.getLogger("RME's Durability Tooltips/Config");

    @SerializedName("tooltips_enabled")
    private boolean tooltipEnabled = true;

    @SerializedName("enable_tooltip_when_item_has_full_durability")
    private boolean tooltipEnabledWhenFull = false;

    @SerializedName("enable_tooltip_when_item_has_no_durability")
    private boolean tooltipEnabledWhenEmpty = true;

    @SerializedName("tooltip_separator")
    private String tooltipSeparator = " / ";

    @SerializedName("high_durability_colour")
    private String tooltipHighColour = "GREEN";

    @SerializedName("medium_durability_colour")
    private String tooltipMediumColour = "YELLOW";

    @SerializedName("low_durability_colour")
    private String tooltipLowColour = "RED";

    @SerializedName("no_durability_colour")
    private String tooltipEmptyColour = "DARK_GRAY";

    @SerializedName("separator_colour")
    private String tooltipSeparatorColour = "GRAY";

    @SerializedName("max_durability_colour")
    private String tooltipMaxDurabilityColour = "GRAY";

    public static ModConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ModConfig();
        }
        return INSTANCE;
    }

    public static void setInstance(ModConfig config) {
        INSTANCE = config;
    }

    public void saveConfig() {
        try (FileWriter writer = new FileWriter(getConfigFile())) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            LOGGER.error("[RME's Durability Tooltips] Failed to save config: {}", e.getMessage());
        }
    }

    public static void loadConfig() {
        File config = getConfigFile();

        if (config.exists()) {
            try (FileReader reader = new FileReader(config)) {
                ModConfig modConfig = GSON.fromJson(reader, ModConfig.class);
                setInstance(modConfig);
            } catch (IOException e) {
                LOGGER.error("[RME's Durability Tooltips] Failed to load config: {}", e.getMessage());
            }
        } else {
            getInstance().saveConfig();
            LOGGER.info("[RME's Durability Tooltips] Created config file.");
        }
    }

    private static File getConfigFile() {
        return new File("config", CONFIG_FILE_NAME);
    }

    public boolean isTooltipEnabled() {
        return this.tooltipEnabled;
    }

    public void setTooltipEnabled(boolean featureEnabled) {
        this.tooltipEnabled = featureEnabled;
    }

    public boolean isTooltipEnabledWhenFull() {
        return this.tooltipEnabledWhenFull;
    }

    public void setTooltipEnabledWhenFull(boolean featureEnabled) {
        this.tooltipEnabledWhenFull = featureEnabled;
    }

    public boolean isTooltipEnabledWhenEmpty() {
        return this.tooltipEnabledWhenEmpty;
    }

    public void setTooltipEnabledWhenEmpty(boolean featureEnabled) {
        this.tooltipEnabledWhenEmpty = featureEnabled;
    }

    public String getTooltipSeparator() {
        return this.tooltipSeparator;
    }

    public void setTooltipSeparator(String separator) {
        this.tooltipSeparator = separator;
    }

    public String getTooltipHighColour() {
        return this.tooltipHighColour;
    }

    public void setTooltipHighColour(String colour) {
        this.tooltipHighColour = colour;
    }

    public String getTooltipMediumColour() {
        return this.tooltipMediumColour;
    }

    public void setTooltipMediumColour(String colour) {
        this.tooltipMediumColour = colour;
    }

    public String getTooltipLowColour() {
        return this.tooltipLowColour;
    }

    public void setTooltipLowColour(String colour) {
        this.tooltipLowColour = colour;
    }

    public String getTooltipEmptyColour() {
        return this.tooltipEmptyColour;
    }

    public void setTooltipEmptyColour(String colour) {
        this.tooltipEmptyColour = colour;
    }

    public String getTooltipMaxDurabilityColour() {
        return this.tooltipMaxDurabilityColour;
    }

    public void setTooltipMaxDurabilityColour(String colour) {
        this.tooltipMaxDurabilityColour = colour;
    }

    public String getTooltipSeparatorColour() {
        return this.tooltipSeparatorColour;
    }

    public void setTooltipSeparatorColour(String colour) {
        this.tooltipSeparatorColour = colour;
    }
}
