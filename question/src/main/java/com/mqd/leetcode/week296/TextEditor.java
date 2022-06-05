package com.mqd.leetcode.week296;

class TextEditor {
    StringBuilder value;
    int cursor = 0;

    public TextEditor() {
        this.value = new StringBuilder();
    }
    
    public void addText(String text) {
        value.replace(cursor, cursor, text);
        cursor += text.length();
    }
    
    public int deleteText(int k) {
        int actual = cursor - k > 0 ? k : cursor;
        int s = Math.max(cursor - k, 0);
        value.replace(s, cursor, "");
        cursor -= actual;
        return actual;
    }
    
    public String cursorLeft(int k) {
        cursor  =Math.max(cursor - k, 0);
        int s = Math.max(cursor - 10, 0);
        return value.substring(s, cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min((cursor + k), value.length());
        int s = Math.max(cursor - 10, 0);
        return value.substring(s, cursor);
    }
}