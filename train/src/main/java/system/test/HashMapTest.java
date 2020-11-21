package system.test;

import org.junit.Test;


public class HashMapTest {

    @Test
    public void run1(){
        int totalCount=6;
        int row=5;
        int totalPage = totalCount%row ==0?(totalCount/row):(totalCount/row+1);
        //System.out.println(totalPage);

        long l = System.currentTimeMillis();
        System.out.println(l);
       /* Food food=new Food();
        food.setId(123);
        food.setStock(20);
        FoodItem item=new FoodItem( food,3);
        Cart cart=new Cart();

        cart.foodlist.put(food.getId(),item);
        FoodItem foodItem = cart.foodlist.get(food.getId());
        System.out.println(foodItem);
        if (cart.foodlist.containsKey(food.getId())){
            FoodItem foodItem1 = cart.foodlist.get(food.getId());
            foodItem1.setNumber(foodItem1.getNumber()+2);
        }
        System.out.println(cart.foodlist.get(food.getId()));

*/
    }
}
