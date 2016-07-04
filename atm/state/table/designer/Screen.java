/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.state.table.designer;

import javax.swing.JButton;

/**
 *
 * @author Harish
 */
public class Screen {
    public String id;
    public String name, text;
    public char[][] buffer = new char[16][32];
    
    public Screen(int id)
    {
        
        StringBuilder nameb = new StringBuilder("screen");
        nameb.append(id);
        name = nameb.toString();
        text = "New Screen";
        this.id = nameb.toString();
        clearBuffer();
    }
    public Screen(int id,String name, String text)
    {
        this.name = name;
        this.text = text;
        StringBuilder nameb = new StringBuilder("new_screen");
        nameb.append(id);
        this.id = nameb.toString();
        clearBuffer();
    }
    public final void clearBuffer()
    {
        int i,j;
        for(i=0; i<16;i++)
        {
            for(j=0;j<32;j++)
            {
                buffer[i][j] = ' ';
            }
        }
    }
    public void addString(int x, int y, String text)
    {
        int j, t=0;
        char[] temp_text;// = new char[text.length()];
        temp_text = text.toCharArray();
        for(j = y; j < 32 && t < text.length(); j++,t++)
        {
            buffer[x][j] = temp_text[t];
        }
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    public String getName()
    {
        return name;
    }
    public String getText()
    {
        return text;
    }
}
