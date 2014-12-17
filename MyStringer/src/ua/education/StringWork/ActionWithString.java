package ua.education.StringWork;

/**
 * Created by illia on 28.11.14.
 */
public class ActionWithString implements StringActions {

    public String trimLeader(String str){

        StringBuilder s = new StringBuilder(str);


        for (int i=0;i<s.length();i++){
           if( s.charAt(0) == ' '){
               s.deleteCharAt(i--);

           }

        }
        return  s.toString();

    }

    public String trimTrailer(String str){

        StringBuilder s = new StringBuilder(str);


        for (int i=s.length()-1; i>0;i--){

            if(s.charAt(s.length()-1) == ' '){
                s.deleteCharAt(i);

            }

        }
        return  s.toString();

    }

    public String trimBoth(String str){

        StringBuilder s = new StringBuilder(str);

       trimLeader(str);
       trimTrailer(str);
return str;
    }

    public String trunkMessage(String replacement, String message){

        String replacement1 = replacement.replaceAll(message,"");

        return replacement1;
    } // замена вхождений

    public boolean isDigit(String str){
        /*
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(str);
        return m.matches();*/

        StringBuilder s = new StringBuilder(str);
        boolean flag = false;

        for (int i = 0; i <str.length() ; i++) {
            if(Character.isDigit(s.charAt(i))){
                flag = true;
            }else{
            flag = false;
            break;}
        }

        return flag;

    }

    public boolean isLetter(String str){
       /* Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(str);
        return m.matches();*/

        StringBuilder s = new StringBuilder(str);
        boolean flag = false;

        for (int i = 0; i <str.length() ; i++) {
            if(Character.isLetter(s.charAt(i))){
                flag = true;
            }else{

            flag = false;
            break;}
        }

        return flag;
    }

    public boolean isMix(String str){
        if (!isDigit(str)&&!isLetter(str)){
            return true;
        }else{
            return false;
        }

    }

    public String append(String str, String add){
        StringBuilder builder = new StringBuilder(str);

        return builder.append(add).toString();
    }

    public String setLength(int i){
        char str [] = new char[i];
        return  str.toString();
    }

    public String trunkLength(String str, int trunklength){

        StringBuilder s = new StringBuilder(str);

        if (trunklength> s.length()){

            while (trunklength>s.length()){
                s.append(" ");
            }

        }
            if (trunklength == s.length()){
                return s.toString();
            }
            else
            s.delete(trunklength,s.length());



        return s.toString();
    }

    public String addLeaderSymbols(String str, String leaderSymbol){

        return leaderSymbol+str;

    }

    @Override
    public String addTrailerSymbols(String str, String trailerSymbol) {
        return str+trailerSymbol;
    }

    public static void main(String[] args) {


//        System.out.println(trimBoth("    dsadasd     "));
    }
}
