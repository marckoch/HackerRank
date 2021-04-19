package hackerrank.projecteuler.from051to075;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Poker hands
 * @author marckoch
 */
public class PE054 {
    private static int value(String card) {
        switch (card.charAt(0)) {
            case 'A': return 0xE;
            case 'K': return 0xD;
            case 'Q': return 0xC;
            case 'J': return 0xB;
            case 'T': return 0xA;
            default: return Character.getNumericValue(card.charAt(0));
        }
    }
    
    private static int determineHand(String[] cards) {
        orderCards(cards);
        int[] values = values(cards);
        
        int hexValue = hexValue(values);
            
        boolean isFlush = isFlush(cards);
        int highCardStraight = isStraight(values); 
        boolean isStraight = highCardStraight > 0;
        
        Map<Integer, Integer> freq = frequencies(values);
      
        if (isFlush && isStraight) {
            System.err.println(Arrays.toString(cards) + " --> Straight flush, value " + highCardStraight);
            return 10_000_000 + highCardStraight;
        }
        
        if (isFourOfAKind(freq)) {
            System.err.println(Arrays.toString(cards) + " --> 4 of a kind, value " + Integer.toHexString(hexValue));
            return 9_000_000 + hexValue;
        } 
                
        int valueFullHouse = isFullHouse(freq);
        if (valueFullHouse>0) {
            System.err.println(Arrays.toString(cards) + " --> full house, value " + valueFullHouse);
            return 8_000_000 + valueFullHouse;
        } 
        
        if (isFlush) {
            System.err.println(Arrays.toString(cards) + " --> flush");
            return 7_000_000;
        } 
        
        if (isStraight) {
            System.err.println(Arrays.toString(cards) + " --> straight, high " + highCardStraight);
            return 6_000_000 + highCardStraight;
        } 
        
        int value3OfAKind = isThreeOfAKind(freq);
        if (value3OfAKind>0) {
            System.err.println(Arrays.toString(cards) + " --> 3 of a kind, value " + value3OfAKind);
            return 5_000_000 + value3OfAKind;
        }
        
        int numberOfPairs = getNumberOfPairs(freq);
        
        if (numberOfPairs==2) {
            TreeSet<Integer> valueOfPairs = new TreeSet<>();
            int valueSingleCard=0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    valueSingleCard = entry.getKey();
                } else if (entry.getValue() == 2) {
                    valueOfPairs.add(entry.getKey());
                }
            }
            //int value = 4_000_000 + 16*16*valueHighPair + 16*valueLowCard + valueSingleCard;
            int value = 4_000_000 + valueSingleCard;
            int count=1;
            for (int v : valueOfPairs) {
                value += v*Math.pow(16, count++);
            }
            System.err.println(Arrays.toString(cards) + " --> 2 pair, value " + Integer.toHexString(hexValue));
            return value;
        } else if (numberOfPairs==1) {
            int valuePair=0;
            TreeSet<Integer> valueUnmatchedCards = new TreeSet<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 2) {
                    valuePair = entry.getKey();
                } else if (entry.getValue() == 1) {
                    valueUnmatchedCards.add(entry.getKey());
                }
            }
            int value = 3_000_000 + 16*16*16*valuePair;
            int count =0;
            for (int v : valueUnmatchedCards) {
                value += v*Math.pow(16, count++);
            }
            System.err.println(Arrays.toString(cards) + " --> 1 pair, value " + Integer.toHexString(hexValue));
            return value;
        }
        
        System.err.println(Arrays.toString(cards) + " --> high card, value " + Integer.toHexString(hexValue));
        return hexValue;
    }

    private static boolean isFlush(String[] cards) {
        String lastColor = null;
        for (String card : cards) {
            String color = card.substring(1);
            if (lastColor != null && !lastColor.equals(color))
                return false;
            lastColor = color;
        }
        return true;
    }
    
    private static void orderCards(String[] cards) {
        // System.err.println(Arrays.toString(cards));
        Arrays.sort(cards, (String card1, String card2) -> -(value(card1) - value(card2)));
        // System.err.println(Arrays.toString(cards));
    }
    
    private static int[] values(String[] cards) {
        int[] values = new int[cards.length];
        for (int i=0; i<cards.length; i++) {
            values[i] = value(cards[i]);
        }
        // System.err.println(Arrays.toString(values));
        return values;
    }
    
    private static int hexValue(int[] values) {
        int hexValue = 0;
        for (int value : values) {
            hexValue *= 16;
            hexValue += value;            
        }
        //System.err.println(Arrays.toString(values) + " -> " + Integer.toHexString(hexValue));
        return hexValue;
    }
    
    private static int isStraight(int[] values) {
        System.err.println(Arrays.toString(values));

        // check for A low straight:
        if (Arrays.equals(values, new int[]{value("A_"),5,4,3,2})) {
            return 5;
        }

        int highCard=values[0];
        int lastValue = 0;
        for (int value : values) {
            if (lastValue>0 && value != lastValue-1) 
                return 0;
            lastValue = value;
        }
        return highCard;
    }
    
    private static boolean isFourOfAKind(Map<Integer, Integer> freq) {
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 4) 
                return true;
        }
        return false;
    }
    
    private static int isThreeOfAKind(Map<Integer, Integer> freq) {
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 3) {
                return entry.getKey();
            }                
        }
        return 0;
    }
    
    private static int getNumberOfPairs(Map<Integer, Integer> freq) {
        int pairCount=0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 2) 
                pairCount++;
        }
        return pairCount;
    }
    
    private static int isFullHouse(Map<Integer, Integer> freq) {
        int value = 0;
        boolean has3OfAKind = false;
        boolean hasPair = false;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 3) {
                has3OfAKind=true;
                value = entry.getKey();
            } else if (entry.getValue() == 2) 
                hasPair=true;
        }
        return (hasPair && has3OfAKind) ? value : 0;
    }
    
    private static Map<Integer, Integer> frequencies(int[] values) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int value : values) {
            if (!freq.containsKey(value)) freq.put(value, 0);
            freq.put(value, freq.get(value) + 1);
        }
        //System.err.println(Arrays.toString(values) + " -> " + freq);
        return freq;
    }
    
    public static void main(String[] args) {
        int winsOfPlayer1=0;
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            String[] cards1 = new String[5];
            for (int i=0; i<5; i++) {
                cards1[i] = in.next();
            }
            String[] cards2 = new String[5];
            for (int i=0; i<5; i++) {
                cards2[i] = in.next();
            }
            
            // System.err.println(Arrays.toString(cards1));
            // System.err.println(Arrays.toString(cards2));
            
            System.err.println("--------");
            int hand1 = determineHand(cards1);
            int hand2 = determineHand(cards2);
            
            int winner = hand1 > hand2 ? 1: 2;
            if (winner==1) winsOfPlayer1++;
            System.out.println("Player " + winner);
        }
        //System.out.println("winsOfPlayer1 " + winsOfPlayer1);
    }
}
