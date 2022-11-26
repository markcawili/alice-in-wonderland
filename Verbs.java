/**
 * title: Verbs.java
 * description: Verbs class for Alice in Wonderland. Represents Verb objects for use in the ingame commands.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

public class Verbs {

    //String for action
    private final String action;

    //String for group label
    private final String group;

    //Constructor for Verbs, passes variables
    public Verbs(String action, String group) {
        this.action = action;
        this.group = group;
    }

    //Getter for variables
    public String getAction() {
        return action;
    }
    public String getGroup() {
        return group;
    }

}
