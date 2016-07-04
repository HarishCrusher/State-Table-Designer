/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.state.table.designer;

/**
 *
 * @author Harish
 */
public class State {
    public String name = "new_state", text = "New State", id;
    public State(int id)
    {
        
        StringBuilder nameb = new StringBuilder("state");
        nameb.append(id);
        name = nameb.toString();
        text = "New State";
        this.id = nameb.toString();
    }
    public String getName()
    {
        return name;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
}
