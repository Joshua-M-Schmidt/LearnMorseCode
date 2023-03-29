package com.nova.learnmorsecode.auxiliary;

import java.util.HashMap;
import java.util.Map;

public class MorseInfo {
    public static final String DASH = "–";
    public static final String DOT = "·";

    public static final String A = "·–";
    public static final String B = "–···";
    public static final String C = "–·–·";
    public static final String D = "–··";
    public static final String E = "·";
    public static final String F = "··–·";
    public static final String G = "––·";
    public static final String H = "···";
    public static final String I = "··";
    public static final String J = "·–––";
    public static final String K = "–·–";
    public static final String L = "·–··";
    public static final String M = "––";
    public static final String N = "–·";
    public static final String O = "–––";
    public static final String P = "·––·";
    public static final String Q = "––·–";
    public static final String R = "·–·";
    public static final String S = "···";
    public static final String T = "–";
    public static final String U = "··–";
    public static final String V = "···–";
    public static final String W = "·––";
    public static final String X = "–··–";
    public static final String Y = "––·–";
    public static final String Z = "––··";

    public static Map<String, String> getMorseAphabet(){
        Map<String, String> alphabet = new HashMap<String, String>();
        alphabet.put("A", "·–");
        alphabet.put("B", "–···");
        alphabet.put("C", "–·–·");
        alphabet.put("D", "–··");
        alphabet.put("E", "·");
        alphabet.put("F", "··–·");
        alphabet.put("G", "––·");
        alphabet.put("H", "····");
        alphabet.put("I", "··");
        alphabet.put("J", "·–––");
        alphabet.put("K", "–·–");
        alphabet.put("L", "·–··");
        alphabet.put("M", "––");
        alphabet.put("N", "–·");
        alphabet.put("O", "–––");
        alphabet.put("P", "·––·");
        alphabet.put("Q", "––·–");
        alphabet.put("R", "–·–");
        alphabet.put("S", "···");
        alphabet.put("T", "–");
        alphabet.put("U", "··–");
        alphabet.put("V", "···–");
        alphabet.put("W", "·––");
        alphabet.put("X", "–··–");
        alphabet.put("Y", "––·–");
        alphabet.put("A", "·–");

        alphabet.put("1", "·––––");
        alphabet.put("2", "··–––");
        alphabet.put("3", "···––");
        alphabet.put("4", "····–");
        alphabet.put("5", "·····");
        alphabet.put("6", "–····");
        alphabet.put("7", "––···");
        alphabet.put("8", "–––··");
        alphabet.put("9", "––––·");
        alphabet.put("0", "–––––");

        return alphabet;
    }

    public static String letterToMorse(String text){
        Map<String, String> alphabet = getMorseAphabet();
        String morse = "";

        for(int i = 0; i < text.length(); i++){
            if(i == 0){
                morse += alphabet.get(String.valueOf(text.charAt(i)));
            }else{
                morse += " "+alphabet.get(String.valueOf(text.charAt(i)));
            }
        }

        return morse;
    }
}
