

import java.util.Arrays;

public class YunSuan {

    public String getResult(String data){
        data = quKaiFang(data);
        data = quDuiShu(data);
        return Zhongzhui.getResult(data);
    }

    //搞定开方运算
    private String quKaiFang(String data){
        String[] st = data.split("[\\+\\-\\*/^%]");
        for(String a:st){
            if(!(a.toCharArray()[0]=='√'))    continue;
            double shu = Double.valueOf(String.valueOf(Arrays.copyOfRange(a.toCharArray(),1,a.length())));
            data = data.replaceAll(a,Double.toString(Math.sqrt(shu)));
        }
        return data;
    }

    //搞定lg运算
    private String quDuiShu(String data){
        String[] st = data.split("[\\+\\-\\*/^%]");
        for(String a:st){
            if(!a.startsWith("lg"))    continue;
            double shu = Double.valueOf(String.valueOf(Arrays.copyOfRange(a.toCharArray(),2,a.length())));
            data = data.replaceAll(a, Double.toString( Math.log10(shu) ));
        }
        return data;
    }

}
