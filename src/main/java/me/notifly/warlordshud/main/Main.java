package me.notifly.warlordshud.main;

import me.notifly.warlordshud.HudPropertyApi;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Dan on 04/04/2017.
 */

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {

    public static final String MODID = "WarlordsHUD";
    public static final String NAME = "WarlordsHUD";
    public static final String VERSION = "1.0";

    public static Boolean warlords = false;
    public static Integer currentHealing = 0;
    public static Integer currentDamage = 0;

    @EventHandler
    public void init(FMLInitializationEvent event) {

        HudPropertyApi api = HudPropertyApi.newInstance();
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        api.register(new Renderer());
        ClientCommandHandler.instance.registerCommand(new CommandHUD(api));

    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {

        String message = event.message.getUnformattedText();

        if (message.contains("The gates will fall in ")) {

            warlords = true;

        } else if (warlords == true) {

            if (message.contains(" joined the lobby!")) {

                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Healing: " + EnumChatFormatting.GREEN + currentHealing));
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Damage: " + EnumChatFormatting.RED + currentDamage));

                currentHealing = 0;
                currentDamage = 0;

                warlords = false;

            } else if (message.contains("Your ")&&message.contains(" healed ")&&message.contains(" for ")&&message.contains(" health.")) {

                currentHealing += healing.healingCalc(message);

            } else if (message.contains("You") && message.contains(" hit ") && message.contains(" for ") && message.contains(" damage.")) {

                currentDamage += damage.damageCalc(message);

            }
        }
    }

}
