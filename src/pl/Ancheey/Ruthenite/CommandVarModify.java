package pl.Ancheey.Ruthenite;

/**
 * Used for all variable modifications in the Manager
 */
public class CommandVarModify extends  CommandVar {
    Action action;

    /**
     * Creates a new command that will take the variable varName and use Action on it with value as the parameter
     * @param varName variable name to modify
     * @param value variable name or an int as a parameter
     * @param action action to perform
     */
    public CommandVarModify(String varName, String value, Action action) {
        super(varName, value);
        this.action = action;
    }

    /**
     * Tells the Selenium Manager to set the variable to new value
     */
    @Override
    public void execute() {
        int var = RutheniteCore.I().getVar(varName);
        switch (action){

            case INCREMENT -> RutheniteCore.I().setVar(varName, var + getValue());
            case DECREMENT -> RutheniteCore.I().setVar(varName, var - getValue());
            case MULTIPLY -> RutheniteCore.I().setVar(varName, var * getValue());
            case DIVIDE_BY -> {
                if(getValue() != 0) {
                    RutheniteCore.I().setVar(varName, var / getValue());
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Modifies variable \"" + varName + "\" using the action " + action.toString() + " by " + value;
    }

    public enum Action{
        INCREMENT,
        DECREMENT,
        MULTIPLY,
        DIVIDE_BY
    }
}
