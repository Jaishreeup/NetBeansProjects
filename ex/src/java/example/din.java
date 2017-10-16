class condition
{int temp;
    void Wait()
    {
        temp=1;
    }
    void signal()
    {
        if(temp==1)
        temp=0;
    }
}
class monitor
{
static final int N=5;
enum  phil_state{ thinking, hungry, eating};
phil_state state[]=new phil_state[N];
//condition self[]=new condition[N];
    void putdown(int i)
    {
        state[i%N]=phil_state.thinking;
        test((i+1)%N);
        test((i+N-1)%N);
    }
    void pickup(int i)
    {
        state[i%N]=phil_state.hungry;
        test(i);
      //  if(state[i]!=phil_state.eating)
  //      self[i].Wait();
    }
    void test(int i)
    {
        if(state[(i+1)%N]!=phil_state.eating&&state[(i+N-1)%N]!=phil_state.eating&&state[i%N]==phil_state.hungry)
        {
            state[i%N]=phil_state.eating;
    //        self[i].signal();
        }
    }
    void init()
    {
        for(int i=0;i<N;i++)
        state[i]=phil_state.thinking;
    }
}
public class din
{
    public static void main(String args[])
    {
        monitor d=new monitor();    
        d.init();
        for(int i=0;i<20;i++)
        {
            d.pickup(i);
            System.out.println("eating philosopher:"+(i%d.N));    
            d.putdown(i);
        }
    }   
}