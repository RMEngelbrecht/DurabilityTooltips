package gg.rme.durabilitytooltips.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import java.util.List;

@Environment(EnvType.CLIENT)
public class InformationScreen extends Screen {

    private final Screen parent;

    protected InformationScreen(Screen parent, Text title) {
        super(title);
        this.parent = parent;
    }

    public ButtonWidget buttonBack;
    public ButtonWidget buttonConfig;

    @Override
    protected void init() {
        buttonBack = ButtonWidget.builder(Text.translatable("config.rmes-durability-tooltips.api_missing.button.back"), button -> close())
                .dimensions(width / 2 - 110, height - 30, 100, 20)
                .build();

        buttonConfig = ButtonWidget.builder(Text.translatable("config.rmes-durability-tooltips.api_missing.button.open"), button ->
                        Util.getOperatingSystem().open(FabricLoader.getInstance().getConfigDir().resolve("rmes-durability-tooltips.json").toUri()))
                .dimensions(width / 2 + 10, height - 30, 100, 20)
                .build();

        addDrawableChild(buttonBack);
        addDrawableChild(buttonConfig);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, 15, 0xFFFFFF);

        final String apiMissingKey = "config.rmes-durability-tooltips.api_missing.description";

        try {
            final MultilineText multilineText = MultilineText.create(textRenderer, Text.translatable(apiMissingKey), width - 50);

            multilineText.drawCenterWithShadow(context, width / 2, height / 2);

        } catch (NoSuchMethodError e) {
            List<OrderedText> wrappedText = textRenderer.wrapLines(Text.translatable(apiMissingKey), width - 50);

            int currentY = height / 2;

            for (OrderedText line : wrappedText) {
                context.drawTextWithShadow(
                        textRenderer,
                        line,
                        (width - textRenderer.getWidth(line)) / 2,
                        currentY,
                        0xFFFFFF
                );

                currentY += textRenderer.fontHeight + 2;
            }
        }
    }

    @Override
    public void close() {
        assert client != null;
        client.setScreen(parent);
    }
}
