import java.util.*;

class FoodRatings {
    private static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> foodMap;                 // foodName -> Food
    private Map<String, TreeSet<Food>> cuisineMap;     // cuisine -> sorted foods

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);

            cuisineMap
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>(
                    (a, b) -> {
                        if (a.rating != b.rating) return b.rating - a.rating; // higher rating first
                        return a.name.compareTo(b.name);                     // lexicographically smaller
                    }
                ))
                .add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);

        // Remove old record
        cuisineMap.get(f.cuisine).remove(f);

        // Update rating
        f.rating = newRating;

        // Re-insert updated record
        cuisineMap.get(f.cuisine).add(f);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}
