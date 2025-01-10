package com.yupi.cli.command;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "CommandExecutor", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }
    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入--help查看命令提示");
    }
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
