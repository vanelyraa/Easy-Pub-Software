/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author vanel Method limit characters from JtextFields using plainDocument
 */
public class TextFieldLength extends PlainDocument {

    private int maxChar;


    public TextFieldLength(int max) {
        this.maxChar = max;
 
    }

    @Override
    public void insertString(int offset, String text, AttributeSet atSet) throws BadLocationException {
        if (text == null) {
            return;
        } else if ((getLength() + text.length()) <= maxChar) {
            text = text.toUpperCase();
            super.insertString(offset, text, atSet);
        }
    }
}
