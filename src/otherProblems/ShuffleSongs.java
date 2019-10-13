package otherProblems;//What will be the result of compiling and running the following Java program?

import java.util.*;

class ShuffleSongs
{

    public static void main(String[] args)
    {
        List<String> songs = new ArrayList<>(100);
        songs.add("a");
        songs.add("b");
        songs.add("c");
        songs.add("d");
        songs.add("e");
        songs.add("f");
        songs.add("g");
        songs.add("h");
        System.out.println(songs);
        shuffleSongs(songs);
        System.out.println(songs);
    }

    private static void shuffleSongs(List<String> songs) {
        for(int i = songs.size()/2; i<songs.size(); i++){
            int randomPosition = randomNumberBetween(songs.size()/2);
            String temp =  songs.get(randomPosition);
            songs.set(randomPosition, songs.get(i));
            songs.set(i, temp);
        }
    }

    private static int randomNumberBetween(int end){
       Double aDouble = Math.random();
       Double randomDouble = aDouble*end;
       return randomDouble.intValue();
    }
}
