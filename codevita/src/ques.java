
import java.util.ArrayList;
import java.util.Scanner;

public class ques {
    static int total,len;
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String readString = scanner.nextLine();
         String[] st=readString.split(" "); 
         int weights[]=new int[st.length];
         len=st.length;
         for(int i=0;i<len;i++)
            weights[i]=Integer.parseInt(st[i]);
         int temp;
         for(int i=0;i<len;i++)
          {
            for(int j=i+1;j<len;j++)
                if(weights[i]<weights[j])
                {
                   // System.out.println(weights[i]+"hoo"+weights[j]);
                    temp=weights[i];
                    weights[i]=weights[j];
                    weights[j]=temp;            
                }
          }
         for(int i=0;i<len;i++)
             System.out.println(weights[i]);
            
         total=scanner.nextInt();
         generateSubsets(weights, len, total);
        //System.out.println(s.size());
         removeDuplicates();
         for(int i=0;i<s.size();i++)
            System.out.println(s.get(i));
    }    
static void removeDuplicates()
{
    String temp;
    for(int i=0;i<s.size()-1;i++)
    {
        temp=s.get(i);
        for(int j=i+1;j<s.size();j++)
            {
                if(temp.equals(s.get(j)))
                {
                    s.remove(j);j--;
                }
            }
    }
}
    static int total_nodes;
    static ArrayList<String> s=new ArrayList<String>();
    static int sum;
    static void printSubset(int A[], int size)
    {
        int i;
    
        String str="[",st;
        sum=0;
        for( i = 0; i < size; i++)
        {
            str+=A[i]+",";
            sum+=A[i];
        }
        st=str.substring(0,str.length()-1);
        st+="]";
        if(sum==total)
        {
            s.add(st);
        }
    }

    static void subset_sum(int s[], int t[],
                int s_size, int t_size,
                int sum, int ite,
                int  target_sum)
        {
             int i;
             total_nodes++;
             if( target_sum == sum )
                {
       
                   printSubset(t, t_size);
                   if(ite!=len)
                   subset_sum(s, t, s_size, t_size-1, sum - s[ite], ite + 1, target_sum);
                   return;
                }
        if(sum> target_sum)
         return;
        else
         {
            if(ite!=len)
            for( i = ite; i < s_size; i++ )
            {
                t[t_size] = s[i];
                if(i!=len)
                subset_sum(s, t, s_size, t_size + 1, sum + s[i], i + 1, target_sum);
            }
        }
}

    static void generateSubsets(int s[], int size, int target_sum)
    {
        int[] tuplet_vector=new int[size];
    
        subset_sum(s, tuplet_vector, size, 0, 0, 0, target_sum);

    }

}


