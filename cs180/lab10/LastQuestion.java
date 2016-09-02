public class LastQuestion{
    public static int magic(String value){
        try{
            int x = Integer.parseInt(value);
            return x;
        }
        catch(Exception e){
            System.out.println("Some exception occured.");
            return 0;
        }
        finally{
            return -1;
        }
    }
    public static void main(String[] args){
        LastQuestion test = new LastQuestion();
        int y = test.magic("HERE");
    }
}