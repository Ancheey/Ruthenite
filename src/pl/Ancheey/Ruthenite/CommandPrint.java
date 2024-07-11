package pl.Ancheey.Ruthenite;

public class CommandPrint extends Command{
    private final String text;

    /**
     * Creates a simple debug command that will write out on the SeleniumSea debug console
     * @param text raw text or name of a variable to be written out
     */
    public CommandPrint(String text){
        this.text = text;
    }
    @Override
    public void execute() {
        String outVal = text;
        if(RutheniteCore.I().getVars().containsKey(text)){
            outVal = text + ": " + RutheniteCore.I().getVar(text);
        }
        MainWindow.I().addTextToConsole(outVal);
    }

    @Override
    public String getDescription() {
        return "Prints variable or text " + text;
    }
}
