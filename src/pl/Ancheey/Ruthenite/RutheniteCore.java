package pl.Ancheey.Ruthenite;

import java.util.HashMap;
import java.util.Map;

public class RutheniteCore extends Thread {

    public boolean used = false;
    private static RutheniteCore instance;
    private final Map<String,Integer> vars = new HashMap<>();
    private CommandStatement program;

    /**
     * Singleton Declaration for the Selenium Manager
     * THE INSTANCE WILL BE DUMPED IF THE PROCESS HAS FINISHED
     * @return Returns a new or currently active instance of Selenium Manager
     */
    public static RutheniteCore I(){
        if(instance == null || instance.used){
            instance = new RutheniteCore();
        }
        return instance;
    }
    private RutheniteCore() {}

    /**
     * Tries to create a new engine and executes the bound program on it.
     */
    public void run(){
        try{
            getProgram().execute();
            MainWindow.I().addTextToConsole( getProgram().name + " finished!");
        }
        catch(Exception e){
            MainWindow.I().addTextToConsole(e.getClass().getSimpleName() + ": " +e.getMessage());
            e.printStackTrace();
        }
        used = true;
    }

    public Map<String,Integer> getVars() {
        return vars;
    }
    public int getVar(String name) {
        if(vars.containsKey(name)){
            return vars.get(name);
        }
        return 0;
    }
    public void setVar(String name, int value){
        vars.put(name, value);
    }
    public void sleep(int interval) throws InterruptedException {
        Thread.sleep(interval);
    }

    public CommandStatement getProgram() {
        return program;
    }

    public void setProgram(CommandStatement program) {
        this.program = program;
    }
}
