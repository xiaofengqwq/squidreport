package wind.spirit.squdreport.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class maincommands implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String command01 = args[0];  //子命令01
        if (sender.hasPermission("squid.report.user")){  //基础用户权限
            if (args.length == 1){
                if (command01.equals("version")){  //子命令version
                    if (sender.hasPermission("squid.report.admin") || sender.isOp()){   //高级管理员权限
                        //插件版本及信息
                        sender.sendMessage(ChatColor.GOLD + "===============[SRversion]===============");
                        sender.sendMessage(ChatColor.GREEN + "版本: 1.5");
                        sender.sendMessage(ChatColor.GREEN + "作者: Naughty_Wind");
                        sender.sendMessage(ChatColor.GOLD + "=========================================");
                    } else {
                        sender.sendMessage( ChatColor.RED + "你没有权限来执行这个指令！");
                    }
                } else if(command01.equals("help") || command01.equals("")){  //子命令help
                    //插件指令帮助
                    sender.sendMessage(ChatColor.GOLD + "====================[SRversion]====================");
                    sender.sendMessage(ChatColor.GOLD + "/sr help                      查看插件帮助");
                    sender.sendMessage(ChatColor.GOLD + "/report <Player> [Reason]     举报玩家(理由可选填)");
                    sender.sendMessage(ChatColor.GOLD + "/sr version                   查看插件版本");
                    sender.sendMessage(ChatColor.GOLD + "=======================[1.5]=======================");
                }
            } else {
                //插件指令帮助
                sender.sendMessage(ChatColor.GOLD + "====================[SRversion]====================");
                sender.sendMessage(ChatColor.GOLD + "/sr help                      查看插件帮助");
                sender.sendMessage(ChatColor.GOLD + "/report <Player> [Reason]     举报玩家(理由可选填)");
                sender.sendMessage(ChatColor.GOLD + "/sr version                   查看插件版本");
                sender.sendMessage(ChatColor.GOLD + "=======================[1.5]=======================");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "你没有权限来执行这个指令");
        }


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){  //参数1的tab补全
            List<String> mainList = new ArrayList<>();
            mainList.add("help");  //子命令help
            mainList.add("version");  //子命令version
            return mainList;  //返回tab列表
        }
        return null;
    }
}
