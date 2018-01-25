package objects;

import java.util.Map;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import javafx.util.Callback; 
 
public class MyMaskTextField extends TextField {  
    private static final char INPUT_MASK_LETTER = 'A'; 
    private static final char INPUT_MASK_DIGIT_OR_LETTER = 'N'; 
    private static final char INPUT_MASK_ANY_NON_SPACE = 'X'; 
    private static final char INPUT_MASK_DIGIT = '9'; 
    private static final char INPUT_MASK_DIGIT_0_TO_8 = '8'; 
    private static final char INPUT_MASK_DIGIT_0_TO_7 = '7'; 
    private static final char INPUT_MASK_DIGIT_0_TO_6 = '6'; 
    private static final char INPUT_MASK_DIGIT_0_TO_5 = '5'; 
    private static final char INPUT_MASK_DIGIT_0_TO_4 = '4'; 
    private static final char INPUT_MASK_DIGIT_0_TO_3 = '3'; 
    private static final char INPUT_MASK_DIGIT_0_TO_2 = '2'; 
    private static final char INPUT_MASK_DIGIT_0_TO_1 = '1'; 
    private static final char INPUT_MASK_DIGIT_ZERO = '0'; 
 
    private StringProperty _inputMaskProperty; 
    private StringProperty _requiredMaskProperty; 
    private StringProperty _conversionMaskProperty; 
    private StringProperty _validCharactersProperty; 
    private StringProperty _invalidCharactersProperty; 
    private ObjectProperty<Character> _placeholderCharacterProperty; 
    private StringProperty _initialTextProperty; 
    private BooleanProperty _autoAdvanceProperty; 
   
    private ObservableMap<Character, Callback<Character, Boolean>> _maskVerifiers; 
    private ObservableMap<Character, Callback<Character, Character>> _conversions; 
    private String _fixedText; 
 
    public MyMaskTextField(String mask) { 
    	super();
        initializeInputMaskVerifiers(); 
        setInputMask(mask); 
    } 
 
    private void initializeInputMaskVerifiers() { 
        Map<Character, Callback<Character, Boolean>> maskVerifiers = getInputMaskVerifiers(); 
        maskVerifiers.clear(); 
        maskVerifiers.put(INPUT_MASK_LETTER, c -> Character.isLetter(c)); 
        maskVerifiers.put(INPUT_MASK_DIGIT_OR_LETTER, c -> Character.isLetterOrDigit(c)); 
        maskVerifiers.put(INPUT_MASK_ANY_NON_SPACE, c -> !Character.isSpaceChar(c)); 
        maskVerifiers.put(INPUT_MASK_DIGIT, c -> Character.isDigit(c)); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_8, c -> (c >= '0' && c <= '8')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_7, c -> (c >= '0' && c <= '7')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_6, c -> (c >= '0' && c <= '6')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_5, c -> (c >= '0' && c <= '5')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_4, c -> (c >= '0' && c <= '4')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_3, c -> (c >= '0' && c <= '3')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_2, c -> (c >= '0' && c <= '2')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_0_TO_1, c -> (c >= '0' && c <= '1')); 
        maskVerifiers.put(INPUT_MASK_DIGIT_ZERO, c -> (c == '0')); 
    } 

    private ObservableMap<Character, Callback<Character, Boolean>> getInputMaskVerifiers() { 
        if (_maskVerifiers == null) { 
            _maskVerifiers = FXCollections.observableHashMap(); 
        } 
        return _maskVerifiers; 
    } 

    private ObservableMap<Character, Callback<Character, Character>> getConversions() { 
        if (_conversions == null) { 
            _conversions = FXCollections.observableHashMap(); 
        } 
        return _conversions; 
    } 

    @Override 
    public void clear() { 
        setTextWithoutChecking(getInitialText() != null ? getInitialText() : getInitialTextFromMask()); 
    } 
 
    boolean enforcing = true; 
 
    private void setTextWithoutChecking(String text) { 
        try { 
            enforcing = false; 
            setText(text); 
        } 
        finally { 
            enforcing = true; 
        } 
    } 
 
    private String getFixedText() { 
        if (_fixedText == null) { 
            _fixedText = getInitialTextFromMask(); 
        } 
        return _fixedText; 
    } 
 
    private String getInitialTextFromMask() { 
        String mask = getInputMask(); 
        if (mask != null) { 
            Map<Character, Callback<Character, Boolean>> maskVerifiers = getInputMaskVerifiers(); 
            for (Character c : maskVerifiers.keySet()) { 
                mask = mask.replace(c, getPlaceholderCharacter()); 
            } 
        } 
        return mask; 
    } 
 
    private ObjectProperty<Character> placeholderCharacterProperty() { 
        if (_placeholderCharacterProperty == null) { 
            _placeholderCharacterProperty = new SimpleObjectProperty<Character>(this, "placeholderCharacter", ' ') { //NON-NLS 
                @Override 
                protected void invalidated() { 
                    super.invalidated(); 
                    clear(); 
                } 
            }; 
        } 
        return _placeholderCharacterProperty; 
    } 

    private char getPlaceholderCharacter() { 
        return placeholderCharacterProperty().get(); 
    } 

    private StringProperty inputMaskProperty() { 
        if (_inputMaskProperty == null) { 
            _inputMaskProperty = new SimpleStringProperty(this, "inputMask") { //NON-NLS 
                @Override 
                protected void invalidated() { 
                    super.invalidated(); 
                    clear(); 
                } 
            }; 
        } 
        return _inputMaskProperty; 
    } 

    private String getInputMask() { 
        return inputMaskProperty().get(); 
    } 
    
    public String getInputMaskWithSpaces() {
    	return inputMaskProperty().get().replaceAll("[0-9]", " ");
    }
 
    private void setInputMask(String inputMask) { 
        inputMaskProperty().set(inputMask); 
    } 
 
    private StringProperty requiredMaskProperty() { 
        if (_requiredMaskProperty == null) { 
            _requiredMaskProperty = new SimpleStringProperty(this, "requiredMask"); //NON-NLS 
        } 
        return _requiredMaskProperty; 
    } 
 
    private String getRequiredMask() { 
        return requiredMaskProperty().get(); 
    } 

    private StringProperty conversionMaskProperty() { 
        if (_conversionMaskProperty == null) { 
            _conversionMaskProperty = new SimpleStringProperty(this, "conversionMask"); //NON-NLS 
        } 
        return _conversionMaskProperty; 
    } 
 
    private String getConversionMask() { 
        return conversionMaskProperty().get(); 
    } 
 
    private StringProperty validCharactersProperty() { 
        if (_validCharactersProperty == null) { 
            _validCharactersProperty = new SimpleStringProperty(this, "validCharacters"); //NON-NLS 
        } 
        return _validCharactersProperty; 
    } 

    private String getValidCharacters() { 
        return validCharactersProperty().get(); 
    } 

    private StringProperty invalidCharactersProperty() { 
        if (_invalidCharactersProperty == null) { 
            _invalidCharactersProperty = new SimpleStringProperty(this, "invalidCharacters"); //NON-NLS 
        } 
        return _invalidCharactersProperty; 
    } 

    private String getInvalidCharacters() { 
        return invalidCharactersProperty().get(); 
    } 

    private StringProperty initialTextProperty() { 
        if (_initialTextProperty == null) { 
            _initialTextProperty = new SimpleStringProperty(this, "initialText") { //NON-NLS 
                @Override 
                protected void invalidated() { 
                    super.invalidated(); 
                    clear(); 
                } 
            }; 
        } 
        return _initialTextProperty; 
    } 

    private String getInitialText() { 
        return initialTextProperty().get(); 
    } 

    private BooleanProperty autoAdvanceProperty() { 
        if (_autoAdvanceProperty == null) { 
            _autoAdvanceProperty = new SimpleBooleanProperty(this, "autoAdvance", true); //NON-NLS 
        } 
        return _autoAdvanceProperty; 
    } 

    private boolean isAutoAdvance() { 
        return autoAdvanceProperty().get(); 
    } 

    private String keepFixedText(String text) { 
        StringBuilder buf = new StringBuilder(); 
        for (int i = 0; i < text.length(); i++) { 
            String s = text.substring(i, i + 1); 
            if (getFixedText().contains(s)) { 
                buf.append(s); 
            } 
            else { 
                buf.append(getPlaceholderCharacter()); 
            } 
        } 
        return buf.toString(); 
    } 
 
    private char convert(char c, int index) { 
        String conversionMask = getConversionMask(); 
        if (Character.isSpaceChar(c) && getInputMaskVerifiers().containsKey(getInputMask().charAt(index))) 
            return getPlaceholderCharacter(); 
        if (conversionMask != null && index < conversionMask.length()) { 
            Callback<Character, Character> callback = getConversions().get(conversionMask.charAt(index)); 
            if (callback != null) { 
                return callback.call(c); 
            } 
        } 
        return c; 
    } 
 
    private boolean verifyChar(char c, int index) { 
        String inputMask = getInputMask(); 
        if (inputMask != null && index < inputMask.length()) { 
            char maskChar = inputMask.charAt(index); 
            if (maskChar == c) return true; 
            if (Character.isSpaceChar(c) || c == getPlaceholderCharacter()) { 
                getRequiredMask(); 
            } 
            Callback<Character, Boolean> callback = getInputMaskVerifiers().get(maskChar); 
            return (getValidCharacters() == null || getValidCharacters().trim().isEmpty() || getValidCharacters().contains("" + convert(c, index))) 
                    && (getInvalidCharacters() == null || getInvalidCharacters().trim().isEmpty() || !getInvalidCharacters().contains("" + convert(c, index))) 
                    && (callback != null ? callback.call(convert(c, index)) : maskChar == convert(c, index)); 
        } 
        else return false; 
    } 
 
    @Override 
    public void replaceText(int start, int end, String text) {
        if (getInputMask() != null) { 
            int index = 0; 
            int count = end - start; 
            int caret = getCaretPosition(); 
 
            int caretStart = caret; 
             
            if (text.equals(" ")) { 
            	return; 
            } 
             
            String existingText = getText(); 
            String deletedText = existingText.substring(start, end); 
            String newText = keepFixedText(deletedText); 
             
            super.replaceText(start, end, newText); 
 
            while (start < getInputMask().length()) { 
                if (index >= text.length()) {
                	break; 
                }
                
                char c = text.charAt(index); // get the char from the text. 
                if (verifyChar(c, start)) { 
                    if (getText().length() > start) { // in case it is at the end of the text 
                        super.replaceText(start, start + 1, "" + convert(c, start)); 
                    } else { 
                        super.replaceText(start, start, "" + convert(c, start)); 
                    } 
                    index++; // move to the next char in the text 
                    start++; // move to the next caret position 
                    count--; // counting how many char we replaced and we just did one char here. 
                } else { 
                    if (isAutoAdvance() && (getFixedText().contains("" + c) || 
                            (caret < existingText.length() && existingText.charAt(caret) != getPlaceholderCharacter() && getFixedText().contains("" + existingText.charAt(caret))))) { 
                        start++; // move to the next caret position 
                        caret++; 
                        selectRange(caret, caret); 
                    } else { 
                        break; 
                    } 
                     
                    String inputMask = getInputMask(); 
                    if ( inputMask != null ) { 
                    	while ( Character.isSpaceChar(inputMask.charAt(start)) && (start < inputMask.length()) && (!text.isEmpty())) { 
                    		start++; 
                    	} 
       
                    	this.replaceText(start, start, text); 
                    }    
                } 

                if (count <= 0 && index >= text.length()) { 
                    break; 
                } 
            } 
             
            selectRange(start, start); 
 
            if ( (caretStart == getInputMask().length()) && (start == 0) && (!text.isEmpty()) && (caretStart == caret)  && (caretStart == end) ) { 
            	this.replaceText(start, start, text); 
            }    
        } else { 
            super.replaceText(start, end, text); 
        } 
    } 
 
    @Override 
    public void replaceSelection(String replacement) { 
        IndexRange range = getSelection(); 
        
        if (getInputMask() != null) { 
            String newText = keepFixedText(getSelectedText()); 
            super.replaceText(range.getStart(), range.getEnd(), newText); 
            selectRange(range.getStart(), range.getStart()); 
            for (int i = 0; i < replacement.length(); i++) { 
                int start = getCaretPosition(); 
                replaceText(start, start, "" + replacement.charAt(i)); 
            } 
        } else { 
            super.replaceSelection(replacement); 
        } 
    } 

}