package pl.Ancheey.Ruthenite;

/**
 * Base class for Actions that use xPath
 */
public abstract class CommandAction extends Command{
    String xPath;
    public CommandAction(String xPath){
        this.xPath = xPath;
    }
}
