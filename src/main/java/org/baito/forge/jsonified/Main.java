package org.baito.forge.jsonified;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.Sys;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Mod(
        modid = Main.MOD_ID,
        name = Main.MOD_NAME,
        version = Main.VERSION,
        acceptableRemoteVersions = "*"
)
public class Main {

    public static final String MOD_ID = "jsonified";
    public static final String MOD_NAME = "Jsonified";
    public static final String VERSION = "2019.1-1.2.23";

    @Mod.Instance(MOD_ID)
    public static Main INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Spider.configPath = event.getModConfigurationDirectory().toPath();
    }
}
