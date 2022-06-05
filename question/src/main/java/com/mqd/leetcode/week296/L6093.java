package com.mqd.leetcode.week296;

/**
 * leetcode 6093 设计一个文本编辑器
 */
public class L6093 {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("bxyackuncqzcqo");
        System.out.println(textEditor.cursorLeft(12));
        System.out.println(textEditor.deleteText(3));
        System.out.println(textEditor.cursorLeft(5));
        textEditor.addText("osdhyvqxf");
        System.out.println(textEditor.cursorRight(10));
    }
}
