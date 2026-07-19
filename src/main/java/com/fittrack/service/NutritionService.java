package com.fittrack.service;
import com.fittrack.entity.MealItem; import org.springframework.stereotype.Service; import java.util.*;
@Service public class NutritionService {
 public record Food(double kcal,double protein,double carbs,double fat,double fiber,double sugar,double sodium,String unit){}
 private final Map<String,Food> foods=new LinkedHashMap<>();
 public NutritionService(){
  foods.put("idli",new Food(58,2,12,0.4,0.8,0.2,75,"piece"));
  foods.put("dosa",new Food(133,3.5,18,5,1,0.5,160,"piece"));
  foods.put("boiled egg",new Food(78,6.3,0.6,5.3,0,0.6,62,"piece"));
  foods.put("egg",new Food(78,6.3,0.6,5.3,0,0.6,62,"piece"));
  foods.put("banana",new Food(105,1.3,27,0.4,3.1,14,1,"piece"));
  foods.put("apple",new Food(95,0.5,25,0.3,4.4,19,2,"piece"));
  foods.put("rice",new Food(205,4.3,45,0.4,0.6,0.1,2,"cup"));
  foods.put("sambar",new Food(120,6,18,3,5,4,450,"cup"));
  foods.put("chapati",new Food(104,3,18,3,2.5,0.5,120,"piece"));
  foods.put("chicken breast",new Food(165,31,0,3.6,0,0,74,"100g"));
  foods.put("curd",new Food(98,11,3.4,4.3,0,3.2,364,"cup"));
  foods.put("oats",new Food(150,5,27,3,4,1,0,"40g"));
  foods.put("milk",new Food(122,8,12,4.8,0,12,105,"cup"));
  foods.put("pongal",new Food(212,6,35,6,3,2,500,"cup"));
  foods.put("upma",new Food(192,5,31,6,4,3,350,"cup"));
  foods.put("poha",new Food(206,4,38,5,3,2,300,"cup"));
  foods.put("uttapam",new Food(180,5,28,6,2,2,350,"piece"));
  foods.put("vada",new Food(135,4,16,6,2,1,250,"piece"));
  foods.put("appam",new Food(120,2,25,2,1,2,120,"piece"));
  foods.put("parotta",new Food(260,6,38,10,2,2,450,"piece"));
  foods.put("lemon rice",new Food(260,5,48,6,2,2,500,"cup"));
  foods.put("curd rice",new Food(280,8,48,6,1,5,450,"cup"));
  foods.put("vegetable biryani",new Food(300,7,52,8,5,4,650,"cup"));
  foods.put("chicken biryani",new Food(420,22,55,12,3,3,800,"cup"));
  foods.put("mutton biryani",new Food(480,24,54,18,3,3,850,"cup"));
  foods.put("fish curry",new Food(220,25,8,10,2,3,650,"serving"));
  foods.put("chicken curry",new Food(260,28,10,12,3,4,700,"serving"));
  foods.put("mutton curry",new Food(320,25,10,20,3,4,750,"serving"));
  foods.put("grilled chicken",new Food(220,35,2,8,0,1,300,"serving"));
  foods.put("fried chicken",new Food(320,25,15,18,1,1,650,"serving"));
  foods.put("fish fry",new Food(280,28,8,16,1,1,550,"serving"));
  foods.put("prawn curry",new Food(240,26,9,11,2,3,700,"serving"));
  foods.put("omelette",new Food(154,11,2,12,0,1,250,"2 eggs"));
  foods.put("egg curry",new Food(210,13,8,14,2,3,600,"serving"));
  foods.put("paneer curry",new Food(300,16,12,22,3,5,650,"serving"));
  foods.put("palak paneer",new Food(280,17,11,20,5,4,600,"serving"));
  foods.put("dal",new Food(180,10,28,4,8,3,450,"cup"));
  foods.put("rajma",new Food(220,13,36,4,11,4,500,"cup"));
  foods.put("chana masala",new Food(240,12,38,5,10,6,550,"cup"));
  foods.put("mixed vegetables",new Food(120,5,20,3,7,6,250,"cup"));
  foods.put("potato curry",new Food(180,4,32,5,4,4,450,"cup"));
  foods.put("beans poriyal",new Food(110,4,15,5,6,4,300,"cup"));
  foods.put("carrot poriyal",new Food(100,3,15,5,5,6,280,"cup"));
  foods.put("rasam",new Food(60,2,10,1,2,3,500,"cup"));
  foods.put("chutney",new Food(80,2,8,5,3,2,250,"serving"));
  foods.put("peanut chutney",new Food(120,5,7,9,3,2,250,"serving"));
  foods.put("orange",new Food(62,1.2,15,0.2,3.1,12,0,"piece"));
  foods.put("guava",new Food(68,2.6,14,1,5.4,9,2,"piece"));
  foods.put("papaya",new Food(59,1,15,0.4,2.5,9,2,"cup"));
  foods.put("watermelon",new Food(46,0.9,12,0.2,0.6,9,2,"cup"));
  foods.put("mango",new Food(135,1.1,35,0.6,3.7,31,2,"piece"));
  foods.put("grapes",new Food(104,1.1,27,0.2,1.4,23,3,"cup"));
  foods.put("almonds",new Food(164,6,6,14,3.5,1.2,0,"28g"));
  foods.put("peanuts",new Food(166,7,6,14,2.4,1.2,5,"28g"));
  foods.put("sprouts",new Food(100,7,18,1,6,4,20,"cup"));
  foods.put("bread",new Food(80,3,15,1,1,2,150,"slice"));
  foods.put("whole wheat bread",new Food(75,4,13,1,2,2,140,"slice"));
  foods.put("sandwich",new Food(250,10,35,8,4,5,550,"serving"));
  foods.put("pizza",new Food(285,12,36,10,2.5,4,640,"slice"));
  foods.put("burger",new Food(350,18,35,16,3,7,700,"serving"));
  foods.put("noodles",new Food(300,8,48,9,3,5,750,"serving"));
  foods.put("tea with milk",new Food(80,2,12,3,0,10,40,"cup"));
  foods.put("coffee with milk",new Food(90,3,12,3,0,10,50,"cup"));
  foods.put("buttermilk",new Food(60,3,7,2,0,5,200,"cup"));
 }
 public Map<String,Object> search(String q){
  String x=q==null?"":q.toLowerCase(); List<Map<String,Object>> result=new ArrayList<>();
  foods.forEach((name,f)->{if(name.contains(x))result.add(Map.of("name",name,"unit",f.unit,"calories",f.kcal,"protein",f.protein,"carbohydrates",f.carbs,"fat",f.fat,"fiber",f.fiber,"sugar",f.sugar,"sodiumMg",f.sodium));});
  return Map.of("success",true,"data",result);
 }
 public void populate(MealItem x){
  String key=x.foodName==null?"":x.foodName.trim().toLowerCase(); Food f=foods.get(key);
  if(f==null) throw new IllegalArgumentException("Food not found in local nutrition catalog. Search and select a supported food.");
  double q=x.quantity==null||x.quantity<=0?1:x.quantity;
  x.unit=f.unit; x.calories=round(f.kcal*q);x.protein=round(f.protein*q);x.carbohydrates=round(f.carbs*q);x.fat=round(f.fat*q);x.fiber=round(f.fiber*q);x.sugar=round(f.sugar*q);x.sodiumMg=round(f.sodium*q);
  classify(x);
 }
 private void classify(MealItem x){int good=(x.protein>=10?1:0)+(x.fiber>=5?1:0),bad=(x.sugar>20?1:0)+(x.sodiumMg>800?1:0)+(x.fat>30?1:0);if(good>=1&&bad==0){x.healthRating="HEALTHY";x.healthReason="Good protein/fiber profile without a high sugar, sodium or fat flag.";}else if(bad>=2){x.healthRating="UNHEALTHY";x.healthReason="Two or more high sugar, sodium or fat flags were detected.";}else{x.healthRating="MODERATE";x.healthReason="Mixed nutrition profile; balance the day with protein and fiber-rich whole foods.";}}
 private double round(double v){return Math.round(v*10.0)/10.0;}
}
