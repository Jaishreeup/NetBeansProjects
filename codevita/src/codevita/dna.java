/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.Scanner;

/**
 *
 * @author JAISHREE UPRETI
 */
class SubseqCounter {

    String seq, subseq;
    int[][] tbl;

    public SubseqCounter(String seq, String subseq) {
        this.seq = seq;
        this.subseq = subseq;
    }

    public int countMatches() {
        tbl = new int[seq.length() + 1][subseq.length() + 1];

        for (int row = 0; row < tbl.length; row++)
            for (int col = 0; col < tbl[row].length; col++)
                tbl[row][col] = countMatchesFor(row, col);

        return tbl[seq.length()][subseq.length()];
    }

    private int countMatchesFor(int seqDigitsLeft, int subseqDigitsLeft) {
        if (subseqDigitsLeft == 0)
            return 1;

        if (seqDigitsLeft == 0)
            return 0;

        char currSeqDigit = seq.charAt(seq.length()-seqDigitsLeft);
        char currSubseqDigit = subseq.charAt(subseq.length()-subseqDigitsLeft);

        int result = 0;

        if (currSeqDigit == currSubseqDigit)
            result += tbl[seqDigitsLeft - 1][subseqDigitsLeft - 1]%mod;

        result += tbl[seqDigitsLeft - 1][subseqDigitsLeft]%mod;

        return result%mod;
    }
}
public class dna {
    static int min(int x,int y)
    {
        return x<y?x:y;
    }
    public static void main(String[] args) {
        String str,temp;
        int count=0,len,min1,min2,flag,counta,countb,countc,countd;
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        obj.nextLine();
        for(int i=1;i<=t;i++)
        {
            flag=0;
            str=obj.nextLine();
            len=str.length();
            counta=0;countb=0;countc=0;countd=0;
            for(int j=0;j<len;j++)
            {
                switch(str.charAt(j))
                {
                    case 'a':counta++;break;
                    case 'b':countb++;break;
                    case 'c':countc++;break;
                    case 'd':countd++;break;
                }
                    
            }
            System.out.println(counta+" "+countb+" "+countc+" "+countd);
            if(counta==0||countb==0||countc==0||countd==0)
                flag=1;
            else
            {
            min1=min(counta,countc);
            min2=min(countb,countd);
             count=0;
            for(int j=1;j<=min1;j++)
                for(int k=1;k<=min2;k++)
                {temp="";
                    for(int l=1;l<=j;l++)
                        temp+="a";
                       for(int l=1;l<=k;l++)
                        temp+="b";
                          for(int l=1;l<=j;l++)
                        temp+="c";
                             for(int l=1;l<=k;l++)
                        temp+="d";
                             int h=new SubseqCounter(str, temp).countMatches();
                             if(h>0)
                                 tstr[s++]=temp;
               count+=h;
                    System.out.println("this "+h+" temp "+temp);
                           
                }
            }
            for(int j=0;j<s;j++)
            {
                
            }
            if(flag==1)
                System.out.println("Case #"+i+": 0");
            else System.out.println("Case #"+i+": "+count);
            }
        
    }
            
    
}
