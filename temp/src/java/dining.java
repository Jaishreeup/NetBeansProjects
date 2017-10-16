
#define N 5 /* Number of philosphers */
#define RIGHT(i) (((i)+1) %N)
#define LEFT(i) (((i)==N) ? 0 : (i)+1)
typedef enum { THINKING, HUNGRY, EATING } phil_state;
phil_state state[N];
semaphore mutex =1;
semaphore s[N]; /* one per philosopher, all 0 */
public void P(int S)
{
        while (S==0) {}
        S=0;
}
public void V(int S)
{
        S=1;
}

public void get_forks(int i) {
state[i] = HUNGRY;
while ( state[i] == HUNGRY ) {
P(mutex);
if ( state[i] == HUNGRY &&
state[LEFT] != EATING &&
state[RIGHT(i)] != EATING ) {
state[i] = EATING;
V(s[i]);
}
V(mutex);
P(s[i]);
}
}
void put_forks(int i) {
P(mutex);
state[i]= THINKING;
if ( state[LEFT(i)] == HUNGRY ) V(s[LEFT(i)]);
if ( state[RIGHT(i)] == HUNGRY) V(s[RIGHT(i)]);
V(mutex);
}
void philosopher(int process) {
while(1) {
think();
get_forks(process);
eat();
put_forks();
}
}