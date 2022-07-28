package wind.spirit.squdreport;

import org.bukkit.plugin.java.JavaPlugin;
import wind.spirit.squdreport.commands.maincommands;
import wind.spirit.squdreport.commands.rcommands;

public final class Squdreport extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("\u001b[32m[SquidReport]插件正在加载...\u001b[37m");
        System.out.println("\u001b[36m===============[SquidReport]==============\u001b[37m");
        System.out.println("\u001b[36m|    _______ \u001b[37m");
        System.out.println("\u001b[36m|   / __/ _ \\          Squid_Report\u001b[37m");
        System.out.println("\u001b[36m|  _\\ \\/ , _/       作者：Naughty_Wind\u001b[37m");
        System.out.println("\u001b[36m| /___/_/|_|            版本：1.5\u001b[37m");
        System.out.println("\u001b[36m|\u001b[37m");
        System.out.println("\u001b[36m==========================================\u001b[37m");
        getCommand("report").setExecutor(new rcommands());
        getCommand("sr").setExecutor(new maincommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
