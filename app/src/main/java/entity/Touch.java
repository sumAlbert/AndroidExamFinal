package entity;

/**
 * Created by dell2 on 2017/6/18.
 */

public class Touch {
    private String name;
    private String tel;
    private String email;
    private String phoneType;
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoneType(String phoneType){
        this.phoneType=phoneType;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public String getName(){
        return this.name;
    }
    public String getTel(){
        return this.tel;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneType(){
        return this.phoneType;
    }
}
