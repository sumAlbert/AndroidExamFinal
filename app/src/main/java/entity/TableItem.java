package entity;

/**
 * Created by wangyan on 2017/6/19.
 */

public class TableItem {
    private int id;
    private String name;
    private double price;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
}
