package me.notifly.warlordshud.main;

import me.notifly.warlordshud.IRenderer;
import me.notifly.warlordshud.util.ScreenPosition;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Renderer implements IRenderer {

	private FontRenderer fontRenderer;

	public Renderer() {
		fontRenderer = Minecraft.getMinecraft().fontRendererObj;
	}

	@Override
	public void save(ScreenPosition position) {
		Config.X_1 = position.getRelativeX();
		Config.Y_1 = position.getRelativeY();
	}

	@Override
	public ScreenPosition load() {
		return ScreenPosition.fromRelativePosition(Config.X_1, Config.Y_1);
	}

	@Override
	public void render(ScreenPosition position){
            if (Main.warlords == true) {
				Minecraft.getMinecraft().fontRendererObj.drawString("Healing: " + Main.currentHealing.toString(), position.getAbsoluteX(), position.getAbsoluteY(), 0x3ffe3f);
				Minecraft.getMinecraft().fontRendererObj.drawString("Damage: " + Main.currentDamage.toString(), position.getAbsoluteX(), position.getAbsoluteY()+Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2, 0xfe3f3f);
		}
	}

	@Override
	public int getHeight() {
		return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT*2+2;
	}

	@Override
	public int getWidth() {
		return Minecraft.getMinecraft().fontRendererObj.getStringWidth("Healing: " + Main.currentHealing.toString());
	}

	@Override
	public void renderDummy(ScreenPosition position){
		if (Main.warlords == true) {
            Minecraft.getMinecraft().fontRendererObj.drawString("Healing: " + Main.currentHealing.toString(), position.getAbsoluteX(), position.getAbsoluteY(), 0x3ffe3f);
            Minecraft.getMinecraft().fontRendererObj.drawString("Damage: " + Main.currentDamage.toString(), position.getAbsoluteX(), position.getAbsoluteY() + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2, 0xfe3f3f);
		}
	}
}
