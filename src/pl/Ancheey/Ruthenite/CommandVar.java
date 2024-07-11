package pl.Ancheey.Ruthenite;

/**
 * Base class for all variable operations on the Selenium Manager
 */
public abstract class CommandVar extends Command{
    String varName;
    String value;
    public CommandVar(String varName, String value){
        this.varName = varName;
        this.value = value;
    }

    /**
     * @return the value contained under this variable name in the Selenium Manager. Returns 0 if that variable doesn't exist
     */
    public int getValue(){
        if(RutheniteCore.I().getVars().containsKey(value)){
            return RutheniteCore.I().getVar(value);
        }
        else{
            try{
                return Integer.parseInt(value);
            }
            catch(NumberFormatException ignored){}
            return 0;
        }
    }
}
