/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.state.table.designer;

/**
 *
 * @author Harish
 */
public class StateA extends State{
    
    public StateA(int id)
    {
        super(id);
        //StringBuilder nameb = new StringBuilder("state_a");
        //nameb.append(id);
        //super.name = nameb.toString();
        //super.text = "New State A";
        //super.id = nameb.toString();
        
    }
    public void setName(String name)
    {
        super.name = name;
    }
    public void setText(String text)
    {
        super.text = text;
    }
    public String getName()
    {
        return super.name;
    }
    public String getText()
    {
        return super.text;
    }
}
