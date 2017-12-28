import org.apache.commons.cli.*;

public class Cli
{
    public static void main(String[] args) throws Exception
    {
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");
        options.addOption("f", "file", true, "File to save program output to");

        String[] arg = {"-h", "-v", "-f", "file", "a"};
        CommandLine commandLine = new DefaultParser().parse(options, arg);

        if (commandLine.hasOption("h"))
        {
            System.out.println("Help Message");
        }
        if (commandLine.hasOption("h"))
        {
            System.out.println(true);
        }
        if (commandLine.hasOption("f"))
        {
            System.out.println(commandLine.getOptionValue("f"));
        }
    }
}
