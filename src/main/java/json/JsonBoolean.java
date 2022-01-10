package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private boolean bool;

    public JsonBoolean(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toJson() {
        if (this.bool) {
            return "true";
        } else {
            return "false";
        }
    }
}
