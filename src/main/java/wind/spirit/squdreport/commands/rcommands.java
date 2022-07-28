package wind.spirit.squdreport.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rcommands implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String errorMessage = ChatColor.GREEN + "[SR]/report [玩家] [原因]";  //错误信息
        Player target = Bukkit.getServer().getPlayer(args[0]);

        //======================================================
        //  定义并初始化一个boolean变量，用于储存玩家是否输入理由的变量
        //  检查参数数量以判断玩家是否输入理由
        //======================================================
        boolean hasReason = args.length != 1;

        //======================================================
        //  时间，用于反馈举报时间
        //======================================================
        SimpleDateFormat reportTime = new SimpleDateFormat();
        reportTime.applyPattern("MM月dd日 HH:mm:ss");
        Date time = new Date();

        //======================================================
        //  检查目标是否在线
        //======================================================
        String isOnline;
        if (target == null){
            isOnline = ChatColor.RED + "(离线)";
        } else {
            isOnline = ChatColor.GREEN + "(在线)";
        }

        if (args.length == 0 || args.length > 2) //参数数量检查语法
        {
            sender.sendMessage(ChatColor.RED + "[SR]您输入的参数不正确！");
            sender.sendMessage(errorMessage);  //发送错误信息

        }  else if(!(sender instanceof Player)){ //检查是否为玩家执行指令
            sender.sendMessage(ChatColor.RED + "[SR]这个指令只能玩家执行"); //向控制台发送错误信息
        } else {

            //======================================================
            //  遍历服务器中所有在线玩家，并判断此玩家是否为管理员
            //  如果是，则发送举报信息，否则不发送
            //  最后向玩家发送举报成功的信息
            //======================================================

            for (Player tempPlayer : Bukkit.getServer().getOnlinePlayers()) {
                if (tempPlayer.isOp() || tempPlayer.equals(sender)) {
                    tempPlayer.sendMessage(ChatColor.GOLD + "===============[SquidReport]===============");
                    tempPlayer.sendMessage(ChatColor.GREEN + sender.getName() + ChatColor.GOLD + "举报了" + ChatColor.RED + args[0] + isOnline);

                    //======================================================
                    //  判断玩家是否输入理由
                    //  发送不同的信息
                    //======================================================

                    if (!(hasReason)) {
                        tempPlayer.sendMessage(ChatColor.GOLD + "玩家没有填写理由");
                    } else {
                        tempPlayer.sendMessage(ChatColor.GOLD + "举报理由: " + ChatColor.GREEN + args[1]);
                    }
                    tempPlayer.sendMessage(ChatColor.GOLD + "举报时间: " + reportTime.format(time));
                    tempPlayer.sendMessage(ChatColor.GOLD + "===========================================");
                }
            }

        }
        return true;
    }
}
