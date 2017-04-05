package me.notifly.warlordshud.main;

import com.google.common.collect.Lists;
import me.notifly.warlordshud.HudPropertyApi;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

import java.util.List;

/**
 * Created by Dan on 04/04/2017.
 */
public class CommandHUD implements ICommand {

    private final List<String> aliases = Lists.newArrayList("hud");
    private HudPropertyApi api;

    public CommandHUD(HudPropertyApi api) {
        this.api = api;
    }

    @Override
    public String getCommandName() {
        return "hud";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "hud";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        new DelayedTask(() -> api.openConfigScreen(), 1);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
