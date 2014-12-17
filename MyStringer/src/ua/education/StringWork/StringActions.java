package ua.education.StringWork;

/**
 * Created by illia on 28.11.14.
 */
public interface StringActions {

    public  String trimLeader(String str);
    public  String trimTrailer(String str);
    public  String trimBoth(String str);
    public  String trunkMessage(String replacement, String message);
    public  boolean isDigit(String str);
    public  boolean isLetter(String str);
    public  boolean isMix(String str);
    public  String append(String str, String add);
    public  String setLength(int i);
    public  String trunkLength(String str, int trunklength);
    public  String addLeaderSymbols(String str,String leaderSymbol);
    public  String addTrailerSymbols(String str,String trailerSymbol);

}
