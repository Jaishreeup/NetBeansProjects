package commonmistakes;
interface t{}
class a implements t
{}
class big extends a
{}
class c extends big
{
}
class exam
{
    public static void main(String args[])
    {
        c obj=new c();
        System.out.println(obj instanceof a);
        System.out.println(obj instanceof t);
    }
}