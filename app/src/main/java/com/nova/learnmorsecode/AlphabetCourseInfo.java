package com.nova.learnmorsecode;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.nova.learningframework.CourseInfo;
import com.nova.learningframework.Question;
import com.nova.learnmorsecode.questionFrame_letter.QuestionLetterFrame;
import com.nova.learnmorsecode.questionFrame_letter.QuestionLightFrame;
import com.nova.learnmorsecode.questionFrame_letter.QuestionMorseFrame;
import com.nova.learnmorsecode.questionFrame_letter.QuestionMorseTaskFrame;
import com.nova.learnmorsecode.questionFrame_letter.QuestionSoundFrame;

import java.util.ArrayList;
import java.util.Random;

import static com.nova.learningframework.Courselist.LAST_CLASS;
import static com.nova.learnmorsecode.auxiliary.MorseInfo.letterToMorse;

public class AlphabetCourseInfo extends CourseInfo {

    public SharedPreferences prefs;

    public AlphabetCourseInfo(Context ctx){
        super(R.drawable.morse,0xff303030,"Learn Morse\nAlphabet","alphabet_course_key",ctx,false);
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    @Override
    public Class getNextActivity(){
        ArrayList<Class> question_list = new ArrayList<>();
        question_list.add(QuestionLetterFrame.class);
        question_list.add(QuestionLightFrame.class);
        question_list.add(QuestionMorseFrame.class);
        question_list.add(QuestionSoundFrame.class);
        question_list.add(QuestionMorseTaskFrame.class);

        Log.i("getNextActivity","last "+prefs.getString(LAST_CLASS,""));


        Class cl = question_list.get(new Random().nextInt(question_list.size()));
        prefs.edit().putString(cl.getName(),"").commit();

        return cl;
    }

    @Override
    public int[] getLevels(){
        return new int[]{
                0,3,6,15,35,55,75,95,115,135,155,175,195,215,235,255,275,295,315,335,355,375,395,415,435,455,475
        };
    }

    public  String levelLetter(){
        switch (getLevel()){
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            case 8:
                return "H";
            case 9:
                return "I";
            case 10:
                return "J";
            case 11:
                return "K";
            case 12:
                return "L";
            case 13:
                return "M";
            case 14:
                return "N";
            case 15:
                return "O";
            case 16:
                return "P";
            case 17:
                return "Q";
            case 18:
                return "R";
            case 19:
                return "S";
            case 20:
                return "T";
            case 21:
                return "U";
            case 22:
                return "V";
            case 23:
                return "W";
            case 24:
                return "X";
            case 25:
                return "Y";
            case 26:
                return "Z";
            default:
                return "C";
        }
    }

    public Question getQuestionLetter(){
        String[] letters;
        float weight = 1f;
        String[] words = new String[]{};

        switch (getLevel()){
            case 1:
                letters = new String[]{"A"};
                break;
            case 2:
                letters = new String[]{"A","B"};
                break;
            case 3:
                letters = new String[]{"A","B","C"};
                break;
            case 4:
                letters = new String[]{"A","B","C","D"};
                break;
            case 5:
                letters = new String[]{"A","B","C","D","E"};
                break;
            case 6:
                letters = new String[]{"A","B","C","D","E","F"};
                break;
            case 7:
                letters = new String[]{"A","B","C","D","E","F","G"};
                break;
            case 8:
                letters = new String[]{"A","B","C","D","E","F","G","H"};
                break;
            case 9:
                letters = new String[]{/*"A","B","C","D","E",*/"F","G","H","I"};
                break;
            case 10:
                letters = new String[]{/*"A","B","C","D","E","F",*/"G","H","I","J"};
                break;
            case 11:
                letters = new String[]{/*"A","B","C","D","E","F","G",*/"H","I","J","K"};
                break;
            case 12:
                letters = new String[]{/*"A","B","C","D","E","F","G","H",*/"I","J","K","L"};
                break;
            case 13:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I",*/"J","K","L","M"};
                break;
            case 14:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J",*/"K","L","M","N"};
                break;
            case 15:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K",*/"L","M","N","O"};
                break;
            case 16:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L",*/"M","N","O","P"};
                break;
            case 17:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M",*/"N","O","P","Q"};
                break;
            case 18:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N",*/"O","P","Q","R"};
                break;
            case 19:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",*/"P","Q","R","S"};
                break;
            case 20:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",*/"Q","R","S","T"};
                break;
            case 21:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",*/"R","S","T","U"};
                break;
            case 22:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",*/"S","T","U","V"};
                break;
            case 23:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",*/"T","U","V","W"};
                break;
            case 24:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",*/"U","V","W","X"};
                break;
            case 25:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",*/"V","W","X","Y"};
                break;
            case 26:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",*/"W","X","Y","Z"};
                break;
            default:
                letters = new String[]{"A","B","C","D","E"};
                break;
        }

        String normal = "";
        Random r = new Random();

        normal = letters[r.nextInt(letters.length)];

        return new Question(letterToMorse(normal.toUpperCase()),normal.toUpperCase(),key);
    }

    @Override
    public Question getQuestion(){
        String[] letters;
        float weight = 1f;
        String[] words = new String[]{};

        switch (getLevel()){
            case 1:
                letters = new String[]{"A"};
                break;
            case 2:
                letters = new String[]{"A","B"};
                break;
            case 3:
                letters = new String[]{"A","B","C"};
                break;
            case 4:
                letters = new String[]{"A","B","C","D"};
                break;
            case 5:
                letters = new String[]{"A","B","C","D","E"};
                break;
            case 6:
                letters = new String[]{"A","B","C","D","E","F"};
                break;
            case 7:
                letters = new String[]{"A","B","C","D","E","F","G"};
                weight = 0.9f;
                words = new String[]{"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge"};
                break;
            case 8:
                letters = new String[]{"A","B","C","D","E","F","G","H"};
                weight = 0.9f;
                words = new String[]{/*"age","bad","bag","bed","cab",*/"aged","cafe","cage","deaf","face","fade","badge",
                "chef","each","haed","beach"};
                break;
            case 9:
                letters = new String[]{/*"A","B","C","D","E",*/"F","G","H","I"};
                weight = 0.75f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe",*/"cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if"};
                break;
            case 10:
                letters = new String[]{/*"A","B","C","D","E","F",*/"G","H","I","J"};
                weight = 0.70f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade",*/"badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                };
                break;
            case 11:
                letters = new String[]{/*"A","B","C","D","E","F","G",*/"H","I","J","K"};
                weight = 0.60f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each",*/"haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack",};
                break;
            case 12:
                letters = new String[]{/*"A","B","C","D","E","F","G","H",*/"I","J","K","L"};
                weight = 0.55f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide",*/"ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked"};
                break;
            case 13:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I",*/"J","K","L","M"};
                weight = 0.50f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal",*/"jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham",
                "helm","him","image","jam","lamb","lame","lime","limb","made","make","meal","medal","mice","mild","milk"};
                break;
            case 14:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J",*/"K","L","M","N"};
                weight = 0.40f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail",*/"laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"again","and","animal","bank","begin","behind","can","challenge","chance","change","end","feeling","final","financial","find","fine","hand","hang","imagine","in","indeed","kind","land","line","machine","main","man","manage","mean","mind","name","need","nice"

                };
                break;
            case 15:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K",*/"L","M","N","O"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail",*/"laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham",
                        "ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"

                };
                break;
            case 16:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L",*/"M","N","O","P"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked",*/"aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham",
                        "ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come","common","do","dog","economic",
                        "food","go","goal","good","hold","home","job","join","local","long","look","million","model","no","none",
                        "of","off","office","official", "oh","oil","ok","old","on","once","one"
                        ,"campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"

                };
                break;
            case 17:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M",*/"N","O","P","Q"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,*/"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one","quad"
                        ,"campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"

                };
                break;
            case 18:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N",*/"O","P","Q","R"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,*/"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"according","agree","air","appear","approach","area","arm","bar","before","board","born","break","bring","camera","cancer","car","card","care","career","chair","charge","clear","color","commercial","compare","concern","conference","crime","dark","degree","difference","dinner","door","dream","drop","far","fear","federal","finger","fire","firm","floor","for","force","foreign","form","former","free","friend","from","garden","general","girl","green","hair","hard","hear","her","here","large","leader","learn","major","manager","marriage","member","modern","more","morning","near","nor","offer","officer","or","order","paper","per","perform","performance","period","poor","prepare","price","problem","program","race","radio","range","reach","read","real","record","red","region","remain","remember","rich","road","rock","role","room"

                };
                break;
            case 19:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",*/"P","Q","R","S"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,*/"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                };
                break;
            case 20:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",*/"Q","R","S","T"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,*/"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"

                };
                break;
            case 21:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",*/"R","S","T","U"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,*/"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"

                };
                break;
            case 22:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",*/"S","T","U","V"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,*/"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"
                        ,"individual","investment","involve","leave","level","live","love","move","movement","movie","never","over","positive","prevent","private","prove","provide","receive","remove","reveal","save","serve","service","seven","several","television","themselves","travel","value","various","victim","violence","visit","voice","vote"

                };
                break;
            case 23:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",*/"T","U","V","W"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,*/"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"
                        ,"individual","investment","involve","leave","level","live","love","move","movement","movie","never","over","positive","prevent","private","prove","provide","receive","remove","reveal","save","serve","service","seven","several","television","themselves","travel","value","various","victim","violence","visit","voice","vote"
                        ,"two","view","wait","walk","wall","want","war","watch","water","we","weapon","wear","week","weight","well","west","western","what","whatever","when","where","whether","which","while","white","who","whole","whom","whose","wide","wife","will","win","wind","window","wish","with","within","without","woman","wonder","word","work","worker","world","would","write","writer","wrong"

                };
                break;
            case 24:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",*/"U","V","W","X"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,*/"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"
                        ,"individual","investment","involve","leave","level","live","love","move","movement","movie","never","over","positive","prevent","private","prove","provide","receive","remove","reveal","save","serve","service","seven","several","television","themselves","travel","value","various","victim","violence","visit","voice","vote"
                        ,"two","view","wait","walk","wall","want","war","watch","water","we","weapon","wear","week","weight","well","west","western","what","whatever","when","where","whether","which","while","white","who","whole","whom","whose","wide","wife","will","win","wind","window","wish","with","within","without","woman","wonder","word","work","worker","world","would","write","writer","wrong"
                        ,"box","example","executive","exist","expect","experience","expert","explain","next","six","tax"

                };
                break;
            case 25:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",*/"V","W","X","Y"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"
                        ,*/"individual","investment","involve","leave","level","live","love","move","movement","movie","never","over","positive","prevent","private","prove","provide","receive","remove","reveal","save","serve","service","seven","several","television","themselves","travel","value","various","victim","violence","visit","voice","vote"
                        ,"two","view","wait","walk","wall","want","war","watch","water","we","weapon","wear","week","weight","well","west","western","what","whatever","when","where","whether","which","while","white","who","whole","whom","whose","wide","wife","will","win","wind","window","wish","with","within","without","woman","wonder","word","work","worker","world","would","write","writer","wrong"
                        ,"box","example","executive","exist","expect","experience","expert","explain","next","six","tax"
                        ,"pay","physical","play","player","policy","pretty","probably","property","quality","quickly","ready","reality","really","recently","responsibility","say","security","simply","society","somebody","stay","story","strategy","study","style","suddenly","system","technology","theory","they","today","try","type","usually","very","way","why","worry","yard","yeah","year","yes","yet","you","young","your","yourself"

                };
                break;
            case 26:
                letters = new String[]{/*"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",*/"W","X","Y","Z"};
                weight = 0.20f;
                words = new String[]{/*"age","bad","bag","bed","cab","aged","cafe","cage","deaf","face","fade","badge",
                        "chef","each","haed","beach","big","bid","chief","dice","dig","hide","ice","idea","if","jade",
                        "back","bike","cake","deck","fake","faked","hack","hike","jack","ale","alike","bagel","balk","blah",
                        "cable","calf","chalk","child","deal","dial","elf","fable","fail","file","flag","fled","glad","glide","half",
                        "heal","held","ideal","jail","laid","leaf","led","lick","lie","lied","liked","aim","amid","balm","beam",
                        "blame","calm","came","camel","claim","climb","dam","dim","email","fame","film","flame","gamble","game","ham"
                        ,"ago","alone","along","among","become","billion","blood","book","choice","coach","cold","college","come",
                        "common","do","dog","economic","food","go","goal","good","hold","home","job","join","local","long","look",
                        "million","model","no","none","of","off","office","official","oh","oil","ok","old","on","once","one"
                        ,"quer","quad","quest","campaign","deep","happen","help","hope","keep","open","page","pain","peace","people","phone","pick","piece","place","plan","police"
                        ,"across","address","also","as","ask","base","case","choose","class","close","consider","decision","defense","describe","design","disease","else","finish","fish","gas","glass","herself","himself","his","increase","inside","less","lose","loss","message","miss","mission","pass","perhaps","person","personal","possible","process","professional","professor","raise","reason","research","respond","response","rise","risk","safe","same","scene","school","science","score","sea","season","second","see","seek","seem","sell","send","senior","sense","series","shake","share","she","side","sign","similar","simple","since","sing","single","skill","skin","small","smile","so","social","soldier","some","someone","son","song","soon","space","speak","special","specific","speech","spend","spring"
                        ,"sport","staff","stage","stand","standard","star","start","state","statement","station","step","still","stock","stop","store","street","strong","table","take","talk","task","teach","teacher","team","tell","ten","tend","term","test","than","thank","that","the","their","them","then","there","these","thing","think","third","this","those","threat","three","time","to","together","tonight","too","top","total","trade","traditional","training","treat","treatment","tree","trial","trip"
                        ,"situation","sound","source","south","southern","structure","student","stuff","subject","success","successful","such","suffer","suggest","summer","support","sure","surface","though","thought","thousand","through","throughout","thus","tough","trouble","true","truth","turn","under","understand","unit","until","up","upon","us","use"
                        ,"individual","investment","involve","leave","level","live","love","move","movement","movie","never","over","positive","prevent","private","prove","provide","receive","remove","reveal","save","serve","service","seven","several","television","themselves","travel","value","various","victim","violence","visit","voice","vote"
                        ,*/"two","view","wait","walk","wall","want","war","watch","water","we","weapon","wear","week","weight","well","west","western","what","whatever","when","where","whether","which","while","white","who","whole","whom","whose","wide","wife","will","win","wind","window","wish","with","within","without","woman","wonder","word","work","worker","world","would","write","writer","wrong"
                        ,"box","example","executive","exist","expect","experience","expert","explain","next","six","tax"
                        ,"pay","physical","play","player","policy","pretty","probably","property","quality","quickly","ready","reality","really","recently","responsibility","say","security","simply","society","somebody","stay","story","strategy","study","style","suddenly","system","technology","theory","they","today","try","type","usually","very","way","why","worry","yard","yeah","year","yes","yet","you","young","your","yourself"
                        ,"citizen","magazine","organization","realize","recognize","size"

                };
                break;
            default:
                letters = new String[]{"A","B","C","D","E"};
                break;
        }

        String normal = "";
        Random r = new Random();

        int prob = r.nextInt(100)+1;

        if(prob > (100*weight)){
            normal = words[r.nextInt(letters.length)];
        }else{
            int len = r.nextInt(3)+1;
            for(int i = 0; i < len; i++){
                normal += letters[r.nextInt(letters.length)];
            }
        }

        return new Question(letterToMorse(normal.toUpperCase()),normal.toUpperCase(),key);
    }

}
