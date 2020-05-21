package dulk.baseMan;

public class ConreteFan implements Fan{
    public String fanName;

    public  ConreteFan(String name){
        this.fanName=name;
    }

    @Override
    public  void updata(String message){
        System.out.println("粉丝"+fanName+"收到了\""+message+"\"这条信息");
    }
}
