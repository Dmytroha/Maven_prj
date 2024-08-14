package org.example;
import org.apache.log4j.BasicConfigurator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.Predicate;
import java.util.Stack;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final String OPEN = "([{";
    private static final String CLOSE = ")]}";

    private static final Predicate<Character> isOpen = (Character t)->OPEN.indexOf(t) > -1;
    private static final Predicate<Character> isClose = (Character t)->CLOSE.indexOf(t) > -1;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        /*String jsonFullName = (new Gson()).toJson(new FullName("Dmytro", "Milovanov"));
        LOGGER.info("{}",jsonFullName);*/
        boolean res=true;
        LOGGER.info("{}", res);

        var s = "([{(х=)}]){}][([{}])";
        final Map<Character, Character> charMap = Map.of('(', ')', '[', ']', '{', '}');
        final Deque<Character> charStack = new ArrayDeque<>();
        var result = true;
        //find illegal symbols
        if (!isConstraint(s)) {
            result = false;
            LOGGER.info("isConstraint {}",result );
        }
        for (int i = 0; i < s.length() && result; i++) {
            if (isOpen.test(s.charAt(i))) {
                charStack.push(charMap.get(s.charAt(i)));
                LOGGER.info("charMap.get(s.charAt(i)) ->  ` {} ` ",charMap.get(s.charAt(i)) );
                continue;
            }
            LOGGER.info("charStack - > {}", charStack);
            // check the closing simbls
            char c = charStack.pop();
            LOGGER.info("{}", c);
            if (c!=s.charAt(i)) {
                result = false;
            }
        }
        LOGGER.info("************ result of checking {}", result);
    }
///check constrain before handling string
    private static boolean isConstraint(@NotNull String s) {
        LOGGER.info("------------------------isConstraint");
        if( !((1 < s.length()) && (s.length()<=104)) ) {LOGGER.info("!((1 < s.length()) && (s.length()<=104))"); return false;}
        if(s.length()%2!=0)  {LOGGER.info("s.length()%2{}",false );return false; }// quantity must odd
        if(isClose.test(s.charAt(0)) || isOpen.test(s.charAt(s.length()-1)) ) {
            LOGGER.info("isClose.test(s.charAt(0)) || isOpen.test(s.charAt(s.length()-1)) ");
            return false;} //first open, last close - always

        var result = true; // if changed, check logic below
        for (int i = 0; i < s.length(); i++) {
            //find illegal symbols
            char curChar = s.charAt(i);
            if (!(isOpen.test(curChar) || isClose.test(curChar))) {
                return false;
            }
        }
        return result;
    }

}

