package pl.Ancheey.Ruthenite;

public class BooleanStatementSingle implements BooleanStatement{
    SingleVar statement;
    String value;

    public BooleanStatementSingle(String value, SingleVar statement){
        this.value = value;
        this.statement = statement;
    }

    /**
     * @return Statement evaluation based on variables passed on object construction
     */
    public boolean evaluate() {
        switch (statement){
            case EXISTS -> {
                return RutheniteCore.I().getVars().containsKey(value);}
            case NOT_EXISTS -> {
                return !RutheniteCore.I().getVars().containsKey(value);
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return value + " " + statement.toString();
    }
}
