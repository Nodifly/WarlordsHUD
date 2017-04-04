package me.notifly.warlordshud;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Dan on 04/04/2017.
 */

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {

    public static final String MODID = "WarlordsHUD";
    public static final String NAME = "WarlordsHUD";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {

        System.out.println("STARTING");

    }

}
