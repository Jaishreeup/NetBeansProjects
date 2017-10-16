
import java.util.Scanner;

public class q2 
{
    public static void main(String[] args) 
    {
        int n,wordpass,iMin,temp1,numpass,i,len,k=0,j,turn,num[] = null;
        String str,temp;
        String[] arr,word=null;
        Scanner obj=new Scanner(System.in);
        n=obj.nextInt();
        obj.nextLine();
        for(j=0;j<n;j++)
        {
        k=0;
        str=obj.nextLine();
        arr=str.split(" ");
        len=arr.length;
        word=new String[len/2];
        num=new int[len/2];
        for(i=0;i<len;i+=2)
        {            
                word[k]=arr[i].toLowerCase();
                num[k]=Integer.parseInt(arr[i+1]);
                k++;
        }
        turn=obj.nextInt();
        if(turn%2==0)
        {
            wordpass=turn/2;
            numpass=turn/2;
        }
        else
        {
             wordpass=turn/2+1;
             numpass=turn/2;
        }
        for(int t=0;t<wordpass;t++)
        {
            iMin = t;
            for (int m = t+1; m <k; m++) 
            {
                if (word[m].compareTo(word[iMin])<0) 
                {
                   iMin = m;
                }
            }

          if(iMin != t) {
             temp=word[t];
             word[t]=word[iMin];
             word[iMin]=temp;
            }
        }
        for(int t=0;t<numpass;t++)
        {
            iMin = t;
            for (int m = t+1; m <k; m++) {
         
                if (num[m]<num[iMin]) {
            /* found new minimum; remember its index */
            iMin = m;
            }
            }

          if(iMin != t) {
             temp1=num[t];
             num[t]=num[iMin];
             num[iMin]=temp1;
            }
        }
         System.out.print(word[0]+" "+num[0]);
        for(int m=1;m<k;m++)
            System.out.print(" "+word[m]+" "+num[m]);
        System.out.println();
        obj.nextLine();
     }
   }
}